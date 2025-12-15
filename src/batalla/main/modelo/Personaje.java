package batalla.main.modelo;

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
    public void crearPersonaje(String apodo, int vida, int defensa, int fuerza, int bendicion) {
        this.apodo = validarApodo(apodo);
        this.vida = vida;
        this.defensa = defensa;
        this.fuerza = fuerza;
        this.bendicion = bendicion;
    }
    
    public String validarApodo(String apodo) {
        if (apodo == null || apodo.trim().isEmpty()) {
            throw new IllegalArgumentException("El apodo no puede estar vacío");
        }
        apodo = apodo.trim();
        if (!apodo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("El apodo tiene contener letras y espacios unicamente");
        }
        if (apodo.length() < 3 || apodo.length() > 10) {
            throw new IllegalArgumentException("El apodo debe tener entre 3 y 10 caracteres");
        }
        return apodo;
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
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public void setBendicion(int bendicion) {
        this.bendicion = bendicion;
    }
    public void curarse(int curacion) {
        this.vida += curacion;
    }
    public void recibirDaño(int daño) {
        this.vida = Math.max(0, this.vida - daño);
    }
    public void incrementarDefensa(int incremento) {
        this.defensa += incremento;
    }
    public void incrementarFuerza(int incremento) {
        this.fuerza += incremento;
    }
    public boolean estaVivo() {
        return vida > 0;
    }
    public abstract String getTipo();
}
