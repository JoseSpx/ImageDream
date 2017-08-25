
package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.Bright;
import static view.frmPrincipal.bufferedActualImageCopy;

public class PaneBright extends javax.swing.JPanel {

    public PaneBright() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sliderBright = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        sliderRed = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        sliderGreen = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        sliderBlue = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(350, 420));

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));

        jLabel2.setBackground(new java.awt.Color(84, 110, 122));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Brillo");
        jLabel2.setOpaque(true);

        sliderBright.setBackground(new java.awt.Color(38, 50, 56));
        sliderBright.setForeground(new java.awt.Color(255, 255, 255));
        sliderBright.setMajorTickSpacing(50);
        sliderBright.setMaximum(200);
        sliderBright.setMinorTickSpacing(5);
        sliderBright.setPaintLabels(true);
        sliderBright.setPaintTicks(true);
        sliderBright.setToolTipText("");
        sliderBright.setValue(100);
        sliderBright.setFocusable(false);
        sliderBright.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrightStateChanged(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RGB");
        jLabel1.setOpaque(true);

        sliderRed.setBackground(new java.awt.Color(38, 50, 56));
        sliderRed.setForeground(new java.awt.Color(255, 255, 255));
        sliderRed.setMajorTickSpacing(50);
        sliderRed.setMaximum(200);
        sliderRed.setMinorTickSpacing(5);
        sliderRed.setPaintLabels(true);
        sliderRed.setPaintTicks(true);
        sliderRed.setToolTipText("");
        sliderRed.setValue(100);
        sliderRed.setFocusable(false);
        sliderRed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderRedStateChanged(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RED");
        jLabel3.setOpaque(true);

        sliderGreen.setBackground(new java.awt.Color(38, 50, 56));
        sliderGreen.setForeground(new java.awt.Color(255, 255, 255));
        sliderGreen.setMajorTickSpacing(50);
        sliderGreen.setMaximum(200);
        sliderGreen.setMinorTickSpacing(5);
        sliderGreen.setPaintLabels(true);
        sliderGreen.setPaintTicks(true);
        sliderGreen.setToolTipText("");
        sliderGreen.setValue(100);
        sliderGreen.setFocusable(false);
        sliderGreen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGreenStateChanged(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GREEN");
        jLabel4.setOpaque(true);

        sliderBlue.setBackground(new java.awt.Color(38, 50, 56));
        sliderBlue.setForeground(new java.awt.Color(255, 255, 255));
        sliderBlue.setMajorTickSpacing(50);
        sliderBlue.setMaximum(200);
        sliderBlue.setMinorTickSpacing(5);
        sliderBlue.setPaintLabels(true);
        sliderBlue.setPaintTicks(true);
        sliderBlue.setToolTipText("");
        sliderBlue.setValue(100);
        sliderBlue.setFocusable(false);
        sliderBlue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBlueStateChanged(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BLUE");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sliderBright, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderBright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sliderBrightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBrightStateChanged
        BufferedImage bufferedImage = new Bright(this.sliderBright.getValue(),0).getNewImage();
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(bufferedImage));
        frmPrincipal.bufferedActualImage = bufferedImage;
        bufferedActualImageCopy = bufferedImage;
    }//GEN-LAST:event_sliderBrightStateChanged

    private void sliderRedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderRedStateChanged
        BufferedImage bufferedImage = new Bright(this.sliderRed.getValue(),1).getNewImage();
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(bufferedImage));
        frmPrincipal.bufferedActualImage = bufferedImage;
        bufferedActualImageCopy = bufferedImage;
    }//GEN-LAST:event_sliderRedStateChanged

    private void sliderGreenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGreenStateChanged
        BufferedImage bufferedImage = new Bright(this.sliderGreen.getValue(),2).getNewImage();
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(bufferedImage));
        frmPrincipal.bufferedActualImage = bufferedImage;
        bufferedActualImageCopy = bufferedImage;
    }//GEN-LAST:event_sliderGreenStateChanged

    private void sliderBlueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBlueStateChanged
        BufferedImage bufferedImage = new Bright(this.sliderBlue.getValue(),3).getNewImage();
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(bufferedImage));
        frmPrincipal.bufferedActualImage = bufferedImage;
        bufferedActualImageCopy = bufferedImage;
    }//GEN-LAST:event_sliderBlueStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider sliderBlue;
    private javax.swing.JSlider sliderBright;
    private javax.swing.JSlider sliderGreen;
    private javax.swing.JSlider sliderRed;
    // End of variables declaration//GEN-END:variables
}
