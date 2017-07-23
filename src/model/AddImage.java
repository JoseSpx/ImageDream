package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import view.frmPrincipal;

public class AddImage {

    private BufferedImage bufferedImageToAdd;
    
    public AddImage(File file) {
        try {
            bufferedImageToAdd = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(AddImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage add(){
        
        if(frmPrincipal.modeRGB){
            
            if(frmPrincipal.addImageExtremeLeft){
                BufferedImage imageActual = frmPrincipal.bufferedActualImage;

                int widthImageActual = imageActual.getWidth();
                int heightImageActual = imageActual.getHeight();

                int widthImageToAdd = bufferedImageToAdd.getWidth();
                int heightImageToAdd = bufferedImageToAdd.getHeight();

                int width, height;

                if(widthImageActual >= widthImageToAdd){
                    width = widthImageActual;
                }else{
                    width = widthImageToAdd;
                }

                if(heightImageActual >= heightImageToAdd){
                    height = heightImageActual;
                }else{
                    height = heightImageToAdd;
                }

                BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                //lo rellenamos todo de negro
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        newImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
                    }
                }

                //lo rrelenamos con la primera imagen
                for (int i = 0; i < heightImageActual; i++) {
                    for (int j = 0; j < widthImageActual; j++) {
                        newImage.setRGB(j, i,imageActual.getRGB(j, i));
                    }
                }

                //sumamos la segunda imagen por promedio
                Color actual;
                Color add;
                for (int i = 0; i < heightImageToAdd; i++) {
                    for (int j = 0; j < widthImageToAdd; j++) {
                        if(i < heightImageActual && j < widthImageActual){
                            actual = new Color(imageActual.getRGB(j, i));
                            add = new Color(bufferedImageToAdd.getRGB(j, i));
                            //average = ( imageActual.getRGB(j, i) + bufferedImageToAdd.getRGB(j, i) ) / 2;
                            newImage.setRGB(j, i,new Color((actual.getRed() + add.getRed()) / 2,
                                                           (actual.getGreen()+ add.getGreen()) / 2,
                                                           (actual.getBlue()+ add.getBlue()) / 2).getRGB());
                        }
                        else{
                            newImage.setRGB(j, i,bufferedImageToAdd.getRGB(j, i));
                        }

                    }
                }

                return newImage;
            }
            else{
                BufferedImage imageActual = frmPrincipal.bufferedActualImage;
        
                int widthImageActual = imageActual.getWidth();
                int heightImageActual = imageActual.getHeight();

                int widthImageToAdd = bufferedImageToAdd.getWidth();
                int heightImageToAdd = bufferedImageToAdd.getHeight();

                int width, height;

                if(widthImageActual >= widthImageToAdd){
                    width = widthImageActual;
                }else{
                    width = widthImageToAdd;
                }

                if(heightImageActual >= heightImageToAdd){
                    height = heightImageActual;
                }else{
                    height = heightImageToAdd;
                }

                BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                //lo rellenamos todo de negro
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        newImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
                    }
                }

                int startX;
                int startY;

                startX = ( width - widthImageActual ) / 2;
                startY = ( height - heightImageActual ) / 2;
                
                //lo rrelenamos con la primera imagen
                for (int i = 0; i < heightImageActual; i++) {
                    for (int j = 0; j < widthImageActual; j++) {
                        newImage.setRGB(j + startX, i + startY,imageActual.getRGB(j, i));
                    }
                }

                //sumamos la segunda imagen por promedio
                startX = ( width - widthImageToAdd ) / 2;//System.out.println("X : " + startX);
                startY = ( height - heightImageToAdd ) / 2;//System.out.println("Y : " + startY);
                Color actual;
                Color add;
                for (int i = 0; i < heightImageToAdd ; i++) {
                    for (int j = 0; j < widthImageToAdd ; j++) {
                        if(i < (heightImageActual + startY) && j < (widthImageActual + startX)){
                            actual = new Color(imageActual.getRGB(j + startX, i + startY));
                            add = new Color(bufferedImageToAdd.getRGB(j, i));
                            //average = ( imageActual.getRGB(j, i) + bufferedImageToAdd.getRGB(j, i) ) / 2;
                            newImage.setRGB(j + startX, i + startY,new Color((actual.getRed() + add.getRed()) / 2,
                                                           (actual.getGreen()+ add.getGreen()) / 2,
                                                           (actual.getBlue()+ add.getBlue()) / 2).getRGB());
                        }
                        else{
                            newImage.setRGB(j, i,bufferedImageToAdd.getRGB(j, i));
                        }

                    }
                }

                return newImage;
            }
            

        }
        else{
            
            BufferedImage imageActual = frmPrincipal.bufferedActualImage;
        
            int widthImageActual = imageActual.getWidth();
            int heightImageActual = imageActual.getHeight();

            int widthImageToAdd = bufferedImageToAdd.getWidth();
            int heightImageToAdd = bufferedImageToAdd.getHeight();

            int width, height;

            if(widthImageActual >= widthImageToAdd){
                width = widthImageActual;
            }else{
                width = widthImageToAdd;
            }

            if(heightImageActual >= heightImageToAdd){
                height = heightImageActual;
            }else{
                height = heightImageToAdd;
            }

            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            WritableRaster wrNewImage = newImage.getRaster();
            
            WritableRaster wrImageToadd = bufferedImageToAdd.getRaster();
            WritableRaster wrImageActual = imageActual.getRaster();
            
            //lo rellenamos todo de negro
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    //newImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
                    wrNewImage.setSample(j, i, 0, 0);
                }
            }

            //lo rrelenamos con la primera imagen
            for (int i = 0; i < heightImageActual; i++) {
                for (int j = 0; j < widthImageActual; j++) {
                    //newImage.setRGB(j, i,imageActual.getRGB(j, i));
                    wrNewImage.setSample(j, i, 0, wrImageActual.getSample(j, i, 0));
                }
            }
            
            //sumamos la segunda imagen por promedio
            int actual;
            int add;
            int average;
            
            for (int i = 0; i < heightImageToAdd; i++) {
                for (int j = 0; j < widthImageToAdd; j++) {
                    if(i < heightImageActual && j < widthImageActual){
                        add = wrImageToadd.getSample(j, i, 0);
                        actual = wrImageActual.getSample(j, i, 0);
                        average = ( actual + add ) / 2;
                        wrNewImage.setSample(j, i, 0, average);
                    }
                    else{
                        wrNewImage.setSample(j, i, 0, wrImageToadd.getSample(j, i, 0));
                    }
                }
            }
            
            newImage.setData(wrNewImage);
            return newImage;
        }

    }
    
    
    
}
