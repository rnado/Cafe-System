import javax.swing.*;
import java.awt.*;

public class Cafe_System {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cafe System");
        frame.setContentPane(new Cafe_System_Forms().getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setResizable(true);

        //Set Size to full screen on launch
        GraphicsEnvironment graphEn = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphDev = graphEn.getDefaultScreenDevice();

        //full-screen support checker
        if(graphDev.isFullScreenSupported()){
            graphDev.setFullScreenWindow(frame);
        }else{
            System.err.println("Full-screen mode is not supported on this device");
            //set fallback if full-screen is not supported
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }

    }
}
