import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class Juice_Selections {
    private JPanel juiceSelectionsUI;
    private JButton icedTeaButton;
    private JButton fountainSodaButton;
    private JButton fruiceJuiceButton;
    private JButton appleJuiceButton;
    private JButton backBtn;
    private JLabel item1Lbl;
    private JLabel item2Lbl;
    private JLabel item3Lbl;
    private JLabel item4Lbl;

    private final Cafe_UI cafeUi;


    public Juice_Selections(CardLayout cardLayout, JPanel selectionMenu, Cafe_UI cafeUi){
        this.cafeUi = cafeUi;

        icedTeaButton.addActionListener(e -> recordOrder(new Order("Iced Tea", 20)));
        icedTeaButton.setIcon(ImageUtil.resizeImage("/logo/iced-tea.jpg", 150, 150));

        fountainSodaButton.addActionListener(e -> recordOrder(new Order("Fountain Soda", 20)));
        fountainSodaButton.setIcon(ImageUtil.resizeImage("/logo/fountain-soda.jpg", 150, 150));

        fruiceJuiceButton.addActionListener(e -> recordOrder(new Order("Fruit Juice", 35)));
        fruiceJuiceButton.setIcon(ImageUtil.resizeImage("/logo/fruit-juice.jpg", 150, 150));

        appleJuiceButton.addActionListener(e -> recordOrder(new Order("Apple Juice", 25)));
        appleJuiceButton.setIcon(ImageUtil.resizeImage("/logo/apple-juice.jpg", 150, 150));


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(selectionMenu, "CoffeeMenu");
            }
        });
    }

    public void recordOrder(Order order){
        cafeUi.addOrder(order);
    }

    public JPanel getJuiceSelectionsUI(){
        return juiceSelectionsUI;
    }
}
