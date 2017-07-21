package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import view.frmPrincipal;

public class Bright {

    private int percentage;
    
    public Bright(int percentage) {
        this.percentage = percentage;
    }
    
    public BufferedImage getNewImage(){
        int widht = frmPrincipal.bufferedOriginalImage.getWidth();
        int height = frmPrincipal.bufferedOriginalImage.getHeight();
        
        int r, g, b;
        int newColorR;
        int newColorG;
        int newColorB;
        Color color;
        
        BufferedImage bufferedImage = new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        
        if(percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    newColorR = r + calculateMoreBright(r);
                    
                    g = color.getGreen();
                    newColorG = g + calculateMoreBright(g);
                    
                    b = color.getBlue();
                    newColorB = b + calculateMoreBright(b);

                    bufferedImage.setRGB(j ,i, new Color(newColorR, newColorG, newColorB).getRGB());
                   
                }
            }
        }else if(percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    
                    r = color.getRed();
                    newColorR = calculateLessBright(r);
                    
                    g = color.getGreen();
                    newColorG = calculateLessBright(g);
                    
                    b = color.getBlue();
                    newColorB = calculateLessBright(b);
                    bufferedImage.setRGB(j, i, new Color(newColorR, newColorG, newColorB).getRGB());
                }
            }
        }
        return bufferedImage;
    }
    
    private int calculateMoreBright(int color){
        int difference = 255 - color;
        return (difference * ( percentage - 100 )) / 100;
    }
    
    private int calculateLessBright(int color){
        return (color * percentage) / 100;
    }
    
}
