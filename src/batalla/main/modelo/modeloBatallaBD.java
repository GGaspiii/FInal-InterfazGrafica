package batalla.main.modelo;

public class modeloBatallaBD {
    private int id;
    private int heroeId;
    private int villanoId;
    private Integer ganadorId; 
    private int turnos;
    
    public modeloBatallaBD() {}
    
    public modeloBatallaBD(int heroeId, int villanoId, Integer ganadorId, int turnos) {
        this.heroeId = heroeId;
        this.villanoId = villanoId;
        this.ganadorId = ganadorId;
        this.turnos = turnos;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getHeroeId() { return heroeId; }
    public void setHeroeId(int heroeId) { this.heroeId = heroeId; }
    public int getVillanoId() { return villanoId; }
    public void setVillanoId(int villanoId) { this.villanoId = villanoId; }
    public Integer getGanadorId() { return ganadorId; }
    public void setGanadorId(Integer ganadorId) { this.ganadorId = ganadorId; }
    public int getTurnos() { return turnos; }
    public void setTurnos(int turnos) { this.turnos = turnos; }
}
