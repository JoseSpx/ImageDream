package model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MyImage extends Component
{
    BufferedImage   img;
    double [][]     matrizImg;		 //matrizImg de la imagen en escala de grises
    double [][]     matrizImg_R;         //matrizImg de la imagen en R
    double [][]     matrizImg_G;         //matriz de la imagen en G
    double [][]     matrizImg_B;         //matriz de la imagen en B
    int             columnas;            //numero de filas
    int             filas;               //numero de

    public MyImage(String nombreImagen){
        try{
            img = ImageIO.read(new File(nombreImagen));
            convertirImagenAMatriz();
        }
        catch (IOException e) {}
    }

    public MyImage(double [][]matriz){
         convertirMatrizAImagen(matriz);
    }

    public void convertirImagenAMatriz()
    {
        filas = img.getHeight();
    	columnas = img.getWidth();

    	matrizImg 	= new double [filas][columnas];
    	matrizImg_R	= new double [filas][columnas];
     	matrizImg_G     = new double [filas][columnas];
    	matrizImg_B	= new double [filas][columnas];
    	double r;
    	double g;
    	double b;

    	WritableRaster raster=img.getRaster();
    	int numBandas=raster.getNumBands(); 

    	for (int i=0;i<filas;i++) 
    	{
            for(int j=0;j<columnas;j++) 
            {
                if (numBandas==3)
                {   r=raster.getSampleDouble(j,i,0);
                    g=raster.getSampleDouble(j,i,1);
                    b=raster.getSampleDouble(j,i,2);
                 
                    matrizImg[i][j]=(r+g+b)/3;
                    matrizImg_R[i][j]=r;
                    matrizImg_G[i][j]=g;
                    matrizImg_B[i][j]=b;
                }
                if (numBandas==1)
                {   matrizImg[i][j]=raster.getSampleDouble(j,i,0);
                    matrizImg_R[i][j]=255;
                    matrizImg_G[i][j]=255;
                    matrizImg_B[i][j]=255;
                }
            }
        }
    }

    public void convertirMatrizAImagen(double [][] matriz)
    {
        int alto = matriz.length;
	    int ancho = matriz[0].length;

        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<alto;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }
        img.setData(wr);
    }

    public void guardarImagen(double [][]matriz, String path)
    {       
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

public void guardarImagen(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B,String path)
 {
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();

        for (int i=0;i<matriz_R.length;i++)
        {   for(int j=0;j<matriz_R[0].length;j++)
            {
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        img.setData(wr);
        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }
   
   @Override
    public void paint(Graphics g) {
        int x;
        int y=800;  //valor estandar de y
        int p=0;
        int q=0;
        
        x = img.getWidth(null) * y/img.getHeight(null);
        y = img.getHeight(null) * y/img.getHeight(null);
        
        g.drawImage(img, 100, 100, null);
        g.drawImage(img, 0, 0, x, y, 0, 0, img.getWidth(null), img.getHeight(null), null);
        //Graphics2D g2 = (Graphics2D) g;           
      
    }

    @Override
    public Dimension getPreferredSize()
    {
        int x;
    	int y=800;
        if (img == null)
        {
             return new Dimension(100,100);
        }
        else
        {
             x = img.getWidth(null) * y/img.getHeight(null);
             y = img.getHeight(null) * y/img.getHeight(null);
             return new Dimension(x, y);
          }
    }

    public double[][] getMatrizImg() {

        return matrizImg;
    }
    public int getColumnas() {
        return columnas;
    }
    public int getFilas() {
        return filas;
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
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
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
