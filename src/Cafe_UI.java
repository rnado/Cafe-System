import javax.swing.*;
import java.awt.*;

public class Cafe_UI extends JFrame {

    private JPanel uiPanel;


    public Cafe_UI(){
        setTitle("Cafe UI");
        setContentPane(uiPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setExtendedState(Frame.MAXIMIZED_BOTH);

    }



}
