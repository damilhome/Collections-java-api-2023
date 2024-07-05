package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinhoDeCompras;

    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinhoDeCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();

        for(Item I : carrinhoDeCompras) {
            if(I.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(I);
            }
        }

        carrinhoDeCompras.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;

        for(Item I : carrinhoDeCompras) {
            valorTotal += I.getQuantidade() * I.getPreco();
        }

        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(carrinhoDeCompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        System.out.println("O valor total deu: R$" + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.adicionarItem("Camisa", 20, 5);
        carrinhoDeCompras.adicionarItem("Camisa", 25, 8);
        carrinhoDeCompras.adicionarItem("Bermuda", 18, 5);
        carrinhoDeCompras.adicionarItem("Bermuda", 22, 8);
        carrinhoDeCompras.adicionarItem("Sandália", 12, 2);
        System.out.println("O valor total deu: R$" + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Camisa");

        carrinhoDeCompras.exibirItens();
    }
}
