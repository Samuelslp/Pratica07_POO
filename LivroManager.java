import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LivroManager {

    private Connection connection;

    public LivroManager() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/seubanco", "seuusuario", "suasenha");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirLivro(String isbn, String titulo, double preco) {
        String sql = "INSERT INTO livro (id_isbn, nm_titulo, vl_preco) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, isbn);
            statement.setString(2, titulo);
            statement.setDouble(3, preco);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirLivro(String isbn) {
        String sql = "DELETE FROM livro WHERE id_isbn = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, isbn);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pesquisarLivroPorTitulo(String parteTitulo) {
        String sql = "SELECT * FROM livro WHERE nm_titulo LIKE ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, parteTitulo + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String isbn = resultSet.getString("id_isbn");
                String titulo = resultSet.getString("nm_titulo");
                double preco = resultSet.getDouble("vl_preco");
                System.out.println("ISBN: " + isbn + ", Título: " + titulo + ", Preço: " + preco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pesquisarLivroPorPreco(double precoMinimo) {
        String sql = "SELECT * FROM livro WHERE vl_preco >= ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, precoMinimo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String isbn = resultSet.getString("id_isbn");
                String titulo = resultSet.getString("nm_titulo");
                double preco = resultSet.getDouble("vl_preco");
                System.out.println("ISBN: " + isbn + ", Título: " + titulo + ", Preço: " + preco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}