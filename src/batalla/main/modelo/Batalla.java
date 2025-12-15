package batalla.main.modelo;

public class Batalla {
    private Heroe heroe;
    private Villano villano;
    private int turnoActual; 
    private boolean terminada;
    private Personaje ganador;
    
    public Batalla(Heroe heroe, Villano villano) {
        this.heroe = heroe;
        this.villano = villano;
        this.turnoActual = 0;
        this.terminada = false;
        this.ganador = null;
    }

    public void iniciarBatalla() {
        this.turnoActual = 1;
        this.terminada = false;
        this.ganador = null;
    }
    
    public String ejecutarTurno() {
        if (terminada) {
            return "La batalla ya terminó, Ganador: " + ganador.getApodo();
        }
        
        String resultado = (turnoActual % 2 == 1) 
            ? ejecutarAtaque(heroe, villano, "Heroe")
            : ejecutarAtaque(villano, heroe, "Villano");
        
        if (!heroe.estaVivo() || !villano.estaVivo()) {
            terminada = true;
            ganador = heroe.estaVivo() ? heroe : villano;
            resultado += "La batalla terminó Ganador: " + ganador.getApodo();
        }
        
        turnoActual++;
        return resultado;
    }
    
    private String ejecutarAtaque(Personaje atacante, Personaje defensor, String nombreAtacante) {
        int daño = calcularDaño(atacante, defensor);
        defensor.recibirDaño(daño);
        String mensaje = "Turno " + turnoActual + ": " + nombreAtacante + " " + atacante.getApodo() + " ataca a " + defensor.getApodo() + " causando " + daño + " de daño\n";
        mensaje += "Vida restante de " + defensor.getApodo() + ": " + defensor.getVida();
        return mensaje;
    }
    
    private int calcularDaño(Personaje atacante, Personaje defensor) {
        int dañoBase = Math.max(1, atacante.getFuerza() - defensor.getDefensa());
        java.util.Random random = new java.util.Random();
        double multiplicador = 0.9 + (random.nextDouble() * 0.2);
        int dañoFinal = Math.max(1, (int) Math.round(dañoBase * multiplicador));
        
        if (random.nextDouble() < 0.15) {
            dañoFinal = (int) Math.round(dañoFinal * 1.5);
        }
        return dañoFinal;
    }
    public boolean estaTerminada() {
        return terminada || !heroe.estaVivo() || !villano.estaVivo();
    }
    
    public Personaje obtenerGanador() {
        if (!estaTerminada()) {
            return null;
        }
        return heroe.estaVivo() ? heroe : villano;
    }
    
    public String obtenerEstado() {
        String estado = "";
        estado += "Estado de la Batalla\n";
        estado += "Turno: " + turnoActual + "\n";
        estado += "\nHeroe: " + heroe.getApodo() + "\n";
        estado += "  Vida: " + heroe.getVida() + "\n";
        estado += "  Fuerza: " + heroe.getFuerza() + "\n";
        estado += "  Defensa: " + heroe.getDefensa() + "\n";
        estado += "\nVillano: " + villano.getApodo() + "\n";
        estado += "  Vida: " + villano.getVida() + "\n";
        estado += "  Fuerza: " + villano.getFuerza() + "\n";
        estado += "  Defensa: " + villano.getDefensa() + "\n";
        
        if (estaTerminada()) {
            estado += "BATALLA TERMINADA\n";
            estado += "Ganador: " + obtenerGanador().getApodo();
        } else {
            estado += "Batalla en curso...";
        }
        
        return estado;
    }
    
    public Heroe getHeroe() {
        return heroe;
    }
    public Villano getVillano() {
        return villano;
    }
    public int getTurnoActual() {
        return turnoActual;
    }
    public boolean isTerminada() {
        return terminada;
    }
}
