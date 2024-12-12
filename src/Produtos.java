import java.io.Serial;
import java.io.Serializable;

class Produtos implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int quantidade;
    private String nome;
    private String codigo;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void infoProduto(){
        System.out.println("Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: " + preco);
    }
}