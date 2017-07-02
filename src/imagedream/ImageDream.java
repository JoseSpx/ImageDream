package imagedream;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import view.frmPrincipal;

public class ImageDream {

    public static void main(String[] args) {
        try {
            new frmPrincipal().setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ImageDream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
