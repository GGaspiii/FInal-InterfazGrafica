package batalla.main.modelo;

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
