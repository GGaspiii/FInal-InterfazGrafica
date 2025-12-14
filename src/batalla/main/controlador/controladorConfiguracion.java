/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla.main.controlador;
import batalla.main.modelo.Heroe;
import batalla.main.modelo.Villano;
import batalla.main.modelo.Personaje;
/**
 *
 * @author gaspi
 */
public class controladorConfiguracion {
    
     private Heroe heroe;
    private Villano villano;
    
    public controladorConfiguracion() {
        this.heroe = null;
        this.villano = null;
    }

    public void agregarPersonaje(String apodo, String tipo, int vida, int fuerza, int defensa, int bendicion) {
        String tipoNormalizado = tipo.trim();
        
        if (tipoNormalizado.equalsIgnoreCase("Heroe")) {
            heroe = new Heroe();
            heroe.crearPersonaje(apodo, vida, defensa, fuerza, bendicion);
            System.out.println("Heroe creado: " + heroe.getApodo());
        } else if (tipoNormalizado.equalsIgnoreCase("Villano")) {
            villano = new Villano();
            villano.crearPersonaje(apodo, vida, defensa, fuerza, bendicion);
            System.out.println("Villano creado: " + villano.getApodo());
        } else {
            throw new IllegalArgumentException("Tipo de personaje inválido: " + tipo + ". Debe ser 'Heroe' o 'Villano'.");
        }
    }
    public void eliminarPersonaje(String tipo) {
        String tipoNormalizado = tipo.trim();
        
        if (tipoNormalizado.equalsIgnoreCase("Heroe")) {
            heroe = null;
            System.out.println("Heroe eliminado");
        } else if (tipoNormalizado.equalsIgnoreCase("Villano")) {
            villano = null;
            System.out.println("Villano eliminado");
        }
    }
    
    public Heroe getHeroe() {
        return heroe;
    }
    public Villano getVillano() {
        return villano;
    }
    public boolean tieneHeroe() {
        return heroe != null;
    }
    public boolean tieneVillano() {
        return villano != null;
    }
    public boolean personajesCompletos() {
        return tieneHeroe() && tieneVillano();
    }
    public void iniciarBatalla(int cantidadBatallas) {
        if (!personajesCompletos()) {
            throw new IllegalStateException("Debés crear un Heroe y un Villano antes de iniciar la batalla.");
        }
        System.out.println("Iniciando batalla con " + cantidadBatallas + " batallas");
    }
    public void cargarPartida() {
        System.out.println("Cargando partida guardada...");
    }
    public void salir() {
        System.out.println("Saliendo del juego...");
    }
}
