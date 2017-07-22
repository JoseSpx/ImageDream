package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Binarizacion {
    
    private BufferedImage image;

    public Binarizacion(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(){
        
        int alto = image.getHeight();
        int ancho = image.getWidth();
        
        int red, green, blue;
        
        Color [][] colors = new Color[alto][ancho];
        
        int umbral = 120;
        
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                int srcPixel = image.getRGB(i, j);
                Color c = new Color(srcPixel);
                red = c.getRed();
                green = c.getGreen();
                blue = c.getBlue();
                
                if(red > umbral){
                    red = 0;
                }else{
                    red = 255;
                }
                
                if(green > umbral){
                    green = 0;
                }else{
                    green = 255;
                }
                
                if(blue > umbral){
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
