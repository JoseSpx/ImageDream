package model;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import view.frmPrincipal;

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
    
    private BufferedImage image;
    
    public BufferedImage getScaleImage(BufferedImage image,int percentage,int type){
        MyImage myImage = new MyImage(image);
        this.width = myImage.getColumnas();
        this.height = myImage.getFilas();
        int channels = myImage.getNumberOfchannels();
        this.image = image;
        if(channels == 3){
            return scaleRGB(myImage.getMatrizImg_R(),myImage.getMatrizImg_G(),myImage.getMatrizImg_B(), percentage, type);
        }else{
            return scaleGray(myImage.getMatrizImg());
        }
    }
    
    public BufferedImage scaleRGB(double [][] matrixR, double [][] matrixG, double [][] matrixB,int percentage, int type){
        int newPixels;

        if(type == WIDHT){
            if( percentage > 100){
                newPixels = getNumberOfNewPixels(width, percentage - 100);
                ArrayList<Integer> listOfIndexes = getArrayOfIndexesOfNewPixels(width, newPixels);
                
                double [][] R = new double[HEIGHT][WIDHT + newPixels];
                double [][] G = new double[HEIGHT][WIDHT + newPixels];
                double [][] B = new double[HEIGHT][WIDHT + newPixels];
                
                if( frmPrincipal.scaleAlgorithmAverage ){
                    //ingresamos lo nuevos pixeles
                    double before;
                    double after;
                    double average;
                    
                    for(int i = 0; i < height; i++) {
                        for(Integer number : listOfIndexes) {
                            before = matrixR[i][number - 1];
                            after = matrixR[i][number];
                            average = ( before + after ) / 2;
                            R[i][number] = average;
                            
                            before = matrixG[i][number - 1];
                            after = matrixG[i][number];
                            average = ( before + after ) / 2;
                            G[i][number] = average;
                            
                            before = matrixB[i][number - 1];
                            after = matrixB[i][number];
                            average = ( before + after ) / 2;
                            B[i][number] = average;
                            
                        }
                    }
                    
                    for(int i = 0; i < height; i++) {
                        int contador = 0;
                        int num;
                        while(contador < (width + newPixels)){
                            
                            for(Integer integer : listOfIndexes){
                                if(integer <= contador){
                                    
                                }
                            }
                            
                        }
                    }
                    
                   
                }else if( frmPrincipal.scaleAlgorithmLineBefore ){
                    
                }
                
            }
            
            
        }else if(type == HEIGHT){
            if( percentage > 100){
                //newPixels = getNumberOfNewPixels(newPixels, percentage);
            }else if( percentage < 100){
                
            }
        }
        
        
        
        return null;
    }
    
    
    public BufferedImage scaleGray(double [][] matrix){
        return null;
    }
    
    private int getNumberOfNewPixels(int pixels, int percetange){
        return ( percetange * pixels ) / 100;
    } 
    
    private ArrayList<Integer> getArrayOfIndexesOfNewPixels(int pixelsOfImage, int newPixels){
        int step = pixelsOfImage / newPixels;
        ArrayList<Integer> listOfIndexes = new ArrayList<>();
        listOfIndexes.add(1);
        int j = 1;
        for(int i = 1 ; i < newPixels ; i++){
             j =  j + step;
            listOfIndexes.add(j);
        }
        return listOfIndexes;
    }
    
    public BufferedImage convertirMatrizRGBAImagen(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B){
        
        BufferedImage bi = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = bi.getRaster();

        for (int i=0;i<matriz_R.length;i++){
            for(int j=0;j<matriz_R[0].length;j++){
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        bi.setData(wr);
        return bi;
    }
    
}
