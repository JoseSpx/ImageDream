package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Binarizacion;
import static view.frmPrincipal.bufferedActualImageCopy;
import static view.frmPrincipal.lblImageActual;

public class PaneGlobalBinarization extends javax.swing.JPanel {

    public PaneGlobalBinarization() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUmbral = new javax.swing.JTextField();
        btnAplicar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 420));

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));

        jLabel2.setBackground(new java.awt.Color(84, 110, 122));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Binarizacion Global");
        jLabel2.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Umbral");

        txtUmbral.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAplicar.setBackground(new java.awt.Color(207, 216, 220));
        btnAplicar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAplicar.setForeground(new java.awt.Color(84, 110, 122));
        btnAplicar.setText("APLICAR");
        btnAplicar.setFocusPainted(false);
        btnAplicar.setFocusable(false);
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(txtUmbral, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUmbral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
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

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        String umbralString = txtUmbral.getText();
    
        if(umbralString.equals("")){
            umbralString = "130";
        }
              
        int umbral;
        
        try{
            umbral = Integer.valueOf(umbralString);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            return;
        }
        
        if(umbral < 256 && umbral > -1 ){
            if(frmPrincipal.modeRGB){
            BufferedImage bufferedImage = new Binarizacion(frmPrincipal.bufferedActualImage).apply(umbral);
            bufferedActualImageCopy = frmPrincipal.bufferedActualImage;
            frmPrincipal.bufferedActualImage = bufferedImage;
            lblImageActual.setIcon(new ImageIcon(bufferedImage)); 
        }
        else{
            JOptionPane.showMessageDialog(null,"Solo es aplicable a imagenes en RGB");
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Fuera de rango");
        }
        
        

    }//GEN-LAST:event_btnAplicarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtUmbral;
    // End of variables declaration//GEN-END:variables
}
