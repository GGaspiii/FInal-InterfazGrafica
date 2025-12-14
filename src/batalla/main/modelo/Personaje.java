/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla.main.modelo;

/**
 *
 * @author gaspi
 */
public abstract class Personaje {
    
    protected String apodo;
    protected int vida;
    protected int defensa;
    protected int fuerza;
    protected int bendicion;
    
    public Personaje() {
        this.apodo = "";
        this.vida = 0;
        this.defensa = 0;
        this.fuerza = 0;
        this.bendicion = 0;
    }
    
    public Personaje(String apodo, int vida, int defensa, int fuerza, int bendicion) {
        this.apodo = apodo;
        this.vida = vida;
        this.defensa = defensa;
        this.fuerza = fuerza;
        this.bendicion = bendicion;
    }
    
    public String getApodo() {
        return apodo;
    }
    
    public int getVida() {
        return vida;
    }
    
    public int getDefensa() {
        return defensa;
    }
    
    public int getFuerza() {
        return fuerza;
    }
    
    public int getBendicion() {
        return bendicion;
    }
    
    public boolean estaVivo() {
        return vida > 0;
    }
    
    public abstract String getTipo();
}
