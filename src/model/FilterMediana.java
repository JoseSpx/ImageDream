package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Collections;

public class FilterMediana {
    
    private BufferedImage image;

    public FilterMediana(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage applyToRGB(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width - 2, height - 2, BufferedImage.TYPE_INT_RGB);
        int medianaRed, medianaGreen, medianaBlue;
        ArrayList<Integer> listRed;
        ArrayList<Integer> listGreen;
        ArrayList<Integer> listBlue;
        
        for (int i = 1; i < height -1 ; i++) {
            for (int j = 1; j < width - 1; j++) {
                
                listRed = new ArrayList<>();
                listRed.add(new Color(image.getRGB(j-1, i-1)).getRed());
                listRed.add(new Color(image.getRGB(j, i-1)).getRed());
                listRed.add(new Color(image.getRGB(j+1,i-1)).getRed());
                listRed.add(new Color(image.getRGB(j-1, i)).getRed());
                listRed.add(new Color(image.getRGB(j, i)).getRed());
                listRed.add(new Color(image.getRGB(j+1,i)).getRed());
                listRed.add(new Color(image.getRGB(j-1,i+1)).getRed());
                listRed.add(new Color(image.getRGB(j, i+1)).getRed());
                listRed.add(new Color(image.getRGB(j+1,i+1)).getRed());
                
                Collections.sort(listRed);
                medianaRed = listRed.get(4);
                
                listGreen = new ArrayList<>();
                listGreen.add(new Color(image.getRGB(j-1, i-1)).getGreen());
                listGreen.add(new Color(image.getRGB(j, i-1)).getGreen());
                listGreen.add(new Color(image.getRGB(j+1,i-1)).getGreen());
                listGreen.add(new Color(image.getRGB(j-1, i)).getGreen());
                listGreen.add(new Color(image.getRGB(j, i)).getGreen());
                listGreen.add(new Color(image.getRGB(j+1,i)).getGreen());
                listGreen.add(new Color(image.getRGB(j-1,i+1)).getGreen());
                listGreen.add(new Color(image.getRGB(j, i+1)).getGreen());
                listGreen.add(new Color(image.getRGB(j+1,i+1)).getGreen());
                
                Collections.sort(listGreen);
                medianaGreen = listGreen.get(4);
                
                listBlue = new ArrayList<>();
                listBlue.add(new Color(image.getRGB(j-1, i-1)).getBlue());
                listBlue.add(new Color(image.getRGB(j, i-1)).getBlue());
                listBlue.add(new Color(image.getRGB(j+1,i-1)).getBlue());
                listBlue.add(new Color(image.getRGB(j-1, i)).getBlue());
                listBlue.add(new Color(image.getRGB(j, i)).getBlue());
                listBlue.add(new Color(image.getRGB(j+1,i)).getBlue());
                listBlue.add(new Color(image.getRGB(j-1,i+1)).getBlue());
                listBlue.add(new Color(image.getRGB(j, i+1)).getBlue());
                listBlue.add(new Color(image.getRGB(j+1,i+1)).getBlue());
                
                Collections.sort(listBlue);
                medianaBlue = listBlue.get(4);
                
                newImage.setRGB(j-1, i-1, new Color(medianaRed,medianaGreen,medianaBlue).getRGB());
                
            }
        }
        return newImage;
    }
    
    public BufferedImage applyToGray(){
        int width = image.getWidth();
        int heigth = image.getHeight();
        
        BufferedImage newImage = new BufferedImage(width-2, heigth-2, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster newImageRaster = newImage.getRaster();
        WritableRaster imageRaster = image.getRaster();
        
        ArrayList<Integer> list;
        int mediana;
        
        for (int i = 1; i < heigth - 1; i++) {
            for (int j = 1; j < width -1 ; j++) {
                list = new ArrayList<>();
                list.add(imageRaster.getSample(j-1, i-1, 0));
                list.add(imageRaster.getSample(j, i-1, 0));
                list.add(imageRaster.getSample(j+1, i-1, 0));
                list.add(imageRaster.getSample(j-1, i, 0));
                list.add(imageRaster.getSample(j, i-1, 0));
                list.add(imageRaster.getSample(j+1, i-1, 0));
                list.add(imageRaster.getSample(j-1, i+1, 0));
                list.add(imageRaster.getSample(j, i+1, 0));
                list.add(imageRaster.getSample(j+1, i+1, 0));
                
                Collections.sort(list);
                mediana = list.get(4);
                
                newImageRaster.setSample(j-1, i-1,0, mediana);
            }
        }
        newImage.setData(newImageRaster);
        return newImage;
    }
    
}
