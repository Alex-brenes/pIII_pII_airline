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
public class View extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
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
        jMenuBar = new javax.swing.JMenuBar();
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
        jMenuTipoAvion = new javax.swing.JMenu();
        jMenuItemAgregarTipoAvion = new javax.swing.JMenuItem();
        jMenuItemListadoTiposAviones = new javax.swing.JMenuItem();
        jMenuAvion = new javax.swing.JMenu();
        jMenuItemAgregarAvion = new javax.swing.JMenuItem();
        jMenuItemListadoAviones = new javax.swing.JMenuItem();
        jMenuAeropuertos = new javax.swing.JMenu();
        jMenuPaises = new javax.swing.JMenu();
        jMenuItemEdicionPais = new javax.swing.JMenuItem();
        jMenuItemListadoPais = new javax.swing.JMenuItem();
        jMenuCiudades = new javax.swing.JMenu();
        jMenuItemEdicionCiuadades = new javax.swing.JMenuItem();
        jMenuItemListadoCiudades = new javax.swing.JMenuItem();
        jMenuVuelo = new javax.swing.JMenu();
        jMenuItemEdicionVuelo = new javax.swing.JMenuItem();
        jMenuItemListadoVuelo = new javax.swing.JMenuItem();
        jMenuViaje = new javax.swing.JMenu();
        jMenuItemEdicionViaje = new javax.swing.JMenuItem();
        jMenuItemListadoViajes = new javax.swing.JMenuItem();
        jMenuFormaPago = new javax.swing.JMenu();
        jMenuItemFormaPagoEdicion = new javax.swing.JMenuItem();
        jMenuItemListadoFormaPago = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 130, 221));

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

        jMenuBar.add(jmenuFile);

        jMenuVuelos.setText("Vuelos");

        jMenuItemBuscadorVuelos.setText("Buscador de vuelos");
        jMenuVuelos.add(jMenuItemBuscadorVuelos);

        jMenuBar.add(jMenuVuelos);

        jMenuUsuario.setText("Usuario");

        jMenuItemVerInformacion.setText("Ver información de usuario");
        jMenuItemVerInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerInformacionActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemVerInformacion);

        jMenuBar.add(jMenuUsuario);

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

        jMenuBar.add(jMenuAboutAirline);

        jMenuOpcionesAdministrador.setText("Opciones de administrador");

        jMenuFlota.setText("Gestión de flota");

        jMenuTipoAvion.setText("Gestión de tipos de aviones");

        jMenuItemAgregarTipoAvion.setText("Agregar y modificar información de un tipo de avión");
        jMenuItemAgregarTipoAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarTipoAvionActionPerformed(evt);
            }
        });
        jMenuTipoAvion.add(jMenuItemAgregarTipoAvion);

        jMenuItemListadoTiposAviones.setText("Listado de tipos de aviones en la aerolínea");
        jMenuItemListadoTiposAviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoTiposAvionesActionPerformed(evt);
            }
        });
        jMenuTipoAvion.add(jMenuItemListadoTiposAviones);

        jMenuFlota.add(jMenuTipoAvion);

        jMenuAvion.setText("Gestión de aviones");

        jMenuItemAgregarAvion.setText("Agregar y modificar información de un avión");
        jMenuItemAgregarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarAvionActionPerformed(evt);
            }
        });
        jMenuAvion.add(jMenuItemAgregarAvion);

        jMenuItemListadoAviones.setText("Listado de aviones en la aerolínea");
        jMenuItemListadoAviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoAvionesActionPerformed(evt);
            }
        });
        jMenuAvion.add(jMenuItemListadoAviones);

        jMenuFlota.add(jMenuAvion);

        jMenuOpcionesAdministrador.add(jMenuFlota);

        jMenuAeropuertos.setText("Gestión de aeropuertos");

        jMenuPaises.setText("Gestión de países");

        jMenuItemEdicionPais.setText("Agregar y modificar información de un país");
        jMenuItemEdicionPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdicionPaisActionPerformed(evt);
            }
        });
        jMenuPaises.add(jMenuItemEdicionPais);

        jMenuItemListadoPais.setText("Listado de países");
        jMenuItemListadoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoPaisActionPerformed(evt);
            }
        });
        jMenuPaises.add(jMenuItemListadoPais);

        jMenuAeropuertos.add(jMenuPaises);

        jMenuCiudades.setText("Gestión de ciudades");

        jMenuItemEdicionCiuadades.setText("Agregar y modificar información de una ciudad");
        jMenuItemEdicionCiuadades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdicionCiuadadesActionPerformed(evt);
            }
        });
        jMenuCiudades.add(jMenuItemEdicionCiuadades);

        jMenuItemListadoCiudades.setText("Listado de ciudades");
        jMenuItemListadoCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoCiudadesActionPerformed(evt);
            }
        });
        jMenuCiudades.add(jMenuItemListadoCiudades);

        jMenuAeropuertos.add(jMenuCiudades);

        jMenuOpcionesAdministrador.add(jMenuAeropuertos);

        jMenuVuelo.setText("Gestión de vuelos");

        jMenuItemEdicionVuelo.setText("Agregar y editar información de un vuelo");
        jMenuItemEdicionVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdicionVueloActionPerformed(evt);
            }
        });
        jMenuVuelo.add(jMenuItemEdicionVuelo);

        jMenuItemListadoVuelo.setText("Listado de vuelos");
        jMenuItemListadoVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoVueloActionPerformed(evt);
            }
        });
        jMenuVuelo.add(jMenuItemListadoVuelo);

        jMenuOpcionesAdministrador.add(jMenuVuelo);

        jMenuViaje.setText("Gestión de viajes");

        jMenuItemEdicionViaje.setText("Agregar y editar información de un viaje");
        jMenuItemEdicionViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdicionViajeActionPerformed(evt);
            }
        });
        jMenuViaje.add(jMenuItemEdicionViaje);

        jMenuItemListadoViajes.setText("Listado de viajes");
        jMenuItemListadoViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoViajesActionPerformed(evt);
            }
        });
        jMenuViaje.add(jMenuItemListadoViajes);

        jMenuOpcionesAdministrador.add(jMenuViaje);

        jMenuFormaPago.setText("Gestión de formas de pago");

        jMenuItemFormaPagoEdicion.setText("Agregar y modificar forma de pago");
        jMenuItemFormaPagoEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFormaPagoEdicionActionPerformed(evt);
            }
        });
        jMenuFormaPago.add(jMenuItemFormaPagoEdicion);

        jMenuItemListadoFormaPago.setText("Listado de formas de pago");
        jMenuItemListadoFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoFormaPagoActionPerformed(evt);
            }
        });
        jMenuFormaPago.add(jMenuItemListadoFormaPago);

        jMenuOpcionesAdministrador.add(jMenuFormaPago);

        jMenuBar.add(jMenuOpcionesAdministrador);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
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
        this.controller.EdicionAvionShow();
    }//GEN-LAST:event_jMenuItemAgregarAvionActionPerformed

    private void jMenuItemAgregarTipoAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarTipoAvionActionPerformed
        this.controller.EdicionTipoShow();
    }//GEN-LAST:event_jMenuItemAgregarTipoAvionActionPerformed

    private void jMenuItemListadoTiposAvionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoTiposAvionesActionPerformed
        this.controller.ListadoTipoShow();
    }//GEN-LAST:event_jMenuItemListadoTiposAvionesActionPerformed

    private void jMenuItemListadoAvionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoAvionesActionPerformed
        this.controller.ListadoAvionShow();
    }//GEN-LAST:event_jMenuItemListadoAvionesActionPerformed

    private void jMenuItemListadoCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoCiudadesActionPerformed
        this.controller.ListadoCiudadShow();
    }//GEN-LAST:event_jMenuItemListadoCiudadesActionPerformed

    private void jMenuItemEdicionPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEdicionPaisActionPerformed
        this.controller.EdicionPaisShow();
    }//GEN-LAST:event_jMenuItemEdicionPaisActionPerformed

    private void jMenuItemListadoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoPaisActionPerformed
        this.controller.ListadoPaisShow();
    }//GEN-LAST:event_jMenuItemListadoPaisActionPerformed

    private void jMenuItemEdicionCiuadadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEdicionCiuadadesActionPerformed
        this.controller.EdicionCiudadShow();
    }//GEN-LAST:event_jMenuItemEdicionCiuadadesActionPerformed

    private void jMenuItemFormaPagoEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFormaPagoEdicionActionPerformed
        this.controller.EdicionFormaPagoShow();
    }//GEN-LAST:event_jMenuItemFormaPagoEdicionActionPerformed

    private void jMenuItemListadoFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoFormaPagoActionPerformed
        this.controller.ListadoFormaPagoShow();
    }//GEN-LAST:event_jMenuItemListadoFormaPagoActionPerformed

    private void jMenuItemEdicionVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEdicionVueloActionPerformed
        this.controller.EdicionVueloShow();
    }//GEN-LAST:event_jMenuItemEdicionVueloActionPerformed

    private void jMenuItemListadoVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoVueloActionPerformed
        this.controller.ListadoVueloShow();
    }//GEN-LAST:event_jMenuItemListadoVueloActionPerformed

    private void jMenuItemEdicionViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEdicionViajeActionPerformed
        this.controller.EdicionViajeShow();
    }//GEN-LAST:event_jMenuItemEdicionViajeActionPerformed

    private void jMenuItemListadoViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoViajesActionPerformed
        this.controller.ListadoViajeShow();
    }//GEN-LAST:event_jMenuItemListadoViajesActionPerformed

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
    private javax.swing.JMenu jMenuAeropuertos;
    private javax.swing.JMenu jMenuAvion;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCiudades;
    private javax.swing.JMenu jMenuFlota;
    private javax.swing.JMenu jMenuFormaPago;
    private javax.swing.JMenuItem jMenuItemAgregarAvion;
    private javax.swing.JMenuItem jMenuItemAgregarTipoAvion;
    private javax.swing.JMenuItem jMenuItemBuscadorVuelos;
    private javax.swing.JMenuItem jMenuItemContacto;
    private javax.swing.JMenuItem jMenuItemEdicionCiuadades;
    private javax.swing.JMenuItem jMenuItemEdicionPais;
    private javax.swing.JMenuItem jMenuItemEdicionViaje;
    private javax.swing.JMenuItem jMenuItemEdicionVuelo;
    private javax.swing.JMenuItem jMenuItemFormaPagoEdicion;
    private javax.swing.JMenuItem jMenuItemHistoria;
    private javax.swing.JMenuItem jMenuItemListadoAviones;
    private javax.swing.JMenuItem jMenuItemListadoCiudades;
    private javax.swing.JMenuItem jMenuItemListadoFormaPago;
    private javax.swing.JMenuItem jMenuItemListadoPais;
    private javax.swing.JMenuItem jMenuItemListadoTiposAviones;
    private javax.swing.JMenuItem jMenuItemListadoViajes;
    private javax.swing.JMenuItem jMenuItemListadoVuelo;
    private javax.swing.JMenuItem jMenuItemReferente;
    private javax.swing.JMenuItem jMenuItemVerInformacion;
    private javax.swing.JMenu jMenuOpcionesAdministrador;
    private javax.swing.JMenu jMenuPaises;
    private javax.swing.JMenu jMenuTipoAvion;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JMenu jMenuViaje;
    private javax.swing.JMenu jMenuVuelo;
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
    public void update(Observable o, Object arg) {

    }
}
