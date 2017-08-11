
package view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.Caret;
import model.FilterAverage;

public class PaneFilterAverage extends javax.swing.JPanel {

    public PaneFilterAverage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt0 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt6 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();

        jTextField7.setBackground(new java.awt.Color(38, 50, 56));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTextField8.setBackground(new java.awt.Color(38, 50, 56));
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTextField9.setBackground(new java.awt.Color(38, 50, 56));
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        setPreferredSize(new java.awt.Dimension(350, 420));

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));

        jLabel2.setBackground(new java.awt.Color(84, 110, 122));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Filtro por Promedio");
        jLabel2.setOpaque(true);

        txt0.setBackground(new java.awt.Color(38, 50, 56));
        txt0.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt0.setForeground(new java.awt.Color(255, 255, 255));
        txt0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt0.setCaretColor(new java.awt.Color(255, 255, 255));

        txt2.setBackground(new java.awt.Color(38, 50, 56));
        txt2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt2.setCaretColor(new java.awt.Color(255, 255, 255));

        txt1.setBackground(new java.awt.Color(38, 50, 56));
        txt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt1.setCaretColor(new java.awt.Color(255, 255, 255));

        txt3.setBackground(new java.awt.Color(38, 50, 56));
        txt3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt3.setCaretColor(new java.awt.Color(255, 255, 255));

        txt4.setBackground(new java.awt.Color(38, 50, 56));
        txt4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt4.setForeground(new java.awt.Color(255, 255, 255));
        txt4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt4.setCaretColor(new java.awt.Color(255, 255, 255));

        txt5.setBackground(new java.awt.Color(38, 50, 56));
        txt5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt5.setForeground(new java.awt.Color(255, 255, 255));
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt5.setCaretColor(new java.awt.Color(255, 255, 255));

        txt6.setBackground(new java.awt.Color(38, 50, 56));
        txt6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt6.setForeground(new java.awt.Color(255, 255, 255));
        txt6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt6.setCaretColor(new java.awt.Color(255, 255, 255));

        txt7.setBackground(new java.awt.Color(38, 50, 56));
        txt7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt7.setForeground(new java.awt.Color(255, 255, 255));
        txt7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt7.setCaretColor(new java.awt.Color(255, 255, 255));

        txt8.setBackground(new java.awt.Color(38, 50, 56));
        txt8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt8.setForeground(new java.awt.Color(255, 255, 255));
        txt8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt8.setCaretColor(new java.awt.Color(255, 255, 255));

        btnApply.setBackground(new java.awt.Color(207, 216, 220));
        btnApply.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnApply.setForeground(new java.awt.Color(84, 110, 122));
        btnApply.setText("APLICAR");
        btnApply.setBorderPainted(false);
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
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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
        String data0 = txt0.getText();
        String data1 = txt1.getText();
        String data2 = txt2.getText();
        String data3 = txt3.getText();
        String data4 = txt4.getText();
        String data5 = txt5.getText();
        String data6 = txt6.getText();
        String data7 = txt7.getText();
        String data8 = txt8.getText();
        
        if(data0.equals("") || data1.equals("")|| data2.equals("")|| data3.equals("")|| data4.equals("")
                || data5.equals("")|| data6.equals("")|| data7.equals("") || data8.equals("") ){
            JOptionPane.showMessageDialog(null, "Complete los datos pedidos");
            return;
        }
        
        int [] box = new int [9] ;
        
        box[0] = Integer.valueOf(data0);
        box[1] = Integer.valueOf(data1);
        box[2] = Integer.valueOf(data2);
        box[3] = Integer.valueOf(data3);
        box[4] = Integer.valueOf(data4);
        box[5] = Integer.valueOf(data5);
        box[6] = Integer.valueOf(data6);
        box[7] = Integer.valueOf(data7);
        box[8] = Integer.valueOf(data8);

        BufferedImage image;
        
        if(frmPrincipal.modeRGB){
            image = new FilterAverage(frmPrincipal.bufferedActualImage).applyToRGB(box);
        }
        else{
            image = new FilterAverage(frmPrincipal.bufferedActualImage).applyToGray(box);
        }
          
        frmPrincipal.bufferedActualImageCopy = frmPrincipal.bufferedActualImage;
        frmPrincipal.bufferedActualImage = image;
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(image));
        
    }//GEN-LAST:event_btnApplyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txt0;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    // End of variables declaration//GEN-END:variables
}
