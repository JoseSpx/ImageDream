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
                color = convertRGBtoHSL(color);
                
                newImage.setRGB(j, i,color.getRGB());
                
            }
        }
        
        return newImage;
    }
    
    public static Color convertRGBtoHSL(Color colorRGB){
        
        float r, g, b, R, G, B, Cmax = 0, Cmin = 0, delta, S, L, H = 0;
        //int H = 0;
        char channelMax = 0, channelMin;
        float[] results = new float[3];
        
        r = colorRGB.getRed();
        g = colorRGB.getGreen();
        b = colorRGB.getBlue();
        R = r/255;
        G = g/255;
        B = b/255;
        
        if(R>=G && R>=B){
            channelMax = 'R';
            Cmax = R;
        }else if(G>=R && G>=B){
            channelMax = 'G';
            Cmax = G;
        }else if(B>=R && B>=G){
            channelMax = 'B';
            Cmax = B;
        }
        
        if(R<=G && R<=B){
            channelMin = 'R';
            Cmin = R;
        }else if(G<=R && G<=B){
            channelMin = 'G';
            Cmin = G;
        }else if(B<=R && B<=G){
            channelMin = 'B';
            Cmin = B;
        }
        
        delta = Cmax - Cmin;
        
        //calculate Hue
        if(delta == 0){
            H = 0;
        }else if(channelMax == 'R'){
            H = (60 * Math.abs(((G-B)/delta) % 6));
        }else if(channelMax == 'G'){
            H = (60 * Math.abs(((B-R)/delta) + 2));
        }else if(channelMax == 'B'){
            H = (60 * Math.abs(((R-G)/delta) + 4));
        }
        
        //calculate Lightness 
        L = (Cmax + Cmin)/2;
        
        //calculate Saturation 
        if(delta == 0){
            S = 0;
        }else{
            S = (float) Math.floor(delta / (1 - Math.abs(2*L - 1)));
        }
        
        //System.out.println("H: "+(float)Math.floor(H/180)+" S: "+S+" L: "+L);
        
        return new Color((float)Math.floor(H/180), S, L);
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
