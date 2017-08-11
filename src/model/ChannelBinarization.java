package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ChannelBinarization {
    
    private BufferedImage image;

    public ChannelBinarization(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(int umbralRed, int umbralGreen,int umbralBlue){
        
        int alto = image.getHeight();
        int ancho = image.getWidth();
        
        int red, green, blue;
        
        Color [][] colors = new Color[alto][ancho];
        
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                int srcPixel = image.getRGB(i, j);
                Color c = new Color(srcPixel);
                red = c.getRed();
                green = c.getGreen();
                blue = c.getBlue();
                
                if(red > umbralRed){
                    red = 0;
                }else{
                    red = 255;
                }
                
                if(green > umbralGreen){
                    green = 0;
                }else{
                    green = 255;
                }
                
                if(blue > umbralBlue){
                    blue = 0;
                }else{
                    blue = 255;
                }
                
                colors[j][i] = new Color(red,green,blue,255);
            }
        }
        
        BufferedImage newImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                newImage.setRGB(j, i, colors[i][j].getRGB());
            }
        }
        
        return newImage;
        
    }
    
}
