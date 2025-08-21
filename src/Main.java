import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;
        CategoriaDAO cdao = new CategoriaDAO();

        do {
            System.out.println("| 1 - Inserir ID do Produto\n | 2 - Listar ID Produto\n | 3 - Atualizar ID Produto\n | 4 - Deletar\n| 5 - Deletar ID da categoria\n| 6 - ID da categoria\n| 7 - Sua ID Está ativa?\n | 0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    Produto p = new Produto(nome, preco);
                    dao.inserir(p);
                    break;

                case 2:
                    for (Produto prod : dao.listar()) {
                        System.out.println(
                            prod.getId() + " - " +
                            prod.getNome() + " - R$" +
                            prod.getPreco());
                    }
                    break;

                case 3:
                    System.out.print("ID do produto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    preco = sc.nextDouble();
                    p = new Produto(nome, preco);
                    p.setId(id);
                    dao.atualizar(p);
                    break;

                case 4:
                    System.out.print("ID do produto a deletar: ");
                    id = sc.nextInt();
                    dao.deletar(id);
                    break;

                case 5:
                    System.out.print("ID da categoria a deletar: ");
                    id = sc.nextInt();
                    dao.deletar(id);
                    break;

                    case 6:
                    System.out.print("ID do categoria: ");
                    int idCategoria = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    preco = sc.nextDouble();
                    p = new Produto(nome, preco);
                    p.setId(idCategoria);
                    dao.atualizar(p);
                    break;

                    case 7:
                    System.out.println("Nome da categoria");
                    String nomeCat =sc.nextLine();
                    System.out.println("Ativa? (true/false): ");
                    boolean ativa = sc.nextBoolean();
                    Categoria cat = new Categoria(nomeCat, ativa);
                    cdao.inserir(cat);
                    break;

                    case 8: 
                        System.out.println("ID da categoria a deletar: ");
                        int idDelete = sc.nextInt();
                        cdao.deletar(idDelete);
                        break;


                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!!!!!!!!!!!!!!!!!!!!");
            }
        } while (opcao != 0);

        sc.close();
        System.out.println("Programa finalizado!!!!!");
    }
}
