import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class ProdutoDAO {
    @SuppressWarnings("CallPrintStackTrace")
    public void inserir(Produto p) {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, p.getNome());
                stmt.setDouble(2, p.getPreco());
                stmt.executeUpdate();
                System.out.println("Produto inserido com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try(Connection conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            

            while (rs.next()) {
                Produto p = new Produto(rs.getString("nome"),
                                                    rs.getDouble("preco"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void atualizar(Produto p) {
        String sql = "UPDATE produtos SET nome=?, preco=? WHEREid=?";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void deletar(int id) {
        String sql = "DELETE FROM produtos WHERE id=?";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto deletado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
