/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla.main.controlador;

/**
 *
 * @author gaspi
 */
public class controladorConfiguracion {
    
    public controladorConfiguracion() {
        System.out.println("[Controlador] ControladorConfiguracion creado.");
    }
    
    public void agregarPersonaje(String apodo, String tipo, int vida, int fuerza, int defensa, int bendicion) {
        System.out.println("[Controlador] ACCIÓN: Agregar Personaje");
        System.out.println("  -> Apodo: " + apodo);
        System.out.println("  -> Tipo: " + tipo);
        System.out.println("  -> Vida: " + vida);
        System.out.println("  -> Fuerza: " + fuerza);
        System.out.println("  -> Defensa: " + defensa);
        System.out.println("  -> Bendición: " + bendicion);
    }
    
    public void eliminarPersonaje(int indice) {
        System.out.println("[Controlador] ACCIÓN: Eliminar Personaje");
        System.out.println("  -> Índice: " + indice);
    }
    
    public void iniciarBatalla(int cantidadBatallas) {
        System.out.println("[Controlador] ACCIÓN: Iniciar Batalla");
        System.out.println("  -> Cantidad de batallas: " + cantidadBatallas);
    }
    
    public void cargarPartida() {
        System.out.println("[Controlador] ACCIÓN: Cargar Partida");
    }
    
    public void salir() {
        System.out.println("[Controlador] ACCIÓN: Salir");
    }
}
