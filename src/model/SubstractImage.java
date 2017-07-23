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
        
        if(frmPrincipal.modeRGB){
            if(frmPrincipal.substractImageExtremeLeft){
                return rgb(0);
            }
            else{System.out.println("resta por el centro");
                return rgb(1);
            }
        }else{
            
        }
        
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
                    difference =  imageActual.getRGB(j, i) - imageToSusbtract.getRGB(j, i) ;

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
    
    public BufferedImage rgb(int mode){
        
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
        System.out.println(" h : " + height);
        System.out.println(" w : " + width);
        int startX = 0;
        int startY = 0;
        
        if(mode == 1){
            startX = (width - widthImageActual) / 2;
            startY = (height - heightImageActual) / 2;
        }
        
        
        //lo rellenamos con la primera imagen
        for (int i = 0; i < heightImageActual; i++) {
            for (int j = 0; j < widthImageActual; j++) {
                newImage.setRGB(j + startX, i + startY,imageActual.getRGB(j, i));
            }
        }
        
        //sumamos la segunda imagen por promedio
        if(mode == 1){
            startX = (width - widthImageToSubstract) / 2;
            startY = (height - heightImageToSubstract) / 2;
        }

        int difference;
        for (int i = 0; i < heightImageToSubstract; i++) {
            for (int j = 0; j < widthImageToSubstract; j++) {
                if(i < (heightImageActual + startY) && j < (widthImageActual + startX)){
                    difference =  newImage.getRGB(j + startY, i + startX) - imageToSusbtract.getRGB(j, i) ;

                    if(difference < 0){
                        newImage.setRGB(j + startY, i + startX, 0);   
                    }else{
                        newImage.setRGB(j + startY, i + startX, difference);
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
