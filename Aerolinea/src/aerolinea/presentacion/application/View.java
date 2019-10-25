/*
 * Copyright (C) 2019 pc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package aerolinea.presentacion.application;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pc
 */
public class View extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuFile = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();
        jMenuVuelos = new javax.swing.JMenu();
        jMenuItemBuscadorVuelos = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItemVerInformacion = new javax.swing.JMenuItem();
        jMenuAboutAirline = new javax.swing.JMenu();
        jMenuItemReferente = new javax.swing.JMenuItem();
        jMenuItemHistoria = new javax.swing.JMenuItem();
        jMenuItemContacto = new javax.swing.JMenuItem();
        jMenuOpcionesAdministrador = new javax.swing.JMenu();
        jMenuFlota = new javax.swing.JMenu();
        jMenuItemAgregarTipoAvion = new javax.swing.JMenuItem();
        jMenuItemListadoTiposAviones = new javax.swing.JMenuItem();
        jMenuItemAgregarAvion = new javax.swing.JMenuItem();
        jMenuItemListadoAviones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        jmenuFile.setText("File");

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        jmenuFile.add(menuItemSalir);

        jMenuBar1.add(jmenuFile);

        jMenuVuelos.setText("Vuelos");

        jMenuItemBuscadorVuelos.setText("Buscador de vuelos");
        jMenuVuelos.add(jMenuItemBuscadorVuelos);

        jMenuBar1.add(jMenuVuelos);

        jMenuUsuario.setText("Usuario");

        jMenuItemVerInformacion.setText("Ver información de usuario");
        jMenuItemVerInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerInformacionActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemVerInformacion);

        jMenuBar1.add(jMenuUsuario);

        jMenuAboutAirline.setText("Información de la aerolínea");

        jMenuItemReferente.setText("Referente institucional");
        jMenuItemReferente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReferenteActionPerformed(evt);
            }
        });
        jMenuAboutAirline.add(jMenuItemReferente);

        jMenuItemHistoria.setText("Historia de la aerolínea");
        jMenuItemHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistoriaActionPerformed(evt);
            }
        });
        jMenuAboutAirline.add(jMenuItemHistoria);

        jMenuItemContacto.setText("Contáctenos");
        jMenuAboutAirline.add(jMenuItemContacto);

        jMenuBar1.add(jMenuAboutAirline);

        jMenuOpcionesAdministrador.setText("Opciones de administrador");

        jMenuFlota.setText("Gestión de flota");

        jMenuItemAgregarTipoAvion.setText("Agregar y modificar un tipo de avión");
        jMenuItemAgregarTipoAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarTipoAvionActionPerformed(evt);
            }
        });
        jMenuFlota.add(jMenuItemAgregarTipoAvion);

        jMenuItemListadoTiposAviones.setText("Listado de tipos de aviones en la aerolínea");
        jMenuItemListadoTiposAviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoTiposAvionesActionPerformed(evt);
            }
        });
        jMenuFlota.add(jMenuItemListadoTiposAviones);

        jMenuItemAgregarAvion.setText("Agregar y modificar información de un avión");
        jMenuItemAgregarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarAvionActionPerformed(evt);
            }
        });
        jMenuFlota.add(jMenuItemAgregarAvion);

        jMenuItemListadoAviones.setText("Listado de aviones en la aerolínea");
        jMenuFlota.add(jMenuItemListadoAviones);

        jMenuOpcionesAdministrador.add(jMenuFlota);

        jMenuBar1.add(jMenuOpcionesAdministrador);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
         System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void jMenuItemHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemHistoriaActionPerformed

    private void jMenuItemReferenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReferenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemReferenteActionPerformed

    private void jMenuItemVerInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerInformacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVerInformacionActionPerformed

    private void jMenuItemAgregarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarAvionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAgregarAvionActionPerformed

    private void jMenuItemAgregarTipoAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarTipoAvionActionPerformed
        this.controller.EdicionTipoShow();
    }//GEN-LAST:event_jMenuItemAgregarTipoAvionActionPerformed

    private void jMenuItemListadoTiposAvionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoTiposAvionesActionPerformed
        this.controller.ListadoTipoShow();
    }//GEN-LAST:event_jMenuItemListadoTiposAvionesActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAboutAirline;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFlota;
    private javax.swing.JMenuItem jMenuItemAgregarAvion;
    private javax.swing.JMenuItem jMenuItemAgregarTipoAvion;
    private javax.swing.JMenuItem jMenuItemBuscadorVuelos;
    private javax.swing.JMenuItem jMenuItemContacto;
    private javax.swing.JMenuItem jMenuItemHistoria;
    private javax.swing.JMenuItem jMenuItemListadoAviones;
    private javax.swing.JMenuItem jMenuItemListadoTiposAviones;
    private javax.swing.JMenuItem jMenuItemReferente;
    private javax.swing.JMenuItem jMenuItemVerInformacion;
    private javax.swing.JMenu jMenuOpcionesAdministrador;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JMenu jMenuVuelos;
    private javax.swing.JMenu jmenuFile;
    private javax.swing.JMenuItem menuItemSalir;
    public javax.swing.JDesktopPane panel;
    // End of variables declaration//GEN-END:variables

    public Model model;
    public Controller controller;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        
    }
}
