package model;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BorderOfPrewit {
    
    private BufferedImage image;

    public BorderOfPrewit(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(){
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        WritableRaster raster = image.getRaster();
        
        BufferedImage newImage = new BufferedImage(width-2, height-2, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster newImageRaster = newImage.getRaster();
        int color1, color2, colorSum;
        for (int i = 1; i < height-1; i++) {
            for (int j = 1; j < width-1; j++) {
                color1 = raster.getSample(j+1, i-1, 0) + raster.getSample(j+1, i, 0) + raster.getSample(j+1, i+1, 0)
                        - (raster.getSample(j-1, i-1, 0) + raster.getSample(j-1, i, 0) + raster.getSample(j-1, i+1, 0));
                
                color2 = raster.getSample(j-1, i+1, 0) + raster.getSample(j, i+1, 0) + raster.getSample(j+1, i+1, 0)
                        - (raster.getSample(j-1, i-1, 0) + raster.getSample(j, i-1, 0) + raster.getSample(j+1, i-1, 0));
                
                colorSum = color1 + color2;
                
                if(colorSum < 0){
                    colorSum = 0;
                }
                else if(colorSum > 255){
                    colorSum = 255;
                }
                        
                newImageRaster.setSample(j-1, i-1, 0, colorSum);
            }
        }
        
        newImage.setData(newImageRaster);
        
        return newImage;
    }
    
    
    
}
