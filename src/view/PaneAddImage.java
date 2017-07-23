package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.AddImage;
import model.MyImage;
import static view.frmPrincipal.lblImageActual;

public class PaneAddImage extends javax.swing.JPanel {

    private MyImage myImage;
    
    public PaneAddImage() {
        initComponents();
        paneContainerImageAdded.setVisible(false);
    }

    public void showImageOnlbl(String pathImage){
        int [] dimensions;
        dimensions = resizeOriginalImageToLabel(310,172);
        
        lblImageToAdd.setIcon(new ImageIcon(
                new ImageIcon(pathImage).getImage().getScaledInstance(dimensions[0],dimensions[1], Image.SCALE_DEFAULT)));
        lblImageToAdd.setHorizontalAlignment(SwingConstants.CENTER);
        lblImageToAdd.setVerticalAlignment(SwingConstants.CENTER);
    }
    
    public int [] resizeOriginalImageToLabel(int widthLabel, int heightLabel){
        final int lblOriginalWidth = widthLabel;
        final int lblOriginalHeight = heightLabel;
        int percentage = 1;
        int widthOriginalimage = myImage.getColumnas();
        int heightOriginalImage = myImage.getFilas();
        int width = getNewSizeByPorcentage(widthOriginalimage, percentage);
        int height = getNewSizeByPorcentage(heightOriginalImage, percentage);
        int [] dimensions = new int [2];
        
        while(width < lblOriginalWidth && height < lblOriginalHeight){
            dimensions[0] = width;
            dimensions[1] = height;
            percentage = percentage + 1;
            width = getNewSizeByPorcentage(widthOriginalimage, percentage);
            height = getNewSizeByPorcentage(heightOriginalImage, percentage);
        }
        
        return dimensions;
    }
    
    public int getNewSizeByPorcentage(int number, int porcentage){
        return (number * porcentage) / 100;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnChooseAnImageToAdd = new javax.swing.JButton();
        paneContainerImageAdded = new javax.swing.JPanel();
        lblImageToAdd = new javax.swing.JLabel();
        btnSeeImageAdded = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 420));

        jPanel1.setBackground(new java.awt.Color(30, 50, 56));

        title.setBackground(new java.awt.Color(84, 110, 122));
        title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Sumar una Imagen");
        title.setOpaque(true);

        btnChooseAnImageToAdd.setBackground(new java.awt.Color(207, 216, 220));
        btnChooseAnImageToAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnChooseAnImageToAdd.setForeground(new java.awt.Color(84, 110, 122));
        btnChooseAnImageToAdd.setText("Elegir una Imagen");
        btnChooseAnImageToAdd.setFocusPainted(false);
        btnChooseAnImageToAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseAnImageToAddActionPerformed(evt);
            }
        });

        paneContainerImageAdded.setBackground(new java.awt.Color(30, 50, 56));

        lblImageToAdd.setBackground(new java.awt.Color(30, 50, 56));
        lblImageToAdd.setOpaque(true);

        btnSeeImageAdded.setBackground(new java.awt.Color(207, 216, 220));
        btnSeeImageAdded.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeeImageAdded.setForeground(new java.awt.Color(84, 110, 122));
        btnSeeImageAdded.setText("Ver la Imagen");
        btnSeeImageAdded.setFocusPainted(false);
        btnSeeImageAdded.setFocusable(false);
        btnSeeImageAdded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeImageAddedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneContainerImageAddedLayout = new javax.swing.GroupLayout(paneContainerImageAdded);
        paneContainerImageAdded.setLayout(paneContainerImageAddedLayout);
        paneContainerImageAddedLayout.setHorizontalGroup(
            paneContainerImageAddedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContainerImageAddedLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnSeeImageAdded)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paneContainerImageAddedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageToAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneContainerImageAddedLayout.setVerticalGroup(
            paneContainerImageAddedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContainerImageAddedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeeImageAdded)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChooseAnImageToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneContainerImageAdded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChooseAnImageToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneContainerImageAdded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
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
          
    private void btnChooseAnImageToAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseAnImageToAddActionPerformed
       
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("extension jpg", "jpg"));
        int n = chooser.showOpenDialog(null);
        
        if( n == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            myImage = new MyImage(file.getAbsolutePath());
            int numBands = myImage.getNumberOfchannels();
            if((numBands == 3 && frmPrincipal.modeRGB) || (numBands == 1 && frmPrincipal.modeGray)){
                BufferedImage imageAdded = new AddImage(file).add();
                lblImageActual.setIcon(new ImageIcon(imageAdded));
                frmPrincipal.bufferedActualImage = imageAdded;
                btnChooseAnImageToAdd.setText("Cambiar Imagen");
                showImageOnlbl(file.getAbsolutePath());
                paneContainerImageAdded.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Formatos no Compatibles");
            }
        }
    }//GEN-LAST:event_btnChooseAnImageToAddActionPerformed

    private void btnSeeImageAddedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeImageAddedActionPerformed
        
    }//GEN-LAST:event_btnSeeImageAddedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseAnImageToAdd;
    private javax.swing.JButton btnSeeImageAdded;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImageToAdd;
    private javax.swing.JPanel paneContainerImageAdded;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
