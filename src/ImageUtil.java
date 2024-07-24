import javax.swing.*;
import java.awt.*;

public class ImageUtil {
  public static ImageIcon resizeImage(String path, int width, int height){
      ImageIcon icon = new ImageIcon(ImageUtil.class.getResource(path));
      Image image = icon.getImage();
      Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(resizedImage);
  }
}
