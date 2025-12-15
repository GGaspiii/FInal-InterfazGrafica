package batalla.main.dao;
import batalla.main.conexion.ConexionDB;
import batalla.main.modelo.modeloBatallaBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOBatalla {
    public int guardar(modeloBatallaBD batalla) {
        String sql = "INSERT INTO batallas (heroe_id, villano_id, ganador_id, turnos) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, batalla.getHeroeId());
            stmt.setInt(2, batalla.getVillanoId());
            
            if (batalla.getGanadorId() == null) {
                stmt.setNull(3, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(3, batalla.getGanadorId());
            }
            
            stmt.setInt(4, batalla.getTurnos());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                batalla.setId(id);
                return id;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }
    public boolean actualizarResultado(modeloBatallaBD batalla) {
        String sql = "UPDATE batallas SET ganador_id = ?, turnos = ? WHERE id_batalla = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            if (batalla.getGanadorId() == null) {
                stmt.setNull(1, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(1, batalla.getGanadorId());
            }
            
            stmt.setInt(2, batalla.getTurnos());
            stmt.setInt(3, batalla.getId());
            
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    public List<modeloBatallaBD> listarHistorial(int cantidad) {
        List<modeloBatallaBD> lista = new ArrayList<>();
        String sql = "SELECT * FROM batallas ORDER BY fecha DESC LIMIT ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, cantidad);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                lista.add(mapearBatalla(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    public modeloBatallaBD buscarPorId(int idBatalla) {
        String sql = "SELECT * FROM batallas WHERE id_batalla = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBatalla);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearBatalla(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    private modeloBatallaBD mapearBatalla(ResultSet rs) throws SQLException {
        modeloBatallaBD batalla = new modeloBatallaBD();
        batalla.setId(rs.getInt("id_batalla"));
        batalla.setHeroeId(rs.getInt("heroe_id"));
        batalla.setVillanoId(rs.getInt("villano_id"));
        
        int ganadorId = rs.getInt("ganador_id");
        batalla.setGanadorId(rs.wasNull() ? null : ganadorId);
        batalla.setTurnos(rs.getInt("turnos"));
        return batalla;
    }
}
