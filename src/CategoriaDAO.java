import java.sql.*;
import java.util.*;

public class CategoriaDAO {
    public void inserir(Categoria p) {
        String sql =  "INSERT INTO categorias (nome, ativo) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setBoolean(2, p.isAtivo());
            stmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria p = new Categoria(rs.getString("nome"), rs.getBoolean("ativo"));
                p.setId(rs.getInt("id"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Categoria p) {
        String sql = "UPDATE categorias SET nome=?, ativo=? WHERE id=?";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, p.getNome());
            stmt.setBoolean(2, p.isAtivo());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
            System.out.println("Categoria atualizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM categorias WHERE id=?";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Categoria deletada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
