package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class PseudoColor {
    
    private BufferedImage imageToApply;

    private final Color firstColor = Color.BLUE;
    private final Color SecondColor = Color.RED;
    private final Color ThirdColor = Color.GREEN;
    
    private final int firstUmbral = 85;
    private final int secondUmbral = 170;
    private final int thirdUmbral = 255;
    
    public PseudoColor(BufferedImage imageToApply) {
        this.imageToApply = imageToApply;
    }
    
    public BufferedImage apply(){
        int width = imageToApply.getWidth();
        int height = imageToApply.getHeight();
        
        WritableRaster writableRaster = imageToApply.getRaster();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        int gray;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                gray = writableRaster.getSample(j, i, 0);
                
                if(gray < firstUmbral){
                    newImage.setRGB(j, i, firstColor.getRGB());
                }
                else if(gray < secondUmbral){
                    newImage.setRGB(j, i, SecondColor.getRGB());
                }
                else{
                    newImage.setRGB(j, i, ThirdColor.getRGB());
                }
                
            }
        }
        
        return newImage;
    }
    
}
