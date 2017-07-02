package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        initComponents();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //setSize(1300, 709);
        //setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBarPrincipal = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(895, 10, 1, 660);

        menuBarPrincipal.setBackground(new java.awt.Color(38, 50, 56));
        menuBarPrincipal.setBorder(null);
        menuBarPrincipal.setForeground(new java.awt.Color(51, 51, 255));
        menuBarPrincipal.setFocusCycleRoot(true);
        menuBarPrincipal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuBarPrincipal.setMaximumSize(new java.awt.Dimension(98, 300));
        menuBarPrincipal.setPreferredSize(new java.awt.Dimension(300, 19));

        menuArchivo.setForeground(new java.awt.Color(255, 255, 255));
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuArchivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                menuArchivoFocusGained(evt);
            }
        });
        menuArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuArchivoMouseEntered(evt);
            }
        });

        jMenuItem1.setBackground(new java.awt.Color(96, 125, 139));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenuItem1FocusGained(evt);
            }
        });
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseEntered(evt);
            }
        });
        menuArchivo.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(96, 125, 139));
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Guardar como");
        menuArchivo.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(96, 125, 139));
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Salir");
        menuArchivo.add(jMenuItem3);

        menuBarPrincipal.add(menuArchivo);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Seleccion");
        jMenu2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuBarPrincipal.add(jMenu2);

        setJMenuBar(menuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenuItem1FocusGained
        
    }//GEN-LAST:event_jMenuItem1FocusGained

    private void menuArchivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_menuArchivoFocusGained
       
    }//GEN-LAST:event_menuArchivoFocusGained

    private void menuArchivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuArchivoMouseEntered

    }//GEN-LAST:event_menuArchivoMouseEntered

    private void jMenuItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseEntered

    }//GEN-LAST:event_jMenuItem1MouseEntered

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBarPrincipal;
    // End of variables declaration//GEN-END:variables
}
