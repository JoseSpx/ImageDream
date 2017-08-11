package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class LocalBinarization {
    
    private BufferedImage image;

    public LocalBinarization(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(int umbral1, int umbral2, int umbral3, int umbral4){
        
        int alto = image.getHeight();
        int ancho = image.getWidth();
        
        int red, green, blue;
        
        Color [][] colors = new Color[alto][ancho];
        
        int umbral;
        int halfWidth = ancho / 2;
        int halfHeight = alto / 2;
        
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                int srcPixel = image.getRGB(i, j);
                Color c = new Color(srcPixel);
                red = c.getRed();
                green = c.getGreen();
                blue = c.getBlue();
                
                if(i < halfWidth && j < halfHeight){
                    umbral = umbral1;
                }
                else if(i >= halfWidth && j < halfHeight){
                    umbral = umbral2;
                }
                else if(i < halfWidth && j >= halfHeight){
                    umbral = umbral3;
                }
                else{
                    umbral = umbral4;
                }
                
                
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
