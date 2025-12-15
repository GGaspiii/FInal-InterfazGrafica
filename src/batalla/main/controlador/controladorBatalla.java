package batalla.main.controlador;

import batalla.main.modelo.Batalla;
import batalla.main.modelo.Heroe;
import batalla.main.modelo.Villano;
import batalla.main.modelo.Personaje;
import batalla.main.dao.DAOEstadoPartida;
import batalla.main.dao.DAOPersonaje;
import batalla.main.dao.DAOBatalla;
import batalla.main.modelo.modeloEstadoPartidaBD;
import batalla.main.modelo.modeloPersonajeBD;
import batalla.main.modelo.modeloBatallaBD;
import java.sql.SQLException;

public class controladorBatalla {  
    private Batalla batalla;
    private Heroe heroe;
    private Villano villano;
    private modeloEstadoPartidaBD estadoPartidaBD;
    private int idHeroeBD;
    private int idVillanoBD;
    private int idBatallaBD;


    public controladorBatalla(Heroe heroe, Villano villano) {
        this.heroe = heroe;
        this.villano = villano;
        this.batalla = new Batalla(heroe, villano);
        this.batalla.iniciarBatalla();
    }
    public String siguienteTurno() {
        if (batalla.estaTerminada()) {
            return "La batalla ya terminó. Ganador: " + batalla.obtenerGanador().getApodo();
        }
        return batalla.ejecutarTurno();
    }
    public boolean estaTerminada() {
        return batalla.estaTerminada();
    }
    public Personaje obtenerGanador() {
        return batalla.obtenerGanador();
    }
    public Heroe getHeroe() {
        return heroe;
    }
    public Villano getVillano() {
        return villano;
    }
    public Batalla getBatalla() {
        return batalla;
    }
    public int getTurnoActual() {
        return batalla.getTurnoActual();
    }
    public void guardarPartidaBD() throws SQLException {
        Heroe heroe = getHeroe();
        Villano villano = getVillano();
        
        if (idHeroeBD == 0 || idVillanoBD == 0) {
            DAOPersonaje daoPersonaje = new DAOPersonaje();
            idHeroeBD = obtenerOcrearPersonajeBD(daoPersonaje, heroe, "Heroe");
            idVillanoBD = obtenerOcrearPersonajeBD(daoPersonaje, villano, "Villano");
        }
        
        DAOEstadoPartida daoEstado = new DAOEstadoPartida();
        if (estadoPartidaBD == null) {
            estadoPartidaBD = new modeloEstadoPartidaBD();
            estadoPartidaBD.setIdBatalla(idBatallaBD > 0 ? idBatallaBD : null);
            estadoPartidaBD.setHeroeId(idHeroeBD);
            estadoPartidaBD.setVillanoId(idVillanoBD);
        }
        
        estadoPartidaBD.setVidaHeroe(heroe.getVida());
        estadoPartidaBD.setVidaVillano(villano.getVida());
        estadoPartidaBD.setBendicionHeroe(heroe.getBendicion());
        estadoPartidaBD.setBendicionVillano(villano.getBendicion());
        estadoPartidaBD.setAtaqueHeroe(heroe.getFuerza());
        estadoPartidaBD.setDefensaHeroe(heroe.getDefensa());
        estadoPartidaBD.setAtaqueVillano(villano.getFuerza());
        estadoPartidaBD.setDefensaVillano(villano.getDefensa());
        estadoPartidaBD.setTurnoActual(batalla.getTurnoActual());
        estadoPartidaBD.setFinalizada(batalla.estaTerminada());
        
        if (estadoPartidaBD.getId() == 0) {
            daoEstado.guardar(estadoPartidaBD);
        } else {
            daoEstado.actualizar(estadoPartidaBD);
        }
    }
    
    private int obtenerOcrearPersonajeBD(DAOPersonaje dao, Personaje personaje, String tipo) throws SQLException {
        modeloPersonajeBD personajeBD = dao.buscarPorApodo(personaje.getApodo());
        if (personajeBD == null) {
            personajeBD = new modeloPersonajeBD(personaje.getApodo(), personaje.getApodo(), tipo, 
                                               personaje.getVida(), personaje.getFuerza(), personaje.getDefensa());
            return dao.guardar(personajeBD);
        }
        return personajeBD.getId();
    }
    public static Personaje[] cargarPartidaBD() throws SQLException {
        DAOEstadoPartida daoEstado = new DAOEstadoPartida();
        modeloEstadoPartidaBD estado = daoEstado.cargarUltima();
        
        if (estado == null) {
            return null;
        }
        
        DAOPersonaje daoPersonaje = new DAOPersonaje();
        modeloPersonajeBD heroeBD = daoPersonaje.buscarPorId(estado.getHeroeId());
        modeloPersonajeBD villanoBD = daoPersonaje.buscarPorId(estado.getVillanoId());
        
        if (heroeBD == null || villanoBD == null) {
            return null;
        }
        
        Heroe heroe = new Heroe();
        heroe.crearPersonaje(heroeBD.getApodo(), estado.getVidaHeroe(), estado.getDefensaHeroe(), estado.getAtaqueHeroe(), estado.getBendicionHeroe());
        
        Villano villano = new Villano();
        villano.crearPersonaje(villanoBD.getApodo(), estado.getVidaVillano(), estado.getDefensaVillano(), estado.getAtaqueVillano(), estado.getBendicionVillano());
        
        return new Personaje[]{heroe, villano};
    }
    public void guardarResultadoBatalla() throws SQLException {
        if (!batalla.estaTerminada()) {
            return;
        }
        
        Personaje ganador = batalla.obtenerGanador();
        String ganadorApodo = ganador.getApodo();
        DAOPersonaje daoPersonaje = new DAOPersonaje();
        
        idHeroeBD = actualizarEstadisticasPersonaje(daoPersonaje, getHeroe(), "Heroe", ganadorApodo);
        idVillanoBD = actualizarEstadisticasPersonaje(daoPersonaje, getVillano(), "Villano", ganadorApodo);
        
        if (idHeroeBD <= 0 || idVillanoBD <= 0) {
            throw new SQLException("Error");
        }
        
        int idGanador = ganadorApodo.equals(getHeroe().getApodo()) ? idHeroeBD : idVillanoBD;
        modeloBatallaBD batallaBD = new modeloBatallaBD(idHeroeBD, idVillanoBD, idGanador, batalla.getTurnoActual());
        idBatallaBD = new DAOBatalla().guardar(batallaBD);
    }
    
    private int actualizarEstadisticasPersonaje(DAOPersonaje dao, Personaje personaje, String tipo, String ganadorApodo) throws SQLException {
        modeloPersonajeBD personajeBD = dao.buscarPorApodo(personaje.getApodo());
        
        if (personajeBD == null) {
            personajeBD = new modeloPersonajeBD(personaje.getApodo(), personaje.getApodo(), tipo, 
                                               personaje.getVida(), personaje.getFuerza(), personaje.getDefensa());
            return dao.guardar(personajeBD);
        }
        
        personajeBD.setVidaFinal(personaje.getVida());
        personajeBD.setAtaque(personaje.getFuerza());
        personajeBD.setDefensa(personaje.getDefensa());
        
        if (ganadorApodo.equals(personaje.getApodo())) {
            personajeBD.setVictorias(personajeBD.getVictorias() + 1);
        } else {
            personajeBD.setDerrotas(personajeBD.getDerrotas() + 1);
        }
        
        dao.actualizarEstadisticas(personajeBD);
        return personajeBD.getId();
    }
}
