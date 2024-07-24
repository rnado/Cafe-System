import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cafe_System_Forms {

    private JPanel mainPanel;
    private JLabel imageIcon;
    private JButton btnEnterCafe;

    public Cafe_System_Forms(){
        ImageIcon coffeeLogo = new ImageIcon(getClass().getResource("/logo/coffee-logo.png"));

        Image originalImage = coffeeLogo.getImage();
        Image resizeImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(resizeImage);

        imageIcon.setIcon(resizedLogo);

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
