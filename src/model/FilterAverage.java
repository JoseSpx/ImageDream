package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class FilterAverage {
    
    BufferedImage image;

    public FilterAverage(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage applyToRGB(int [] box){
        
        double b0 = box[0] / 9.0;
        double b1 = box[1] / 9.0;
        double b2 = box[2] / 9.0;
        double b3 = box[3] / 9.0;
        double b4 = box[4] / 9.0;
        double b5 = box[5] / 9.0;
        double b6 = box[6] / 9.0;
        double b7 = box[7] / 9.0;
        double b8 = box[8] / 9.0;
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width - 2, height - 2, BufferedImage.TYPE_INT_RGB);
        double resultRed, resultGreen, resultBlue;
        Color color0, color1, color2, color3, color4, color5, color6, color7, color8;
        
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                color0 = new Color(image.getRGB(j-1, i-1));
                color1 = new Color(image.getRGB(j, i-1));
                color2 = new Color(image.getRGB(j+1, i-1));
                color3 = new Color(image.getRGB(j-1, i));
                color4 = new Color(image.getRGB(j, i));
                color5 = new Color(image.getRGB(j+1, i));
                color6 = new Color(image.getRGB(j-1, i+1));
                color7 = new Color(image.getRGB(j, i+1));
                color8 = new Color(image.getRGB(j+1, i+1));
                
                resultRed = b0 * color0.getRed() * 1.0 + b1 * color1.getRed() + b2 * color2.getRed() 
                            + b3 * color3.getRed() + b4 * color4.getRed() + b5 * color5.getRed()
                            + b6 * color6.getRed() + b7 * color7.getRed() + b8 * color8.getRed(); 
                
                resultGreen = b0 * color0.getGreen()+ b1 * color1.getGreen()+ b2 * color2.getGreen()
                            + b3 * color3.getGreen()+ b4 * color4.getGreen()+ b5 * color5.getGreen()
                            + b6 * color6.getGreen()+ b7 * color7.getGreen()+ b8 * color8.getGreen(); 
                
                resultBlue = b0 * color0.getBlue()+ b1 * color1.getBlue()+ b2 * color2.getBlue()
                            + b3 * color3.getBlue()+ b4 * color4.getBlue()+ b5 * color5.getBlue()
                            + b6 * color6.getBlue()+ b7 * color7.getBlue()+ b8 * color8.getBlue(); 
                
                newImage.setRGB(j - 1, i - 1, new Color((int)resultRed, (int)resultGreen,(int) resultBlue).getRGB());
                
            }
        }
        
        
        return newImage;
    }
    
    public BufferedImage applyToGray(int [] box){
        
        double b0 = box[0] / 9.0;
        double b1 = box[1] / 9.0;
        double b2 = box[2] / 9.0;
        double b3 = box[3] / 9.0;
        double b4 = box[4] / 9.0;
        double b5 = box[5] / 9.0;
        double b6 = box[6] / 9.0;
        double b7 = box[7] / 9.0;
        double b8 = box[8] / 9.0;
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width - 2, height - 2, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster imageRaster = image.getRaster();
        WritableRaster newImageRaster = newImage.getRaster();
        double result;
        
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                result = b0 * imageRaster.getSample(j-1, i-1, 0) +  b1 * imageRaster.getSample(j, i-1, 0) 
                        + b2 * imageRaster.getSample(j+1, i-1, 0) + b3 * imageRaster.getSample(j-1, i, 0) 
                        + b4 * imageRaster.getSample(j, i, 0) + b5 * imageRaster.getSample(j+1, i, 0) 
                        + b6 * imageRaster.getSample(j-1, i+1, 0) + b7 * imageRaster.getSample(j, i+1, 0) 
                        + b8 * imageRaster.getSample(j+1, i+1, 0);
                //System.out.println(result);
                newImageRaster.setSample(j-1, i-1, 0, (int)result);
            }
        }
        newImage.setData(newImageRaster);
        
        return newImage;
    }
    
}
