package batalla;
import batalla.main.vista.frmVistaConfiguracion;

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
