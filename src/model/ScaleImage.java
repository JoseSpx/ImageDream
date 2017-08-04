package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import view.frmPrincipal;

public class ScaleImage {
    
    private final int WIDHT = 0;
    private final int HEIGHT = 1;
    
    private int height;
    private int width;
    
    private BufferedImage image;
    
    public BufferedImage getScaleImage(BufferedImage image,int percentage,int type){
        MyImage myImage = new MyImage(image);
        this.width = image.getWidth();
        this.height = image.getHeight();
        int channels = myImage.getNumberOfchannels();
        this.image = image;
        if(channels == 3){
            return scaleRGB(myImage.getMatrizImg_R(),myImage.getMatrizImg_G(),myImage.getMatrizImg_B(), percentage, type);
        }else{
            return scaleGray(myImage.getMatrizImg());
        }
    }
    
    public BufferedImage scaleRGB(double [][] matrixR, double [][] matrixG, double [][] matrixB,int percentage, int type){

        if( percentage > 198 ){
            percentage = percentage - 1;
        }

        double [][] R;
        double [][] G;
        double [][] B;
        
        if(type == WIDHT){
            if( percentage > 100){
                int newPixels = getNumberOfNewPixels(width, percentage - 100);
                int step = Math.round(width / newPixels);
                
                if( frmPrincipal.scaleAlgorithmAverage ){System.out.println("Promedio");
                   
                }else if( frmPrincipal.scaleAlgorithmLineBefore ){
                    
                    int contadorWidth = 0;
                    int i;
                    int j;
                    
                    //hallaremos el tamaño de la imagen escalada

                    for ( j = 0; j < width; j++) {
                        if(j % step == 0 && j!= 0){
                            contadorWidth++;
                        }
                        contadorWidth++;
                    }
                    
                    
                    R = new double[height][contadorWidth];
                    G =  new double[height][contadorWidth];
                    B = new double[height][contadorWidth];
                    
                    int x;
                    contadorWidth = 0;

                    for ( j = 0; j < width; j++) {
                        for(x = 0; x < height ; x ++){
                            R[x][contadorWidth] = new Color(image.getRGB(j, x)).getRed();
                            G[x][contadorWidth] = new Color(image.getRGB(j, x)).getGreen();
                            B[x][contadorWidth] = new Color(image.getRGB(j, x)).getBlue();
                        }

                        if(j % step == 0 && j!= 0){
                            contadorWidth++;
                            for(x = 0; x < height ; x ++){
                                R[x][contadorWidth] = new Color(image.getRGB(j, x)).getRed();
                                G[x][contadorWidth] = new Color(image.getRGB(j, x)).getGreen();
                                B[x][contadorWidth] = new Color(image.getRGB(j, x)).getBlue();
                            }
                        }

                        contadorWidth++;
                    }
                    
                    return convertirMatrizRGBAImagen(R, G, B);
                    
                }
                
            }
            else if(percentage < 100) {
                int deletePixels = getNumberOfNewPixels(width, 100 -percentage);
                int step = Math.round(width / deletePixels);
                int contadorWidth = 0;
                int j;

                //hallaremos el tamaño de la imagen escalada

                for (j = 0; j < width; j++) {
                    if(j % step != 0){
                        contadorWidth++;
                    }
                }

                R = new double[height][contadorWidth];
                G = new double[height][contadorWidth];
                B = new double[height][contadorWidth];

                int x;
                contadorWidth = 0;
                for ( j = 0; j < width; j++) {
                    if(j % step != 0){
                        for(x = 0; x < height ; x ++){
                            R[x][contadorWidth] = new Color(image.getRGB(j, x)).getRed();
                            G[x][contadorWidth] = new Color(image.getRGB(j, x)).getGreen();
                            B[x][contadorWidth] = new Color(image.getRGB(j, x)).getBlue();
                        }
                        contadorWidth++;
                    }
                }
                    
                return convertirMatrizRGBAImagen(R, G, B);
            }
        }else if(type == HEIGHT){
            if( percentage > 100){
                int newPixels = getNumberOfNewPixels(height, percentage - 100);
                int step = Math.round(height / newPixels);
                int contadorHeight = 0;
                int j;

                //hallaremos el tamaño de la imagen escalada
                for ( j = 0; j < height; j++) {
                    if(j % step == 0 && j!= 0){
                        contadorHeight++;
                    }
                    contadorHeight++;
                }
                
                
                R = new double[contadorHeight][width];
                G = new double[contadorHeight][width];
                B = new double[contadorHeight][width];

                int x;
                contadorHeight = 0;
                
                for ( j = 0; j < height; j++) {
                    for(x = 0; x < width ; x ++){
                        R[contadorHeight][x] = new Color(image.getRGB(x, j)).getRed();
                        G[contadorHeight][x] = new Color(image.getRGB(x, j)).getGreen();
                        B[contadorHeight][x] = new Color(image.getRGB(x, j)).getBlue();
                    }

                    if(j % step == 0 && j!= 0){
                        contadorHeight++;
                        for(x = 0; x < width ; x ++){
                            R[contadorHeight][x] = new Color(image.getRGB(x, j)).getRed();
                            G[contadorHeight][x] = new Color(image.getRGB(x, j)).getGreen();
                            B[contadorHeight][x] = new Color(image.getRGB(x, j)).getBlue();
                        }
                    }

                    contadorHeight++;
                }
                
                return convertirMatrizRGBAImagen(R, G, B);

            }else if( percentage < 100){
                int deletePixels = getNumberOfNewPixels(height, 100 - percentage);
                int step = Math.round(height / deletePixels);
                int contadorHeight = 0;
                int j;

                //hallaremos el tamaño de la imagen escalada

                for (j = 0; j < height; j++) {
                    if(j % step != 0){
                        contadorHeight++;
                    }
                }

                R = new double[contadorHeight][width];
                G = new double[contadorHeight][width];
                B = new double[contadorHeight][width];

                int x;
                contadorHeight = 0;
                for ( j = 0; j < height; j++) {
                    if(j % step != 0){
                        for(x = 0; x < width ; x ++){
                            R[contadorHeight][x] = new Color(image.getRGB(x, j)).getRed();
                            G[contadorHeight][x] = new Color(image.getRGB(x, j)).getGreen();
                            B[contadorHeight][x] = new Color(image.getRGB(x, j)).getBlue();
                        }
                        contadorHeight++;
                    }
                }
                    
                return convertirMatrizRGBAImagen(R, G, B);
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

        System.out.println("Matriz Escalada ALTO: " + matriz_R.length);
        System.out.println("Matriz Escalada ANCHO: " + matriz_R[0].length);
        
        bi.setData(wr);
        return bi;
    }
    
}
