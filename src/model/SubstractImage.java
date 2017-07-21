package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import view.frmPrincipal;

public class SubstractImage {

    private BufferedImage imageToSusbtract;

    public SubstractImage(File file) {
        try {
            this.imageToSusbtract = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(SubstractImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage substract(){
        BufferedImage imageActual = frmPrincipal.bufferedActualImage;
        
        int widthImageActual = imageActual.getWidth();
        int heightImageActual = imageActual.getHeight();
        
        int widthImageToSubstract = imageToSusbtract.getWidth();
        int heightImageToSubstract = imageToSusbtract.getHeight();
        
        int width, height;
        
        if(widthImageActual >= widthImageToSubstract){
            width = widthImageActual;
        }else{
            width = widthImageToSubstract;
        }
        
        if(heightImageActual >= heightImageToSubstract){
            height = heightImageActual;
        }else{
            height = heightImageToSubstract;
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
        int difference;
        for (int i = 0; i < heightImageToSubstract; i++) {
            for (int j = 0; j < widthImageToSubstract; j++) {
                if(i < heightImageActual && j < widthImageActual){
                    //actual = new Color(imageActual.getRGB(j, i));
                    //add = new Color(bufferedImageToAdd.getRGB(j, i));
                    difference =  imageActual.getRGB(j, i) - imageToSusbtract.getRGB(j, i) ;
                    //newImage.setRGB(j, i,new Color((actual.getRed() + add.getRed()) / 2,
                      //                             (actual.getGreen()+ add.getGreen()) / 2,
                        //                           (actual.getBlue()+ add.getBlue()) / 2).getRGB());
                        
                    if(difference < 0){
                        newImage.setRGB(j, i, 0);
                    }else{
                        newImage.setRGB(j, i, difference);
                    }
                        
                }
                else{
                    newImage.setRGB(j, i,imageToSusbtract.getRGB(j, i));
                }
                
            }
        }
        
        return newImage;
    }
    
    
    
}
