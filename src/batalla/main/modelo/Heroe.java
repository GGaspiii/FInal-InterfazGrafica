/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla.main.modelo;

/**
 *
 * @author gaspi
 */
public class Heroe extends Personaje {
    
    public Heroe() {
        super();
    }
    
    public Heroe(String apodo, int vida, int defensa, int fuerza, int bendicion) {
        super(apodo, vida, defensa, fuerza, bendicion);
    }
    
    @Override
    public String getTipo() {
        return "Héroe";
    }
}
