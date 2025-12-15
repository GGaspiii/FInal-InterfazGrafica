package batalla.main.modelo;

public class modeloEstadoPartidaBD {
    private int id;
    private Integer idBatalla;
    private int heroeId;
    private int villanoId;
    private int vidaHeroe;
    private int vidaVillano;
    private int bendicionHeroe;
    private int bendicionVillano;
    private int ataqueHeroe;
    private int defensaHeroe;
    private int ataqueVillano;
    private int defensaVillano;
    private int turnoActual;
    private boolean finalizada;
    
    public modeloEstadoPartidaBD() {}
    

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Integer getIdBatalla() { return idBatalla; }
    public void setIdBatalla(Integer idBatalla) { this.idBatalla = idBatalla; }
    public int getHeroeId() { return heroeId; }
    public void setHeroeId(int heroeId) { this.heroeId = heroeId; }
    public int getVillanoId() { return villanoId; }
    public void setVillanoId(int villanoId) { this.villanoId = villanoId; }
    public int getVidaHeroe() { return vidaHeroe; }
    public void setVidaHeroe(int vidaHeroe) { this.vidaHeroe = vidaHeroe; }
    public int getVidaVillano() { return vidaVillano; }
    public void setVidaVillano(int vidaVillano) { this.vidaVillano = vidaVillano; }
    public int getBendicionHeroe() { return bendicionHeroe; }
    public void setBendicionHeroe(int bendicionHeroe) { this.bendicionHeroe = bendicionHeroe; }
    public int getBendicionVillano() { return bendicionVillano; }
    public void setBendicionVillano(int bendicionVillano) { this.bendicionVillano = bendicionVillano; }
    public int getAtaqueHeroe() { return ataqueHeroe; }
    public void setAtaqueHeroe(int ataqueHeroe) { this.ataqueHeroe = ataqueHeroe; }
    public int getDefensaHeroe() { return defensaHeroe; }
    public void setDefensaHeroe(int defensaHeroe) { this.defensaHeroe = defensaHeroe; }
    public int getAtaqueVillano() { return ataqueVillano; }
    public void setAtaqueVillano(int ataqueVillano) { this.ataqueVillano = ataqueVillano; }
    public int getDefensaVillano() { return defensaVillano; }
    public void setDefensaVillano(int defensaVillano) { this.defensaVillano = defensaVillano; }
    public int getTurnoActual() { return turnoActual; }
    public void setTurnoActual(int turnoActual) { this.turnoActual = turnoActual; }
    public boolean isFinalizada() { return finalizada; }
    public void setFinalizada(boolean finalizada) { this.finalizada = finalizada; }
}
