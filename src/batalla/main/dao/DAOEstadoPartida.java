package batalla.main.dao;
import batalla.main.conexion.ConexionDB;
import batalla.main.modelo.modeloEstadoPartidaBD;
import java.sql.*;

public class DAOEstadoPartida {
   public int guardar(modeloEstadoPartidaBD estado) {
        String sql = "INSERT INTO estado_partida (" +
                     "id_batalla, heroe_id, villano_id, " +
                     "vida_heroe, vida_villano, " +
                     "bendicion_heroe, bendicion_villano, " +
                     "ataque_heroe, defensa_heroe, " +
                     "ataque_villano, defensa_villano, " +
                     "turno_actual, finalizada" +
                     ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            if (estado.getIdBatalla() == null) {
                stmt.setNull(1, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(1, estado.getIdBatalla());
            }
            
            stmt.setInt(2, estado.getHeroeId());
            stmt.setInt(3, estado.getVillanoId());
            stmt.setInt(4, estado.getVidaHeroe());
            stmt.setInt(5, estado.getVidaVillano());
            stmt.setInt(6, estado.getBendicionHeroe());
            stmt.setInt(7, estado.getBendicionVillano());
            stmt.setInt(8, estado.getAtaqueHeroe());
            stmt.setInt(9, estado.getDefensaHeroe());
            stmt.setInt(10, estado.getAtaqueVillano());
            stmt.setInt(11, estado.getDefensaVillano());
            stmt.setInt(12, estado.getTurnoActual());
            stmt.setBoolean(13, estado.isFinalizada());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                estado.setId(id);
                return id;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }
    
    public boolean actualizar(modeloEstadoPartidaBD estado) {
        String sql = "UPDATE estado_partida SET " +
                     "vida_heroe = ?, vida_villano = ?, " +
                     "bendicion_heroe = ?, bendicion_villano = ?, " +
                     "ataque_heroe = ?, defensa_heroe = ?, " +
                     "ataque_villano = ?, defensa_villano = ?, " +
                     "turno_actual = ?, finalizada = ? " +
                     "WHERE id_estado = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, estado.getVidaHeroe());
            stmt.setInt(2, estado.getVidaVillano());
            stmt.setInt(3, estado.getBendicionHeroe());
            stmt.setInt(4, estado.getBendicionVillano());
            stmt.setInt(5, estado.getAtaqueHeroe());
            stmt.setInt(6, estado.getDefensaHeroe());
            stmt.setInt(7, estado.getAtaqueVillano());
            stmt.setInt(8, estado.getDefensaVillano());
            stmt.setInt(9, estado.getTurnoActual());
            stmt.setBoolean(10, estado.isFinalizada());
            stmt.setInt(11, estado.getId());
            
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    public modeloEstadoPartidaBD cargarUltima() {
        String sql = "SELECT * FROM estado_partida ORDER BY fecha_guardado DESC LIMIT 1";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return mapearEstado(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public modeloEstadoPartidaBD cargarPorBatalla(int idBatalla) {
        String sql = "SELECT * FROM estado_partida WHERE id_batalla = ? ORDER BY fecha_guardado DESC LIMIT 1";
        
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBatalla);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearEstado(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    private modeloEstadoPartidaBD mapearEstado(ResultSet rs) throws SQLException {
        modeloEstadoPartidaBD estado = new modeloEstadoPartidaBD();
        estado.setId(rs.getInt("id_estado"));
        
        int idBatalla = rs.getInt("id_batalla");
        estado.setIdBatalla(rs.wasNull() ? null : idBatalla);
        
        estado.setHeroeId(rs.getInt("heroe_id"));
        estado.setVillanoId(rs.getInt("villano_id"));
        estado.setVidaHeroe(rs.getInt("vida_heroe"));
        estado.setVidaVillano(rs.getInt("vida_villano"));
        estado.setBendicionHeroe(rs.getInt("bendicion_heroe"));
        estado.setBendicionVillano(rs.getInt("bendicion_villano"));
        estado.setAtaqueHeroe(rs.getInt("ataque_heroe"));
        estado.setDefensaHeroe(rs.getInt("defensa_heroe"));
        estado.setAtaqueVillano(rs.getInt("ataque_villano"));
        estado.setDefensaVillano(rs.getInt("defensa_villano"));
        estado.setTurnoActual(rs.getInt("turno_actual"));
        estado.setFinalizada(rs.getBoolean("finalizada"));
        return estado;
    } 
}
