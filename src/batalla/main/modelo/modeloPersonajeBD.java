package batalla.main.modelo;

public class modeloPersonajeBD {
     private int id;
    private String nombre;
    private String apodo;
    private String tipo;  
    private int vidaFinal;
    private int ataque;
    private int defensa;
    private int victorias;
    private int derrotas;
    private int supremosUsados;
    private int armasInvocadas;
    
    public modeloPersonajeBD() {}
    
    public modeloPersonajeBD(String nombre, String apodo, String tipo, 
                            int vidaFinal, int ataque, int defensa) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.tipo = tipo;
        this.vidaFinal = vidaFinal;
        this.ataque = ataque;
        this.defensa = defensa;
        this.victorias = 0;
        this.derrotas = 0;
        this.supremosUsados = 0;
        this.armasInvocadas = 0;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApodo() { return apodo; }
    public void setApodo(String apodo) { this.apodo = apodo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getVidaFinal() { return vidaFinal; }
    public void setVidaFinal(int vidaFinal) { this.vidaFinal = vidaFinal; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }   
    public int getVictorias() { return victorias; }
    public void setVictorias(int victorias) { this.victorias = victorias; }    
    public int getDerrotas() { return derrotas; }
    public void setDerrotas(int derrotas) { this.derrotas = derrotas; }    
    public int getSupremosUsados() { return supremosUsados; }
    public void setSupremosUsados(int supremosUsados) { this.supremosUsados = supremosUsados; }  
    public int getArmasInvocadas() { return armasInvocadas; }
    public void setArmasInvocadas(int armasInvocadas) { this.armasInvocadas = armasInvocadas; }
}
