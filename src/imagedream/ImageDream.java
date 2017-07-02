package imagedream;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import view.frmPrincipal;
import view.frmStart;

public class ImageDream {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        try {
            new frmPrincipal("C:\\Users\\Jose sp\\Pictures\\usher.jpg").setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ImageDream.class.getName()).log(Level.SEVERE, null, ex);
        }
        //new frmStart().setVisible(true);
    }
    
}
