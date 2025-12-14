/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;
import batalla.main.vista.frmVistaConfiguracion;

/**
 *
 * @author gaspi
 */
public class Main {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            frmVistaConfiguracion ventana = new frmVistaConfiguracion();
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
