package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.FilterRange;
import model.MyImage;

public class PaneFilterRange extends javax.swing.JPanel {

    private MyImage myImage;
    
    public PaneFilterRange() {
        initComponents();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtRange = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 420));

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));

        title.setBackground(new java.awt.Color(84, 110, 122));
        title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Filtro por Rango");
        title.setOpaque(true);

        txtRange.setBackground(new java.awt.Color(38, 50, 56));
        txtRange.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRange.setForeground(new java.awt.Color(255, 255, 255));
        txtRange.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRange.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtRange.setCaretColor(new java.awt.Color(255, 255, 255));

        btnApply.setBackground(new java.awt.Color(207, 216, 220));
        btnApply.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnApply.setForeground(new java.awt.Color(84, 110, 122));
        btnApply.setText("APLICAR");
        btnApply.setFocusPainted(false);
        btnApply.setFocusable(false);
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRange, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRange, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 269, Short.MAX_VALUE))
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

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        BufferedImage image = new FilterRange(frmPrincipal.bufferedActualImage, 
                Integer.valueOf(txtRange.getText())).applyToGray();
        frmPrincipal.bufferedActualImage = image;
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_btnApplyActionPerformed
          

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtRange;
    // End of variables declaration//GEN-END:variables
}
