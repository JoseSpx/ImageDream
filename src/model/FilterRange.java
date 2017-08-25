package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class FilterRange {
    
    private BufferedImage image;
    private int range;
    
    public FilterRange(BufferedImage image,int range) {
        this.image = image;
        this.range = range;
    }
    
    public BufferedImage applyToRGB(){
        
        double suma = 9;
        double a = 1;
        
        double b0 = a / suma;
        double b1 = a / suma;
        double b2 = a / suma;
        double b3 = a / suma;
        double b4 = a / suma;
        double b5 = a / suma;
        double b6 = a / suma;
        double b7 = a / suma;
        double b8 = a / suma;
        
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
    
    public BufferedImage applyToGray(){
        
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width - 2, height - 2, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster imageRaster = image.getRaster();
        WritableRaster newImageRaster = newImage.getRaster();
        double result;
        int min, max;   
        int sumaPesos;
        
        for (int i = 1; i < height - 1; i++) {
            result = 0;
            for (int j = 1; j < width - 1; j++) {
                min = imageRaster.getSample(j, i, 0) - range;
                max = imageRaster.getSample(j, i, 0) + range;
                
                result += imageRaster.getSample(j, i, 0);
                sumaPesos = 1;
                
                if(imageRaster.getSample(j-1, i-1, 0) > min && imageRaster.getSample(j-1, i-1, 0) < max){
                    result += imageRaster.getSample(j-1, i-1, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j, i-1, 0) > min && imageRaster.getSample(j, i-1, 0) < max){
                    result += imageRaster.getSample(j, i-1, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j+1, i-1, 0) > min && imageRaster.getSample(j+1, i-1, 0) < max){
                    result += imageRaster.getSample(j+1, i-1, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j-1, i, 0) > min && imageRaster.getSample(j-1, i, 0) < max){
                    result += imageRaster.getSample(j-1, i, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j+1, i, 0) > min && imageRaster.getSample(j+1, i, 0) < max){
                    result += imageRaster.getSample(j+1, i, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j-1, i+1, 0) > min && imageRaster.getSample(j-1, i+1, 0) < max){
                    result += imageRaster.getSample(j-1, i+1, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j, i+1, 0) > min && imageRaster.getSample(j, i+1, 0) < max){
                    result += imageRaster.getSample(j, i+1, 0);
                    sumaPesos++;
                }
                
                if(imageRaster.getSample(j+1, i+1, 0) > min && imageRaster.getSample(j+1, i+1, 0) < max){
                    result += imageRaster.getSample(j+1, i+1, 0);
                    sumaPesos++;
                }
                
                result = result / sumaPesos;
                
                newImageRaster.setSample(j-1, i-1, 0, (int)result);
            }
        }
        newImage.setData(newImageRaster);
        //System.out.println("jajaja");
        return newImage;
    }
    
}
