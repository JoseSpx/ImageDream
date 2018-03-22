package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Binarizacion {
    
    private BufferedImage image;

    public Binarizacion(BufferedImage image) {
        this.image = image;
    }

       
    public BufferedImage apply(int umbral){
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster newImageRaster = newImage.getRaster();
        
        Color color;
        int colorRed, colorBlue, colorGreen;
        int sum;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                color = new Color(image.getRGB(j, i));
                
                colorRed = color.getRed();
                colorGreen = color.getGreen();
                colorBlue = color.getBlue();
                
                sum = colorRed + colorGreen + colorBlue;
                sum /= 3;
                
                if(sum > umbral){
                    newImageRaster.setSample(j, i, 0, 255);
                }
                else{
                    newImageRaster.setSample(j, i, 0, 0);
                }
            }
        }

        newImage.setData(newImageRaster);
        return newImage;
    }
    
    
}
