import javax.swing.*;
import java.awt.*;

public class Cafe_System {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cafe System");
        frame.setContentPane(new Cafe_System_Forms().getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //maximize on start
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);




    }
}
