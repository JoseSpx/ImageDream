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
                return substractRGBExtremeLeft();
            }
            else{
                return substractRGBCentered();
            }
        }else{
            if(frmPrincipal.substractImageExtremeLeft){
                return substractGrayExtremeLeft();
            }
            else{
                return substractGrayCentered();
            }
        }
    }
    
   
    public BufferedImage substractRGBExtremeLeft(){
        
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
        
        //creamos un buffer nuevo con el imageActual
        BufferedImage bufferedActualImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bufferedActualImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
            }
        }
        
        for (int i = 0; i < heightImageActual; i++) {
            for (int j = 0; j < widthImageActual; j++) {
                bufferedActualImage.setRGB(j, i ,imageActual.getRGB(j, i));
            }
        }
        
        
        //creamos otro buffer con la imagen a restar
        
        BufferedImage bufferedSubstractImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bufferedSubstractImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
            }
        }
        
        for (int i = 0; i < heightImageToSubstract; i++) {
            for (int j = 0; j < widthImageToSubstract; j++) {
                bufferedSubstractImage.setRGB(j, i, imageToSusbtract.getRGB(j, i));
            }
        }

        
        //creamos otro buffer con la imagen de resultado
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Color difference;
        Color actual;
        Color substract;
        
        int red, green, blue;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                actual = new Color(bufferedActualImage.getRGB(j , i ));
                substract = new Color(bufferedSubstractImage.getRGB(j, i));
            
                red = actual.getRed() - substract.getRed();
                green = actual.getGreen() - substract.getGreen();
                blue = actual.getBlue() - substract.getBlue();   
            
                if(red < 0){
                    red = 0;
                }
                if(green < 0){
                    green = 0;
                }
                    
                if(blue < 0){
                    blue = 0;
                }
                
                if(red == 0 && green == 0 && blue == 0){
                    newImage.setRGB(j , i , new Color(0,0,0).getRGB());   
                }else{
                    difference = new Color(red, green,blue);
                    newImage.setRGB(j , i , difference.getRGB());
                }
                   
            }
        }
        
        return newImage;
    }
    
    
    public BufferedImage substractRGBCentered(){
        
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
        
        //creamos un buffer nuevo con el imageActual
        BufferedImage bufferedActualImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int startX;
        int startY;
        
        startX = (width - widthImageActual) / 2;
        startY = (height - heightImageActual) / 2;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bufferedActualImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
            }
        }
        
        for (int i = 0; i < heightImageActual; i++) {
            for (int j = 0; j < widthImageActual; j++) {
                bufferedActualImage.setRGB(j + startX, i + startY,imageActual.getRGB(j, i));
            }
        }
        
        
        //creamos otro buffer con la imagen a restar
        
        BufferedImage bufferedSubstractImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        startX = (width - widthImageToSubstract) / 2;
        startY = (height - heightImageToSubstract) / 2;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bufferedSubstractImage.setRGB(j, i, new Color(0, 0, 0).getRGB());
            }
        }
        
        for (int i = 0; i < heightImageToSubstract; i++) {
            for (int j = 0; j < widthImageToSubstract; j++) {
                bufferedSubstractImage.setRGB(j + startX, i + startY, imageToSusbtract.getRGB(j, i));
            }
        }

        
        //creamos otro buffer con la imagen de resultado
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Color difference;
        Color actual;
        Color substract;
        
        int red, green, blue;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                actual = new Color(bufferedActualImage.getRGB(j , i ));
                substract = new Color(bufferedSubstractImage.getRGB(j, i));
            
                red = actual.getRed() - substract.getRed();
                green = actual.getGreen() - substract.getGreen();
                blue = actual.getBlue() - substract.getBlue();   
            
                if(red < 0){
                    red = 0;
                }
                if(green < 0){
                    green = 0;
                }
                    
                if(blue < 0){
                    blue = 0;
                }
                
                if(red == 0 && green == 0 && blue == 0){
                    newImage.setRGB(j , i , new Color(0,0,0).getRGB());   
                }else{
                    difference = new Color(red, green,blue);
                    newImage.setRGB(j , i , difference.getRGB());
                }
                   
            }
        }
        
        return newImage;
    }

    private BufferedImage substractGrayExtremeLeft() {
        
        BufferedImage imageActual = frmPrincipal.bufferedActualImage;
        WritableRaster writableRasterImageActual = imageActual.getRaster();
        
        WritableRaster writableRasterImageToSusbtract = imageToSusbtract.getRaster();
        
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
        
        //creamos un buffer nuevo con el imageActual
        BufferedImage bufferedActualImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster writableRasterNewImageActual = bufferedActualImage.getRaster();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                writableRasterNewImageActual.setSample(j, i, 0, 0);
            }
        }
        
        for (int i = 0; i < heightImageActual; i++) {
            for (int j = 0; j < widthImageActual; j++) {
                writableRasterNewImageActual.setSample(j, i, 0, writableRasterImageActual.getSample(j, i, 0));
            }
        }
        
        //creamos otro buffer con la imagen a restar
        
        BufferedImage bufferedSubstractImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster writableRasterSubstractImage = bufferedSubstractImage.getRaster();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                writableRasterSubstractImage.setSample(j, i, 0, 0);
            }
        }
        
        for (int i = 0; i < heightImageToSubstract; i++) {
            for (int j = 0; j < widthImageToSubstract; j++) {
                writableRasterSubstractImage.setSample(j, i, 0, writableRasterImageToSusbtract.getSample(j, i, 0));
            }
        }
        
        //creamos otro buffer con la imagen de resultado
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster writableRasterNewImage = newImage.getRaster();
        
        double difference;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                difference = writableRasterNewImageActual.getSample(j, i, 0)
                                - writableRasterSubstractImage.getSample(j, i, 0);
                
                if(difference < 0){
                    difference = 0;
                }
                
                writableRasterNewImage.setSample(j, i, 0, difference);
            }
        }
        
        newImage.setData(writableRasterNewImage);
        return newImage;
    }

    private BufferedImage substractGrayCentered() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
