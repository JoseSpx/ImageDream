package model;

import java.awt.image.BufferedImage;

public class ScaleImage {

    private final int scaleAlgorithmAverage = 1;
    private final int scaleAlgorithmLineBefore = 2;
    
    private final int WIDHT = 0;
    private final int HEIGHT = 1;
    
    private static double [][] matrizImg;
    private static double [][] matrizImg_R;         
    private double [][] matrizImg_G;         
    private double [][] matrizImg_B;
    
    private int height;
    private int width;
    
    public BufferedImage getScaleImage(BufferedImage image,int percentage,int type){
        MyImage myImage = new MyImage(image);
        this.width = myImage.getColumnas();
        this.height = myImage.getFilas();
        int channels = myImage.getNumberOfchannels();
        if(channels == 3){
            return scaleRGB(myImage.getMatrizImg_R(),myImage.getMatrizImg_G(),myImage.getMatrizImg_B(), percentage, type);
        }else{
            return scaleGray(myImage.getMatrizImg());
        }
    }
    
    public BufferedImage scaleRGB(double [][] matrixR, double [][] matrixG, double [][] matrixB,int percentage, int type){
        if(type == WIDHT){
            int newPixels = getNumberOfNewPixels(width, percentage);
            
        }else if(type == HEIGHT){
            
        }
        
        
        
        return null;
    }
    
    public BufferedImage scaleGray(double [][] matrix){
        return null;
    }
    
    private int getNumberOfNewPixels(int pixels, int percetange){
        return ( percetange * pixels ) / 100;
    } 
    
    private int [] getArrayOfIndexesOfNewPixels(int pixels, int newPixels){
        int step = pixels / newPixels;
        int i;
        
        
        return null;
    }
}
