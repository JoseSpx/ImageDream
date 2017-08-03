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
        
        double rPrima;
        double gPrima;
        double bPrima;
        
        double cMax;
        double cMin;
        
        double difference;
        
        Color color;
        
        double H = 0, S = 0, L = 0;
        double C, X, M; 
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                color = new Color(image.getRGB(j, i));
                r = color.getRed();
                g = color.getGreen();
                b = color.getBlue();
                
                rPrima = r / 255;
                gPrima = g / 255;
                bPrima = b / 255;
                
                cMax = max(rPrima, gPrima, bPrima);
                cMin = min(rPrima, gPrima, bPrima);
                
                difference = cMax - cMin;
                
                if(difference == 0){
                    H = 0;
                }else if(cMax == rPrima){
                    H = 60 * (((gPrima - bPrima) / difference ) % 6);
                }else if(cMax == gPrima){
                    H = 60 * (((bPrima - rPrima) / difference) + 2);
                }else if(cMax == bPrima){
                    H = 60 * (((rPrima - gPrima) / difference) + 4);
                }
                
                L = (cMax + cMin) / 2;
                
                difference = (int)difference;
                
                if(difference == 0){
                    S = 0;
                }else{
                    S = difference / ( 1 - Math.abs(2*L - 1));  
                }
                
                if(H <= 0){
                    H = 0;
                }
                else if(H >= 360){
                    H = 359;
                }
                
                if(S < 0){
                    S = 0;
                }
                else if(S > 1){
                    S = 1;
                }
                
                if(L < 0){
                    L = 0;
                }
                else if(L > 1){
                    L = 1;
                }
                
                // HSI to RGB
                /*
                C = ( 1 - Math.abs(2 * L - 1)) * S;
                X = C * ( 1 - Math.abs((H / 60)%2 -1) );
                M = L - C / 2;
                
                if(H < 60){
                    rPrima = C;
                    gPrima = X;
                    bPrima = 0;
                }
                else if(H < 120){
                    rPrima = X;
                    gPrima = C;
                    bPrima = 0;
                }
                else if(H < 180){
                    rPrima = 0;
                    gPrima = X;
                    bPrima = C;
                }
                else if(H < 240){
                    rPrima = 0;
                    gPrima = X;
                    bPrima = C;
                }
                else if(H < 300){
                    rPrima = X;
                    gPrima = 0;
                    bPrima = C;
                }
                else if(H < 360){
                    rPrima = C;
                    gPrima = 0;
                    bPrima = X;
                }
                
                r = (rPrima + M) * 255;
                g = (gPrima + M) * 255;
                b = (bPrima + M) * 255;
                */
                
                if(H > 255){
                    H = 255;
                }
                
                if(S > 255){
                    S = 255;
                }
                
                if(L > 255){
                    L = 255;
                }
                
                newImage.setRGB(j, i, new Color((int)H,(int) S,(int) L).getRGB());
                
            }
        }
        
        return newImage;
    }
    
    public double max(double a, double b, double c){
        if( a >= b && a >= c){
            return a;
        }
        else if( b >= c && b >= a){
            return b;
        }
        else if( c >= a && c >= b){
            return c;
        }
        return a;
    }

    public double min(double a, double b, double c){
        if( a <= b && a <= c){
            return a;
        }
        else if( b <= c && b <= a){
            return b;
        }
        else if( c <= a && c <= b){
            return c;
        }
        return a;
    }    
    
}
