import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Cafe_UI extends JFrame {

    private JPanel uiPanel;
    private JLabel cafeTitle;
    private JPanel receiptContainer;
    private JTextField customerName;
    private JTextField customerEntry;
    private JPanel custInputContainer;
    private JTextArea orderScreen;
    private JPanel contentContainer;
    private JTextField txtFldTotal;
    private JButton payButton;
    private JLabel totalLabel;
    private JButton coffeeBtn;
    private JButton juiceBtn;
    private JButton teaBtn;
    private JPanel coffeeMenu;
    private JPanel selectionMenu;
    private JPanel printReceipt;
    private JLabel coffeeLabel;
    private JLabel juiceLabel;
    private JLabel teaLabel;


    private Coffee_Selections coffeeSelections;
    private List<Order> orders;


    public Cafe_UI(){
        setTitle("Cafe UI");

        setContentPane(uiPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        orders = new ArrayList<>();


        CardLayout cardLayout = new CardLayout();
        selectionMenu.setLayout(cardLayout);
        selectionMenu.add(coffeeMenu, "CoffeeMenu");



        coffeeSelections = new Coffee_Selections(cardLayout, selectionMenu, this);
        selectionMenu.add(coffeeSelections.getCoffeeSelectionsUi(), "CoffeeSelections");

        Juice_Selections juiceSelections = new Juice_Selections(cardLayout, selectionMenu, this);
        selectionMenu.add(juiceSelections.getJuiceSelectionsUI(), "JuiceSelections");


        coffeeBtn.addActionListener(new SwitchPanelToCoffeSelections("coffee"));
        coffeeBtn.setIcon(ImageUtil.resizeImage("/logo/coffee-cup.png",50,50));

        juiceBtn.addActionListener(new SwitchPanelToJuiceSelections());
        juiceBtn.setIcon(ImageUtil.resizeImage("/logo/juice.png", 50, 50));

        teaBtn.addActionListener(new SwitchPanelToCoffeSelections("tea"));
        teaBtn.setIcon(ImageUtil.resizeImage("/logo/tea.png", 50,50));

        payButton.addActionListener(e -> paymentVerification());





        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //maximize GUI window on launch
        setExtendedState(Frame.MAXIMIZED_BOTH);
        uiPanel.setPreferredSize(new Dimension(getWidth(),getHeight()));
        pack();

    }

    public void addOrder(Order order){
        orders.add(order);
        updateOrderScreen();
        updateTotal();
    }

    public void updateOrderScreen(){
        StringBuilder sb = new StringBuilder();
        for(Order order: orders){
            sb.append(order.printOrder()).append('\n');
        }
        orderScreen.setText(sb.toString());
    }

    public void updateTotal(){
        double total = orders.stream().mapToDouble(Order::getItemPrice).sum();
        txtFldTotal.setText(String.format("₱ %.2f", total));
    }

    public void paymentVerification(){
        int response = JOptionPane.showOptionDialog(this,
                "Confirming Payment...",
                "Verifying Payment",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Confirm", "Cancel"},
                "Confirm"
        );
        if(response == JOptionPane.YES_OPTION){
            postDialog();
        }else{
            JOptionPane.showMessageDialog(this, "Payment Cancelled.");
        }
    }
    public void postDialog(){
        String customerNameText =  customerEntry.getText();
        String[] options = {"OK"};
        int defaultOption = 0;
        JOptionPane.showOptionDialog(this,
            "Thank you," + customerNameText + "! \nYour order has been placed",
                "Order Confirmation",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                defaultOption

        );

        orders.clear();
        updateOrderScreen();
        txtFldTotal.setText("₱ 0.00");
        customerEntry.setText("");

        CardLayout cardLayout = (CardLayout) selectionMenu.getLayout();
        cardLayout.show(selectionMenu, "CoffeeMenu");
    }

    private class SwitchPanelToCoffeSelections implements ActionListener{
        private String type;
        public SwitchPanelToCoffeSelections(String type){
            this.type = type;
        }
        public void actionPerformed(ActionEvent e){
            CardLayout cardLayout = (CardLayout) selectionMenu.getLayout();
            coffeeSelections.updateComponents(type);
            cardLayout.show(selectionMenu, "CoffeeSelections");
        }
    }

    private class SwitchPanelToJuiceSelections implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CardLayout cardLayout = (CardLayout) selectionMenu.getLayout();
            cardLayout.show(selectionMenu, "JuiceSelections");
        }
    }


}
