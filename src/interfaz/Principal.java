/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import clases.Helper;

/**
 *
 * @author rmorales1
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
     String ruta;
    public Principal() {
        initComponents();
          ruta = "src/datos/personas.txt";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnOpciones = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnSalir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnAgregarPersonas = new javax.swing.JMenuItem();
        mnReportes = new javax.swing.JMenu();
        mnListados = new javax.swing.JMenu();
        mnListadoPersonas = new javax.swing.JMenuItem();
        mnListadoPorSexo = new javax.swing.JMenuItem();
        mnCantidades = new javax.swing.JMenu();
        mnCantidadPersonasIngresadas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnAgregarCarros = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PERSONAS");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/portada.jpg"))); // NOI18N
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, 660, 370));

        mnOpciones.setText("Opciones");
        mnOpciones.add(jSeparator1);

        mnSalir.setText("Salir");
        mnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSalirActionPerformed(evt);
            }
        });
        mnOpciones.add(mnSalir);

        jMenuBar1.add(mnOpciones);

        jMenu3.setText("Personas");

        mnAgregarPersonas.setText("Agregar");
        mnAgregarPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAgregarPersonasActionPerformed(evt);
            }
        });
        jMenu3.add(mnAgregarPersonas);

        mnReportes.setText("Reportes");

        mnListados.setText("Listados");

        mnListadoPersonas.setText("Listado de Personas");
        mnListadoPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnListadoPersonasActionPerformed(evt);
            }
        });
        mnListados.add(mnListadoPersonas);

        mnListadoPorSexo.setText("Listado por Sexo");
        mnListadoPorSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnListadoPorSexoActionPerformed(evt);
            }
        });
        mnListados.add(mnListadoPorSexo);

        mnReportes.add(mnListados);

        mnCantidades.setText("Cantidades");

        mnCantidadPersonasIngresadas.setText("Cantidad de Personas Ingresadas");
        mnCantidadPersonasIngresadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCantidadPersonasIngresadasActionPerformed(evt);
            }
        });
        mnCantidades.add(mnCantidadPersonasIngresadas);

        mnReportes.add(mnCantidades);

        jMenu3.add(mnReportes);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Carros");

        mnAgregarCarros.setText("Agregar");
        mnAgregarCarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAgregarCarrosActionPerformed(evt);
            }
        });
        jMenu4.add(mnAgregarCarros);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnAgregarPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAgregarPersonasActionPerformed
        Agregar a = new Agregar(this,true);
        a.setVisible(true);
    }//GEN-LAST:event_mnAgregarPersonasActionPerformed

    private void mnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalirActionPerformed
     
      System.exit(0);
    }//GEN-LAST:event_mnSalirActionPerformed

    private void mnListadoPorSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnListadoPorSexoActionPerformed
       ListadoPorSexo lps = new ListadoPorSexo(this,true);
       lps.setVisible(true);
    }//GEN-LAST:event_mnListadoPorSexoActionPerformed

    private void mnCantidadPersonasIngresadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCantidadPersonasIngresadasActionPerformed
        int cont;
        cont = Helper.traerDatos(ruta).size();
        Helper.mensaje(this, "El número de personas ingresadas es: "+cont, 1);
        
    }//GEN-LAST:event_mnCantidadPersonasIngresadasActionPerformed

    private void mnListadoPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnListadoPersonasActionPerformed
        ListadoCompleto lc = new ListadoCompleto(this,true);
        lc.setVisible(true);
    }//GEN-LAST:event_mnListadoPersonasActionPerformed

    private void mnAgregarCarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAgregarCarrosActionPerformed
        AgregarCarro ac = new AgregarCarro(this,true);
        ac.setVisible(true);
    }//GEN-LAST:event_mnAgregarCarrosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JMenuItem mnAgregarCarros;
    private javax.swing.JMenuItem mnAgregarPersonas;
    private javax.swing.JMenuItem mnCantidadPersonasIngresadas;
    private javax.swing.JMenu mnCantidades;
    private javax.swing.JMenuItem mnListadoPersonas;
    private javax.swing.JMenuItem mnListadoPorSexo;
    private javax.swing.JMenu mnListados;
    private javax.swing.JMenu mnOpciones;
    private javax.swing.JMenu mnReportes;
    private javax.swing.JMenuItem mnSalir;
    // End of variables declaration//GEN-END:variables
}
