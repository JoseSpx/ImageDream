package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class HSI {
    
    private BufferedImage image;

    public HSI(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        double r;
        double g;
        double b;
        
        Color color;
        
        double average;
        double rn;
        double gn;
        double bn;
        
        double h;
        double s;
        
        double pi = 3.141592;
        
        int rFinal;
        int gFinal;
        int bFinal;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                color = new Color(image.getRGB(j, i));
                r = color.getRed();
                g = color.getGreen();
                b = color.getBlue();
                
                //conversion a HSI
                average = (r + g + b) / 3.0;
                rn = r / (r + g + b);
                gn = g / (r + g + b);
                bn = b / (r + g + b);

                h = Math.acos((0.5 * ((rn - gn) + (rn - bn))) / (Math.sqrt((rn - gn) * (rn - gn) + (rn - bn) * (gn - bn))));
                if(b > g){
                    h = 2 * pi - h;	
                }

                s = 1 - 3 * Math.min(rn, Math.min(gn, bn));
                     
                
                //simulacion de HSI to RGB
                
                double x = i * (1 - s);		
                if(h < 2 * pi / 3){
                    double y = i * (1 + (s * Math.cos(h)) / (Math.cos(pi / 3 - h)));
                    double z = 3 * i - (x + y);
                    b = x;
                    r = y;
                    g = z;
                }
                else if(h < 4 * pi / 3){
                    double y = i * (1 + (s * Math.cos(h - 2 * pi / 3)) / (Math.cos(pi / 3 - (h  - 2 * pi / 3))));
                    double z = 3 * i - (x + y);
                    r = x;
                    g = y;
                    b = z;
                }
                else{
                    double y = i * (1 + (s * Math.cos(h - 4 * pi / 3)) / (Math.cos(pi / 3 - (h  - 4 * pi / 3))));
                    double z = 3 * i - (x + y);
                    r = z; 
                    g = x; 
                    b = y;
                }
                
                
                rFinal = (int)r;
                gFinal = (int)g;
                bFinal = (int)b;
                
                if(rFinal > 255){
                    rFinal = 255;
                }
                
                if(gFinal > 255){
                    gFinal = 255;
                }
                
                if(bFinal > 255){
                    bFinal = 255;
                }
                
                
                newImage.setRGB(j, i, new Color(rFinal,gFinal,bFinal).getRGB());
            }
        }
        
        return newImage;
    }
    
    
}
