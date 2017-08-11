package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarizationByHistogram {
    
    private BufferedImage image;

    public BinarizationByHistogram(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage apply(){
        
        int histograma [][] = new Histograma().histograma(image);
        
        // 0 = RED
        int umbralRed;
        int umbralGreen;
        int umbralBlue;
        
        int size;
        int middle;
        ArrayList<ListHistograma> listRed = new ArrayList<>();
        ArrayList<ListHistograma> listGreen = new ArrayList<>();
        ArrayList<ListHistograma> listBlue = new ArrayList<>();
        
        for(int i = 120 ; i < 150 ; i++){
            listRed.add(new ListHistograma(i, histograma[0][i]));
            listGreen.add(new ListHistograma(i, histograma[1][i]));
            listBlue.add(new ListHistograma(i, histograma[2][i]));
        }
        
        Collections.sort(listRed, (ListHistograma o1, ListHistograma o2) -> {
            return o1.getValue() - o2.getValue();
        });
        
        Collections.sort(listGreen, (ListHistograma o1, ListHistograma o2) -> {
            return o1.getValue() - o2.getValue();
        });
                
        Collections.sort(listBlue, (ListHistograma o1, ListHistograma o2) -> {
            return o1.getValue() - o2.getValue();
        });
        
        size = listRed.size();
        middle = size / 2;
        umbralRed = listRed.get(middle).getI();
        
        size = listGreen.size();
        middle = size / 2;
        umbralGreen = listGreen.get(middle).getI();
        
        size = listBlue.size();
        middle = size / 2;
        umbralBlue = listBlue.get(middle).getI();
        
        
        return new ChannelBinarization(image).apply(umbralRed, umbralGreen, umbralBlue);
        
    }
    
}


class ListHistograma{
    private int i;
    private int value;

    public ListHistograma(int i, int value) {
        this.i = i;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getValue() {
        return value;
    }
       
}
