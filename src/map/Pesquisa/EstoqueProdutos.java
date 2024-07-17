package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos(){
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }

        return valorTotalEstoque;
    }

    public void obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        double valorTotal = Double.MIN_VALUE;
        Produto produto = null;

        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if((p.getPreco() * p.getQuantidade()) > valorTotal) {
                    valorTotal = p.getPreco() * p.getQuantidade();
                    produto = p;
                }
            }
        }

        System.out.println("Produto '" + produto.getNome() + "' com valor " + valorTotal);
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double maiorPreco = Double.MAX_VALUE;

        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() < maiorPreco) {
                    produtoMaisBarato = p;
                    maiorPreco = p.getPreco();
                }
            }
        }

        return produtoMaisBarato;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(001,"Produto A", 10.0, 5);
        estoque.adicionarProduto(002, "Produto B", 20.0, 3);
        estoque.adicionarProduto(003,"Produto C", 15.0, 10);
        estoque.adicionarProduto(003,"Produto D", 11.0, 7);

        estoque.exibirProdutos();

        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());

        estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
    }
}
