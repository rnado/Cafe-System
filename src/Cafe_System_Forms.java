import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cafe_System_Forms {

    private JPanel mainPanel;
    private JLabel imageIcon;
    private JButton btnEnterCafe;

    public Cafe_System_Forms(){
        imageIcon.setIcon(ImageUtil.resizeImage("/logo/coffee-logo.png", 200, 300));


        btnEnterCafe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cafe_UI cafeUi = new Cafe_UI();
                cafeUi.setVisible(true);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });

    }



    public JPanel getMainPanel(){
        return mainPanel;
    }

}
