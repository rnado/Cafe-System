import javax.swing.*;
import java.awt.*;

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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel coffeeMenu;
    private JPanel selectionMenu;
    private JPanel printReceipt;

    public Cafe_UI(){
        setTitle("Cafe UI");

        setContentPane(uiPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        uiPanel.setPreferredSize(new Dimension(getWidth(),getHeight()));
        pack();
    }


}
