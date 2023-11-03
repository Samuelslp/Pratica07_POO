import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main{
public static void main(String[] args) {
        LivroManager manager = new LivroManager();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
        System.out.println("Escolha uma opção:");
        System.out.println("<1> Cadastrar Livro");
        System.out.println("<2> Pesquisar Livro por Preço");
        System.out.println("<3> Pesquisar Livro por Título");
        System.out.println("<4> Excluir Livro");
        System.out.println("<5> Sair");

        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
        case 1:
        System.out.print("ISBN do Livro: ");
        String isbn = scanner.nextLine();
        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Preço do Livro: ");
        double preco = scanner.nextDouble();
        manager.inserirLivro(isbn, titulo, preco);
        break;

        case 2:
        System.out.print("Preço Mínimo: ");
        double precoMinimo = scanner.nextDouble();
        manager.pesquisarLivroPorPreco(precoMinimo);
        break;

        case 3:
        System.out.print("Parte do Título: ");
        String parteTitulo = scanner.nextLine();
        manager.pesquisarLivroPorTitulo(parteTitulo);
        break;

        case 4:
        System.out.print("ISBN do Livro para Excluir: ");
        String isbnExcluir = scanner.nextLine();
        manager.excluirLivro(isbnExcluir);
        break;

        case 5:
        break;

default:
        System.out.println("Opção inválida.");
        }
        } while (opcao != 5);

        manager.closeConnection();
        }
}
