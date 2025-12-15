package batalla.main.vista.reportes;

import batalla.main.dao.DAOPersonaje;
import batalla.main.modelo.modeloPersonajeBD;
import java.util.List;

public class frmComparadorPersonajes extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmComparadorPersonajes.class.getName());

    public frmComparadorPersonajes() {
        initComponents();
        cargarPersonajes();
    }
    
    private void cargarPersonajes() {
        DAOPersonaje daoPersonaje = new DAOPersonaje();
        List<modeloPersonajeBD> todos = daoPersonaje.listarRanking();
        
        cbPersonaje1.removeAllItems();
        cbPersonaje2.removeAllItems();
        cbPersonaje1.addItem("Seleccionar");
        cbPersonaje2.addItem("Seleccionar");
        
        for (modeloPersonajeBD p : todos) {
            cbPersonaje1.addItem(p.getApodo());
            cbPersonaje2.addItem(p.getApodo());
        }
    }  
    private void comparar() {
        String apodo1 = (String) cbPersonaje1.getSelectedItem();
        String apodo2 = (String) cbPersonaje2.getSelectedItem();
        
        if (apodo1 == null || apodo1.equals("Seleccionar") ||
            apodo2 == null || apodo2.equals("Seleccionar")) {
            jTextArea1.setText("Selecciona dos personajes");
            return;
        }
        
        if (apodo1.equals(apodo2)) {
            jTextArea1.setText("Selecciona personajes diferentes");
            return;
        }
        
        DAOPersonaje daoPersonaje = new DAOPersonaje();
        modeloPersonajeBD p1 = daoPersonaje.buscarPorApodo(apodo1);
        modeloPersonajeBD p2 = daoPersonaje.buscarPorApodo(apodo2);
        
        if (p1 == null || p2 == null) {
            jTextArea1.setText("Error");
            return;
        }
        
        String texto = "";
        texto += "COMPARACION\n";
        texto += "\n\n";
        texto += "Personaje 1: " + p1.getApodo() + "\n";
        texto += "Personaje 2: " + p2.getApodo() + "\n\n";
        texto += "---\n\n";
        texto += "Vida:\n";
        texto += p1.getApodo() + ": " + p1.getVidaFinal() + "\n";
        texto += p2.getApodo() + ": " + p2.getVidaFinal() + "\n\n";
        texto += "Ataque:\n";
        texto += p1.getApodo() + ": " + p1.getAtaque() + "\n";
        texto += p2.getApodo() + ": " + p2.getAtaque() + "\n\n";
        texto += "Defensa:\n";
        texto += p1.getApodo() + ": " + p1.getDefensa() + "\n";
        texto += p2.getApodo() + ": " + p2.getDefensa() + "\n\n";
        texto += "Victorias:\n";
        texto += p1.getApodo() + ": " + p1.getVictorias() + "\n";
        texto += p2.getApodo() + ": " + p2.getVictorias() + "\n\n";
        texto += "Derrotas:\n";
        texto += p1.getApodo() + ": " + p1.getDerrotas() + "\n";
        texto += p2.getApodo() + ": " + p2.getDerrotas() + "\n";
        
        jTextArea1.setText(texto);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cbPersonaje1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbPersonaje2 = new javax.swing.JComboBox<>();
        btnComparar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comparador");
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Personaje 1:");

        jLabel2.setText("Personaje 2:");

        btnComparar.setText("Comparar");
        btnComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompararActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnComparar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbPersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComparar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompararActionPerformed(java.awt.event.ActionEvent evt) {
        comparar();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new frmComparadorPersonajes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComparar;
    private javax.swing.JComboBox<String> cbPersonaje1;
    private javax.swing.JComboBox<String> cbPersonaje2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
