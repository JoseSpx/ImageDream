package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import view.frmPrincipal;

public class Bright {

    private int percentage;
    private int channel;
    
    public Bright(int percentage,int channel) {
        this.percentage = percentage;
        this.channel = channel;
    }
    
    public BufferedImage getNewImage(){
        if(frmPrincipal.modeRGB){
            switch (this.channel) {
                case 0:
                    return brightRGB();
                case 1:
                    return  brightRed();
                case 2:
                    return  brightGreen();
                case 3:
                    return  brightBlue();
                default:
                    break;
            }
        }
        else{
            return brightGRAY();
        }
        return null;
    }
    
    private int calculateMoreBright(int color){
        int difference = 255 - color;
        return (difference * ( percentage - 100 )) / 100;
    }
    
    private int calculateLessBright(int color){
        return (color * percentage) / 100;
    }
    
    public BufferedImage brightRGB(){
        int widht = frmPrincipal.bufferedActualImage.getWidth();
        int height = frmPrincipal.bufferedActualImage.getHeight();
        
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
    
    
    public BufferedImage brightRed(){
        int widht = frmPrincipal.bufferedOriginalImage.getWidth();
        int height = frmPrincipal.bufferedOriginalImage.getHeight();
        
        int r, g, b;
        int newColorR;
        Color color;
        
        BufferedImage bufferedImage = new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        
        if(percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    newColorR = r + calculateMoreBright(r);
                    
                    g = color.getGreen();
                    b = color.getBlue();

                    bufferedImage.setRGB(j ,i, new Color(newColorR, g, b).getRGB());
                }
            }
        }else if(percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    
                    r = color.getRed();
                    newColorR = calculateLessBright(r);
                    
                    g = color.getGreen();
                    b = color.getBlue();
                    bufferedImage.setRGB(j, i, new Color(newColorR, g, b).getRGB());
                }
            }
        }
        return bufferedImage;
    }
    
    public BufferedImage brightGreen(){
        int widht = frmPrincipal.bufferedActualImage.getWidth();
        int height = frmPrincipal.bufferedActualImage.getHeight();
        
        int r, g, b;
        int newColorG;
        Color color;
        
        BufferedImage bufferedImage = new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        
        if(percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    r = color.getRed();
                    g = color.getGreen();
                    newColorG = g + calculateMoreBright(g);
                    b = color.getBlue();
                    bufferedImage.setRGB(j ,i, new Color(r, newColorG, b).getRGB());
                   
                }
            }
        }else if(percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    
                    r = color.getRed();
                    g = color.getGreen();
                    newColorG = calculateLessBright(g);
                    b = color.getBlue();
                    bufferedImage.setRGB(j, i, new Color(r, newColorG, b).getRGB());
                }
            }
        }
        return bufferedImage;
    }
    
    
    public BufferedImage brightBlue(){
        int widht = frmPrincipal.bufferedActualImage.getWidth();
        int height = frmPrincipal.bufferedActualImage.getHeight();
        
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
                    g = color.getGreen();
                    b = color.getBlue();
                    newColorB = b + calculateMoreBright(b);

                    bufferedImage.setRGB(j ,i, new Color(r, g, newColorB).getRGB());
                   
                }
            }
        }else if(percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    color = new Color(frmPrincipal.bufferedOriginalImage.getRGB(j, i));
                    
                    r = color.getRed();
                    g = color.getGreen();
                    b = color.getBlue();
                    newColorB = calculateLessBright(b);
                    bufferedImage.setRGB(j, i, new Color(r, g, newColorB).getRGB());
                }
            }
        }
        return bufferedImage;
    }
    
    public BufferedImage brightGRAY(){
        
        int widht = frmPrincipal.bufferedActualImageCopy.getWidth();
        int height = frmPrincipal.bufferedActualImageCopy.getWidth();
        
        int colorGray;
        Color color;
        
        WritableRaster writableRaster = frmPrincipal.bufferedActualImageCopy.getRaster();
        BufferedImage bufferedNewImage = new BufferedImage(widht, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster writableRasterNewImage = bufferedNewImage.getRaster();
        
        if(percentage > 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    colorGray = writableRaster.getSample(j, i, 0);
                    colorGray = colorGray + calculateMoreBright(colorGray);
                    writableRasterNewImage.setSample(j, i, 0, colorGray);
                }
            }
        }else if(percentage < 100){
            for(int i = 0; i < height ; i++){
                for(int j = 0; j < widht ; j++){
                    colorGray = writableRaster.getSample(j, i, 0);
                    colorGray = calculateLessBright(colorGray);
                    writableRasterNewImage.setSample(j, i, 0, colorGray);
                }
            }
        }
        
        bufferedNewImage.setData(writableRasterNewImage);
        return bufferedNewImage;
    }
}
    
