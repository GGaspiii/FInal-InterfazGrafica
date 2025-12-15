package batalla.main.modelo;

public class Heroe extends Personaje {
    
    public Heroe() {
        super();
    }
    public Heroe(String apodo, int vida, int defensa, int fuerza, int bendicion) {
        super(apodo, vida, defensa, fuerza, bendicion);
    }
    @Override
    public String getTipo() {
        return "Heroe"; 
    }
}
