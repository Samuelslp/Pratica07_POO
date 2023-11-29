import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        public static void main(String[] args) throws SQLException {
                // inserir dados

                String id_isbn, nm_titulo, cod_excluir, buscaTitulo;
                int id_categoria, id_editora;
                Double vl_preco, buscaValor;

                id_isbn = JOptionPane.showInputDialog("Digite ISBN");
                id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo da categoria"));
                id_editora = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo da editora"));
                nm_titulo = JOptionPane.showInputDialog("Digite titulo");
                vl_preco = Double.parseDouble(JOptionPane.showInputDialog("Digite preço do livro"));

                Inserir inserir = new Inserir(id_isbn, id_categoria, id_editora, nm_titulo, vl_preco);

                // Excluir
                cod_excluir = JOptionPane.showInputDialog("Digite o código ISBN para Excluir");
                Excluir excluir = new Excluir(cod_excluir);

        }
}