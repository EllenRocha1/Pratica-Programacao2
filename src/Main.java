import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String Produtos_file = "produtos.dat";

        List <Produtos> listaDeProdutos = new ArrayList<>();

        int opcao = 0;
        sc.nextLine();

        while (opcao != 3){
            System.out.println("-----Menu----");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2- Buscar Produto");
            System.out.println("3- Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1){
                Produtos produto = new Produtos();
                System.out.println("Digite o nome do produto:");
                String nome = sc.nextLine();
                produto.setNome(nome);

                System.out.println("Digite codigo:");
                String codigo = sc.nextLine();
                produto.setCodigo(codigo);

                System.out.println("Digite quantidade:");
                int quantidade = sc.nextInt();
                produto.setQuantidade(quantidade);

                System.out.println("Digite preço:");
                double preco = sc.nextDouble();
                produto.setPreco(preco);

                listaDeProdutos.add(produto);
                System.out.println("Produto cadastrado com sucesso!\n");

            }else if (opcao == 2){
                System.out.println("Digite código do produto:");
                String codigoP = sc.nextLine();

                boolean encontrado = false;

                for (Produtos produto : listaDeProdutos) {
                    if (produto.getCodigo().equals(codigoP)) {
                        produto.infoProduto();
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Produto não encontrado.\n");
                }

            }else if (opcao == 3) {
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Produtos_file))) {
                    out.writeObject(listaDeProdutos);
                    System.out.println("Produtos salvos com sucesso.");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar produtos: " + e.getMessage());
                }
                System.out.println("Saindo do sistema. Até logo!");
            } else {
                System.out.println("Opção inválida! Tente novamente.\n");
            }

        }
        sc.close();
    }
}
