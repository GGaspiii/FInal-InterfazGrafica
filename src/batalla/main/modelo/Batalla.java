/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla.main.modelo;


/**
 *
 * @author gaspi
 */
public class Batalla {
    private Heroe heroe;
    private Villano villano;
    private int turnoActual; 
    private boolean terminada;
    private Personaje ganador;
    
     public Batalla(Heroe heroe, Villano villano) {
        if (heroe == null || villano == null) {
            throw new IllegalArgumentException("El Heroe y el Villano no pueden no tener nada");
        }
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
            return "La batalla ya terminó. Ganador: " + ganador.getApodo();
        }
        
        String resultado = "";
        

        if (turnoActual % 2 == 1) {

            resultado = ejecutarAtaque(heroe, villano, "Heroe");
        } else {

            resultado = ejecutarAtaque(villano, heroe, "Villano");
        }
        

        if (!heroe.estaVivo() || !villano.estaVivo()) {
            terminada = true;
            if (heroe.estaVivo()) {
                ganador = heroe;
            } else {
                ganador = villano;
            }
            resultado += "¡La batalla terminó! Ganador: " + ganador.getApodo();
        }
        
        turnoActual++;
        return resultado;
    }
    

    private String ejecutarAtaque(Personaje atacante, Personaje defensor, String nombreAtacante) {
        int dano = calcularDano(atacante, defensor);
        defensor.recibirDano(dano);
        
        String mensaje = "Turno " + turnoActual + ": " + nombreAtacante + " " + atacante.getApodo() 
                + " ataca a " + defensor.getApodo() + " causando " + dano + " de daño.\n";
        mensaje += "Vida restante de " + defensor.getApodo() + ": " + defensor.getVida();
        
        return mensaje;
    }
    
    private int calcularDano(Personaje atacante, Personaje defensor) {
        int dañoBase = atacante.getFuerza() - defensor.getDefensa();
        if (dañoBase < 1) {
            dañoBase = 1;
        }
        return dañoBase;
    }

    public boolean estaTerminada() {
        return terminada || !heroe.estaVivo() || !villano.estaVivo();
    }
    public Personaje obtenerGanador() {
        if (!estaTerminada()) {
            return null;
        }
        if (heroe.estaVivo()) {
            return heroe;
        } else {
            return villano;
        }
    }
    
    public String obtenerEstado() {
        StringBuilder estado = new StringBuilder();
        estado.append("Estado de la Batalla\n");
        estado.append("Turno: ").append(turnoActual).append("\n");
        estado.append("\nHeroe: ").append(heroe.getApodo()).append("\n");
        estado.append("  Vida: ").append(heroe.getVida()).append("\n");
        estado.append("  Fuerza: ").append(heroe.getFuerza()).append("\n");
        estado.append("  Defensa: ").append(heroe.getDefensa()).append("\n");
        estado.append("\nVillano: ").append(villano.getApodo()).append("\n");
        estado.append("  Vida: ").append(villano.getVida()).append("\n");
        estado.append("  Fuerza: ").append(villano.getFuerza()).append("\n");
        estado.append("  Defensa: ").append(villano.getDefensa()).append("\n");
        
        if (estaTerminada()) {
            estado.append("BATALLA TERMINADA\n");
            estado.append("Ganador: ").append(obtenerGanador().getApodo());
        } else {
            estado.append("Batalla en curso...");
        }
        
        return estado.toString();
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
