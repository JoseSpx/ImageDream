package model;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MyImage extends Component
{
    private BufferedImage   img;
    private double [][]     matrizImg;		 //matrizImg de la imagen en escala de grises
    private double [][]     matrizImg_R;         //matrizImg de la imagen en R
    private double [][]     matrizImg_G;         //matriz de la imagen en G
    private double [][]     matrizImg_B;         //matriz de la imagen en B
    private int             nroColumnas;            //numero de filas
    private int             nroFilas;               //numero de
    private int numberOfchannels;
    
    public MyImage(String nombreImagen){
        try{
            img = ImageIO.read(new File(nombreImagen));
            convertirImagenAMatriz();
        }
        catch (IOException e) {}
    }

    public MyImage(BufferedImage image){
        this.img = image;
        convertirImagenAMatriz();
    }
    
    public void convertirImagenAMatriz()
    {
        nroFilas = img.getHeight();
    	nroColumnas = img.getWidth();

    	matrizImg 	= new double [nroFilas][nroColumnas];
    	matrizImg_R	= new double [nroFilas][nroColumnas];
     	matrizImg_G     = new double [nroFilas][nroColumnas];
    	matrizImg_B	= new double [nroFilas][nroColumnas];
    	double r;
    	double g;
    	double b;

    	WritableRaster raster=img.getRaster();
    	this.numberOfchannels =raster.getNumBands(); 

    	for (int i=0;i<nroFilas;i++){
            
            for(int j=0;j<nroColumnas;j++){
                
                if (this.numberOfchannels == 3){
                    r=raster.getSampleDouble(j,i,0);
                    g=raster.getSampleDouble(j,i,1);
                    b=raster.getSampleDouble(j,i,2);
                 
                    matrizImg[i][j]=(r+g+b)/3;
                    matrizImg_R[i][j]=r;
                    matrizImg_G[i][j]=g;
                    matrizImg_B[i][j]=b;
                }
                if (this.numberOfchannels == 1){
                    matrizImg[i][j]=raster.getSampleDouble(j,i,0);
                }
            }
        }
    }

    public BufferedImage convertirMatrizGrayAImagen(double [][] matriz){
        int alto = matriz.length;
        int ancho = matriz[0].length;

        BufferedImage image = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = image.getRaster();

        for (int i=0;i<alto;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }
        image.setData(wr);
        
        return image;
    }

    public BufferedImage convertirMatrizRGBAImagen(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B){
        
        BufferedImage image = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = image.getRaster();

        for (int i=0;i<matriz_R.length;i++){
            for(int j=0;j<matriz_R[0].length;j++){
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        image.setData(wr);
        return image;
    }
    
    public static void guardarImagen(double [][]matriz, String path){       
        BufferedImage imgNew = new BufferedImage(matriz[0].length,matriz.length,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = imgNew.getRaster();

        for (int i=0;i<matriz.length;i++)
        {            for(int j=0;j<matriz[0].length;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }

        imgNew.setData(wr);

        try
        {
            ImageIO.write(imgNew, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }

    public static void guardarImagen(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B,String path)
 {
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();
        int i, j;
        
        for(i=0;i<matriz_R.length;i++){
            for(j=0;j<matriz_R[0].length;j++){
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        imgn.setData(wr);
        try{
            path = path + "\\im.jpg";
            ImageIO.write(imgn, "JPG", new File(path));
            System.out.println("-" + path);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
   
    public int getNumberOfchannels() {
        return numberOfchannels;
    }
    
    public double[][] getMatrizImg() {

        return matrizImg;
    }
    public int getColumnas() {
        return nroColumnas;
    }
    public int getFilas() {
        return nroFilas;
    }
    public BufferedImage getImg() {
        return img;
    }
    public double[][] getMatrizImg_B() {
        return matrizImg_B;
    }
    public double[][] getMatrizImg_G() {
        return matrizImg_G;
    }
    public double[][] getMatrizImg_R() {
        return matrizImg_R;
    }
    public void setMatrizImg(double[][] matrizImg) {
        this.matrizImg = matrizImg;
    }
    public void setImg(BufferedImage img) {
        this.img=img;
    }
    public void setMatrizImg_B(double[][] matrizImg_B) {
        this.matrizImg_B = matrizImg_B;
    }
    public void setMatrizImg_G(double[][] matrizImg_G) {
        this.matrizImg_G = matrizImg_G;
    }
    public void setMatrizImg_R(double[][] matrizImg_R) {
        this.matrizImg_R = matrizImg_R;
    }

}
