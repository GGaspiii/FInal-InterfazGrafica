/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package batalla.main.vista;
import batalla.main.controlador.controladorBatalla;
import batalla.main.modelo.Heroe;
import batalla.main.modelo.Villano;
import batalla.main.modelo.Personaje;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class frmBatalla extends javax.swing.JFrame {
    private controladorBatalla controladorBatalla;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmBatalla.class.getName());
    private int batallaActual = 1;
    private int cantidadBatallas = 1;
    private int vidaOriginalHeroe;
    private int vidaOriginalVillano;
    private int fuerzaOriginalHeroe;
    private int fuerzaOriginalVillano;
    private int defensaOriginalHeroe;
    private int defensaOriginalVillano;
    private int bendicionOriginalHeroe;
    private int bendicionOriginalVillano;
    
    private void iniciar() {
    Heroe heroe = controladorBatalla.getHeroe();
    Villano villano = controladorBatalla.getVillano();
    if (vidaOriginalHeroe == 0) {
        vidaOriginalHeroe = heroe.getVida();
        fuerzaOriginalHeroe = heroe.getFuerza();
        defensaOriginalHeroe = heroe.getDefensa();
        bendicionOriginalHeroe = heroe.getBendicion();
        
        vidaOriginalVillano = villano.getVida();
        fuerzaOriginalVillano = villano.getFuerza();
        defensaOriginalVillano = villano.getDefensa();
        bendicionOriginalVillano = villano.getBendicion();
    }
    
  lblApodoHeroe.setText("Apodo: " + heroe.getApodo());
    lblVidaHeroe.setText("Vida: " + heroe.getVida());
    lblFuerzaHeroe.setText("Fuerza: " + heroe.getFuerza());
    lblDefensaHeroe.setText("Defensa: " + heroe.getDefensa());
    lblBendicionHeroe.setText("Bendicion: " + heroe.getBendicion());    
    pbVidaHeroe.setMinimum(0);
    pbVidaHeroe.setMaximum(heroe.getVida());
    pbVidaHeroe.setValue(heroe.getVida());    
    lblApodoVillano.setText("Apodo: " + villano.getApodo());
    lblVidaVillano.setText("Vida: " + villano.getVida());
    lblFuerzaVillano.setText("Fuerza: " + villano.getFuerza());
    lblDefensaVillano.setText("Defensa: " + villano.getDefensa());
    lblBendicionVillano.setText("Bendicion: " + villano.getBendicion());
    
    pbVidaVillano.setMinimum(0);
    pbVidaVillano.setMaximum(villano.getVida());
    pbVidaVillano.setValue(villano.getVida());
    
    actualizarInfoPartida();
}

private void actualizarInfoPartida() {
    lblTurnoActual.setText("Turno Actual: Turno " + controladorBatalla.getTurnoActual());
    lblBatallaActual.setText("Batalla Actual: Partida " + batallaActual + "/" + cantidadBatallas); 
}

public frmBatalla(Heroe heroe, Villano villano, int cantidadBatallas) {
    initComponents();
    this.cantidadBatallas = cantidadBatallas;
    this.batallaActual = 1;
    this.setSize(900, 700);
    this.setResizable(false);
    this.setLocationRelativeTo(null);

    txtEventos.setEditable(false);
    txtEventos.setEnabled(true);
    txtEventos.setLineWrap(true);
    txtEventos.setWrapStyleWord(true);
    
    controladorBatalla = new controladorBatalla(heroe, villano);
    iniciar();
    txtEventos.setText(" Empieza la Batalla " + batallaActual + " entre "+ heroe.getApodo() + " y " + villano.getApodo() + "!\n\n");
    btnSiguienteBatalla.setEnabled(false);
}
    public frmBatalla() {
         initComponents();
         
    this.setSize(900, 700);
    this.setResizable(false);   
    this.setLocationRelativeTo(null);   
    txtEventos.setEditable(false);
    txtEventos.setEnabled(true);
    txtEventos.setLineWrap(true);
    txtEventos.setWrapStyleWord(true);

    lblTurnoActual.setText("Turno Actual: Turno 1");
    lblBatallaActual.setText("Batalla Actual: Partida 1/1");
    pbVidaHeroe.setMinimum(0);
    pbVidaHeroe.setMaximum(100);
    pbVidaHeroe.setValue(100);
    pbVidaVillano.setMinimum(0);
    pbVidaVillano.setMaximum(100);
    pbVidaVillano.setValue(100);
    txtEventos.setText("Empieza la batalla\n\n");
    }
    private void actualizar() {
    Heroe heroe = controladorBatalla.getHeroe();
    Villano villano = controladorBatalla.getVillano();
    
    lblVidaHeroe.setText("Vida: " + heroe.getVida());
    lblBendicionHeroe.setText("Bendicion: " + heroe.getBendicion());
    pbVidaHeroe.setValue(heroe.getVida());
    lblVidaVillano.setText("Vida: " + villano.getVida());
    lblBendicionVillano.setText("Bendicion: " + villano.getBendicion());
    pbVidaVillano.setValue(villano.getVida());
    actualizarInfoPartida();
}
public frmBatalla(Heroe heroe, Villano villano) {
    initComponents();
    
    this.setSize(900, 700);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    txtEventos.setEditable(false);
    txtEventos.setEnabled(true);
    txtEventos.setLineWrap(true);
    txtEventos.setWrapStyleWord(true);
    
    controladorBatalla = new controladorBatalla(heroe, villano);
    

    iniciar();
    txtEventos.setText("Empieza la batalla entre " + heroe.getApodo() + " y " + villano.getApodo() + "\n\n");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTurnoActual = new javax.swing.JLabel();
        lblBatallaActual = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblApodoHeroe = new javax.swing.JLabel();
        lblVidaHeroe = new javax.swing.JLabel();
        pbVidaHeroe = new javax.swing.JProgressBar();
        lblFuerzaHeroe = new javax.swing.JLabel();
        lblDefensaHeroe = new javax.swing.JLabel();
        lblBendicionHeroe = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblApodoVillano = new javax.swing.JLabel();
        lblVidaVillano = new javax.swing.JLabel();
        pbVidaVillano = new javax.swing.JProgressBar();
        lblFuerzaVillano = new javax.swing.JLabel();
        lblDefensaVillano = new javax.swing.JLabel();
        lblBendicionVillano = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jscrollpanel = new javax.swing.JScrollPane();
        txtEventos = new javax.swing.JTextArea();
        btnSiguienteTurno = new javax.swing.JButton();
        btnSiguienteBatalla = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        btnGuardarPartida = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        btnHistorial = new javax.swing.JMenuItem();
        btnEstadisticas = new javax.swing.JMenuItem();
        btnComparador = new javax.swing.JMenuItem();
        btnRanking = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        lblTurnoActual.setText("Turno Actual");

        lblBatallaActual.setText("Batalla Actual");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurnoActual)
                    .addComponent(lblBatallaActual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTurnoActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBatallaActual)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel1.setText("Heroe");

        lblApodoHeroe.setText("Apodo :");

        lblVidaHeroe.setText("Vida :");

        pbVidaHeroe.setValue(100);
        pbVidaHeroe.setPreferredSize(new java.awt.Dimension(200, 25));

        lblFuerzaHeroe.setText("Fuerza:");

        lblDefensaHeroe.setText("Defensa :");

        lblBendicionHeroe.setText("Bendicion :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblApodoHeroe))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVidaHeroe))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pbVidaHeroe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFuerzaHeroe))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDefensaHeroe))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBendicionHeroe)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApodoHeroe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVidaHeroe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbVidaHeroe, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFuerzaHeroe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDefensaHeroe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBendicionHeroe)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel7.setText("Villano");

        lblApodoVillano.setText("Apodo :");

        lblVidaVillano.setText("Vida :");

        pbVidaVillano.setValue(100);
        pbVidaVillano.setPreferredSize(new java.awt.Dimension(200, 25));

        lblFuerzaVillano.setText("Fuerza:");

        lblDefensaVillano.setText("Defensa :");

        lblBendicionVillano.setText("Bendicion :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblApodoVillano))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVidaVillano))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pbVidaVillano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFuerzaVillano))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDefensaVillano))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBendicionVillano)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApodoVillano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVidaVillano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbVidaVillano, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFuerzaVillano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDefensaVillano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBendicionVillano)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jscrollpanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jscrollpanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        txtEventos.setEditable(false);
        txtEventos.setEnabled(true);
        txtEventos.setColumns(20);
        txtEventos.setLineWrap(true);
        txtEventos.setRows(5);
        txtEventos.setWrapStyleWord(true);
        txtEventos.setAutoscrolls(false);
        txtEventos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtEventos.setPreferredSize(new java.awt.Dimension(500, 200));
        jscrollpanel.setViewportView(txtEventos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jscrollpanel)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jscrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnSiguienteTurno.setText("Siguiente Turno");
        btnSiguienteTurno.addActionListener(this::btnSiguienteTurnoActionPerformed);

        btnSiguienteBatalla.setText("Siguiente Batalla");
        btnSiguienteBatalla.addActionListener(this::btnSiguienteBatallaActionPerformed);

        jMenuArchivo.setText("Archivo");

        btnGuardarPartida.setText("Guardar Partida");
        btnGuardarPartida.addActionListener(this::btnGuardarPartidaActionPerformed);
        jMenuArchivo.add(btnGuardarPartida);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        jMenuArchivo.add(btnSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuReportes.setText("Reportes");

        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(this::btnHistorialActionPerformed);
        jMenuReportes.add(btnHistorial);

        btnEstadisticas.setText("Estadisticas");
        btnEstadisticas.addActionListener(this::btnEstadisticasActionPerformed);
        jMenuReportes.add(btnEstadisticas);

        btnComparador.setText("Comparador de Personajes");
        btnComparador.addActionListener(this::btnComparadorActionPerformed);
        jMenuReportes.add(btnComparador);

        btnRanking.setText("Ranking");
        btnRanking.addActionListener(this::btnRankingActionPerformed);
        jMenuReportes.add(btnRanking);

        jMenuBar1.add(jMenuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnSiguienteTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguienteBatalla)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguienteTurno)
                    .addComponent(btnSiguienteBatalla))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteBatallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteBatallaActionPerformed
      if (controladorBatalla == null) {
        return;
    }
    
    if (!controladorBatalla.estaTerminada()) {
        return;
    }
    
    try {
        controladorBatalla.guardarResultadoBatalla();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Error al guardar resultado: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
        e.printStackTrace();
    }
    
    if (batallaActual >= cantidadBatallas) {
        JOptionPane.showMessageDialog(
            this,
            "!Todas las batallas han finalizado!",
            "Fin del Juego",
            JOptionPane.INFORMATION_MESSAGE
        );
        btnSiguienteBatalla.setEnabled(false);
        return;
    }
    batallaActual++;
    
    Heroe heroe = controladorBatalla.getHeroe();
    Villano villano = controladorBatalla.getVillano();
    heroe.setVida(vidaOriginalHeroe);
    heroe.setFuerza(fuerzaOriginalHeroe);
    heroe.setDefensa(defensaOriginalHeroe);
    heroe.setBendicion(bendicionOriginalHeroe);
    villano.setVida(vidaOriginalVillano);
    villano.setFuerza(fuerzaOriginalVillano);
    villano.setDefensa(defensaOriginalVillano);
    villano.setBendicion(bendicionOriginalVillano);
   
    controladorBatalla = new controladorBatalla(heroe, villano);
    iniciar();
    actualizarInfoPartida();
    txtEventos.append("\n\n Empieza la Batalla " + batallaActual + " entre ");
    txtEventos.append(heroe.getApodo() + " y " + villano.getApodo() + "!\n\n");
    btnSiguienteTurno.setEnabled(true);
    btnSiguienteBatalla.setEnabled(false);
    }//GEN-LAST:event_btnSiguienteBatallaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        batalla.main.vista.reportes.frmHistorial ventana = new batalla.main.vista.reportes.frmHistorial();
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        batalla.main.vista.reportes.frmEstadisticas ventana = new batalla.main.vista.reportes.frmEstadisticas();
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEstadisticasActionPerformed

    private void btnComparadorActionPerformed(java.awt.event.ActionEvent evt) {
        batalla.main.vista.reportes.frmComparadorPersonajes ventana = new batalla.main.vista.reportes.frmComparadorPersonajes();
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {
        batalla.main.vista.reportes.frmRanking ventana = new batalla.main.vista.reportes.frmRanking();
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "?Estas seguro que queres salir?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSiguienteTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTurnoActionPerformed
        if (controladorBatalla == null) {
        JOptionPane.showMessageDialog(
            this,
            "La batalla no fue iniciada",
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
        return;
    }
    
    if (controladorBatalla.estaTerminada()) {
        JOptionPane.showMessageDialog(
            this,
            "La batalla ya termino, Ganador: " + controladorBatalla.obtenerGanador().getApodo(),
            "Batalla Finalizada",
            JOptionPane.INFORMATION_MESSAGE
        );
        return;
    }
    
    String resultado = controladorBatalla.siguienteTurno();
    txtEventos.append(resultado + "\n\n");
    
    actualizar();
    
    if (controladorBatalla.estaTerminada()) {
        Personaje ganador = controladorBatalla.obtenerGanador();
        String mensajeGanador = "\n BATALLA TERMINADA \n";
        mensajeGanador += "Ganador: " + ganador.getApodo() + "\n";
        mensajeGanador += "Vida restante: " + ganador.getVida();
        
        txtEventos.append(mensajeGanador);
        
        JOptionPane.showMessageDialog(
            this,
            "Batalla terminada \nGanador: " + ganador.getApodo(),
            "Batalla Finalizada",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        btnSiguienteTurno.setEnabled(false);
        
        if (batallaActual < cantidadBatallas) {
            btnSiguienteBatalla.setEnabled(true);
        } else {
            btnSiguienteBatalla.setEnabled(false);
            txtEventos.append("\n Todas las batallas finalizaron \n");
        }
    }
    }//GEN-LAST:event_btnSiguienteTurnoActionPerformed

    private void btnGuardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPartidaActionPerformed
    if (controladorBatalla == null) {
        JOptionPane.showMessageDialog(
            this,
            "No hay una batalla para guardar",
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
                 btnSiguienteBatalla.setEnabled(true);
                 btnSiguienteTurno.setEnabled(false);
        return;
    }
    try {
        controladorBatalla.guardarPartidaBD();
        
        JOptionPane.showMessageDialog(
            this,
            "Partida guardada exitosamente",
            "Exito",
            JOptionPane.INFORMATION_MESSAGE
        );
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Error al guardar la partida: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
        e.printStackTrace();
    }        
    }//GEN-LAST:event_btnGuardarPartidaActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new frmBatalla().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnComparador;
    private javax.swing.JMenuItem btnEstadisticas;
    private javax.swing.JMenuItem btnGuardarPartida;
    private javax.swing.JMenuItem btnHistorial;
    private javax.swing.JMenuItem btnRanking;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JButton btnSiguienteBatalla;
    private javax.swing.JButton btnSiguienteTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jscrollpanel;
    private javax.swing.JLabel lblApodoHeroe;
    private javax.swing.JLabel lblApodoVillano;
    private javax.swing.JLabel lblBatallaActual;
    private javax.swing.JLabel lblBendicionHeroe;
    private javax.swing.JLabel lblBendicionVillano;
    private javax.swing.JLabel lblDefensaHeroe;
    private javax.swing.JLabel lblDefensaVillano;
    private javax.swing.JLabel lblFuerzaHeroe;
    private javax.swing.JLabel lblFuerzaVillano;
    private javax.swing.JLabel lblTurnoActual;
    private javax.swing.JLabel lblVidaHeroe;
    private javax.swing.JLabel lblVidaVillano;
    private javax.swing.JProgressBar pbVidaHeroe;
    private javax.swing.JProgressBar pbVidaVillano;
    private javax.swing.JTextArea txtEventos;
    // End of variables declaration//GEN-END:variables
}
