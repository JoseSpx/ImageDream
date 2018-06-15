package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Skeleton {
    
    private BufferedImage image;

    public Skeleton(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply() {
        BufferedImage imageAux;
        
        //while(!isTotallyWhite(this.image)){
          //  image = new Erosion().execute(image);
        //}
        
        for (int i = 0; i < 7; i++) {
            image = new Erosion().execute(image);
        }
        
        return image;
    }
    
    
    private boolean isTotallyWhite(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        
        int color;
        
        for(int i = 0; i < w ; i++) {
            for (int j = 0; j < h; j++) {
                color = image.getRGB(i, j);
                if (color != 255) {
                    return false;
                }
            }
            
        }
        return true;
                
    }
    
    
    
}
