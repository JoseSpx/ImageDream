package model;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BorderOfRoberts {
    
    private BufferedImage image;

    public BorderOfRoberts(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(){
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        WritableRaster raster = image.getRaster();
        
        BufferedImage newImage = new BufferedImage(width-1, height-1, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster newImageRaster = newImage.getRaster();
        int color;
        for (int i = 0; i < height-1; i++) {
            for (int j = 0; j < width-1; j++) {
                color = Math.abs(raster.getSample(j, i, 0) - raster.getSample(j+1, i+1, 0))
                        + Math.abs(raster.getSample(j+1, i, 0) - raster.getSample(j, i+1, 0));
                newImageRaster.setSample(j, i, 0, color);
            }
        }
        
        newImage.setData(newImageRaster);
        
        return newImage;
    }
    
    
    
}
