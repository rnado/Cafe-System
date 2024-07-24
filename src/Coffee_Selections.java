import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Coffee_Selections {
    private JPanel coffeeSelectionsUi;
    private JPanel item1;
    private JPanel item2;
    private JPanel item3;
    private JPanel item4;
    private JPanel item5;
    private JPanel item6;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton backBtn;
    private JLabel item1Lbl;
    private JLabel item2Lbl;
    private JLabel item3Lbl;
    private JLabel item4Lbl;
    private JLabel item5Lbl;
    private JLabel item6Lbl;

    private Cafe_UI cafeUi;


    public Coffee_Selections(CardLayout cardLayout, JPanel selectionMenu, Cafe_UI cafeUi){
        this.cafeUi = cafeUi;
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(selectionMenu, "CoffeeMenu");
            }
        });
    }

    private void clearButtonListeners(JButton... buttons) {
        for (JButton button : buttons) {
            for (ActionListener al : button.getActionListeners()) {
                button.removeActionListener(al);
            }
        }
    }

    private void setupButton(JButton button, String text, double price, String imagePath) {
        button.setText(text);
        button.setIcon(ImageUtil.resizeImage(imagePath, 150, 150));
        button.addActionListener(e -> recordOrder(new Order(text, price)));
    }


    public void updateComponents(String type){
        clearButtonListeners(button1, button2, button3, button4, button5, button6);


        if(type.equals("coffee")){
            setupButton(button1, "Expresso", 20, "/logo/expresso.jpg");
            item1Lbl.setText("₱ 20.00");

            setupButton(button2, "Cappuccino", 20, "/logo/capuccino.jpeg");
            item2Lbl.setText("₱ 20.00");

            setupButton(button3, "Cafe Mocha", 30, "/logo/cafe-mocha.jpg");
            item3Lbl.setText("₱ 30.00");

            setupButton(button4, "Hazelnut", 40, "/logo/hazelnut.jpg");
            item4Lbl.setText("₱ 40.00");

            setupButton(button5, "Vanilla", 50, "/logo/vanilla.jpg");
            item5Lbl.setText("₱ 50.00");

            setupButton(button6, "Latte", 60, "/logo/latte.jpeg");
            item6Lbl.setText("₱ 60.00");
        }else if(type.equals("tea")){
            setupButton(button1, "Black Tea", 50, "/logo/black-tea.jpg");
            item1Lbl.setText("₱ 50.00");

            setupButton(button2, "Green Tea", 50, "/logo/green-tea.jpg");
            item2Lbl.setText("₱ 50.00");

            setupButton(button3, "Jasmine Tea", 55, "/logo/jasmine-tea.jpg");
            item3Lbl.setText("₱ 55.00");

            setupButton(button4, "Rose Tea", 30, "/logo/rose-tea.jpg");
            item4Lbl.setText("₱ 30.00");

            setupButton(button5, "Raspberry Tea", 20, "/logo/rasberry-tea.jpg");
            item5Lbl.setText("₱ 20.00");

            setupButton(button6, "Lemon Tea", 60, "/logo/lemon-tea.jpg");
            item6Lbl.setText("₱ 60.00");

        }
    }


    public void recordOrder(Order order){
        cafeUi.addOrder(order);
    }



    public JPanel getCoffeeSelectionsUi(){
        return coffeeSelectionsUi;
    }
}
