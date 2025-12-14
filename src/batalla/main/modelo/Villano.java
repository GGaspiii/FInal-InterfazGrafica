/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla.main.modelo;

/**
 *
 * @author gaspi
 */
public class Villano extends Personaje {
    
    public Villano() {
        super();
    }
    
    public Villano(String apodo, int vida, int defensa, int fuerza, int bendicion) {
        super(apodo, vida, defensa, fuerza, bendicion);
    }
    
    @Override
    public String getTipo() {
        return "Villano";
    }
}
