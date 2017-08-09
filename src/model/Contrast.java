package model;

import java.awt.image.BufferedImage;

public class Contrast {
    
    private BufferedImage image;

    public Contrast(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(){
        int [][] histograma = new Histograma().histograma(image);
        return null;
    }
    
}
