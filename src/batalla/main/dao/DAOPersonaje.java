package batalla.main.dao;
import batalla.main.conexion.ConexionDB;
import batalla.main.modelo.modeloPersonajeBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaje {
    
    public int guardar(modeloPersonajeBD personaje) {
        String sql = "INSERT INTO personajes (nombre, apodo, tipo, vida_final, ataque, defensa, " +
                     "victorias, derrotas, supremos_usados, armas_invocadas) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, personaje.getNombre());
            stmt.setString(2, personaje.getApodo());
            stmt.setString(3, personaje.getTipo());
            stmt.setInt(4, personaje.getVidaFinal());
            stmt.setInt(5, personaje.getAtaque());
            stmt.setInt(6, personaje.getDefensa());
            stmt.setInt(7, personaje.getVictorias());
            stmt.setInt(8, personaje.getDerrotas());
            stmt.setInt(9, personaje.getSupremosUsados());
            stmt.setInt(10, personaje.getArmasInvocadas());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                personaje.setId(id);
                return id;
            }
        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }
    
    public modeloPersonajeBD buscarPorId(int idPersonaje) {
        String sql = "SELECT * FROM personajes WHERE id_personaje = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPersonaje);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearPersonaje(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public modeloPersonajeBD buscarPorApodo(String apodo) {
        String sql = "SELECT * FROM personajes WHERE apodo = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, apodo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearPersonaje(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    private modeloPersonajeBD mapearPersonaje(ResultSet rs) throws SQLException {
        modeloPersonajeBD personaje = new modeloPersonajeBD();
        personaje.setId(rs.getInt("id_personaje"));
        personaje.setNombre(rs.getString("nombre"));
        personaje.setApodo(rs.getString("apodo"));
        personaje.setTipo(rs.getString("tipo"));
        personaje.setVidaFinal(rs.getInt("vida_final"));
        personaje.setAtaque(rs.getInt("ataque"));
        personaje.setDefensa(rs.getInt("defensa"));
        personaje.setVictorias(rs.getInt("victorias"));
        personaje.setDerrotas(rs.getInt("derrotas"));
        personaje.setSupremosUsados(rs.getInt("supremos_usados"));
        personaje.setArmasInvocadas(rs.getInt("armas_invocadas"));
        return personaje;
    }
    
    public List<modeloPersonajeBD> listarRanking() {
        List<modeloPersonajeBD> lista = new ArrayList<>();
        String sql = "SELECT * FROM personajes ORDER BY victorias DESC, supremos_usados DESC";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                lista.add(mapearPersonaje(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
    
    public void actualizarEstadisticas(modeloPersonajeBD personaje) {
        String sql = "UPDATE personajes SET vida_final = ?, ataque = ?, defensa = ?, " +
                     "victorias = ?, derrotas = ?, supremos_usados = ?, armas_invocadas = ? " +
                     "WHERE id_personaje = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, personaje.getVidaFinal());
            stmt.setInt(2, personaje.getAtaque());
            stmt.setInt(3, personaje.getDefensa());
            stmt.setInt(4, personaje.getVictorias());
            stmt.setInt(5, personaje.getDerrotas());
            stmt.setInt(6, personaje.getSupremosUsados());
            stmt.setInt(7, personaje.getArmasInvocadas());
            stmt.setInt(8, personaje.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }
}
