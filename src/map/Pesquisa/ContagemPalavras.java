package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavras;

    public ContagemPalavras() {
        this.contagemPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String nome, Integer contagem) {
        contagemPalavras.put(nome, contagem);
    }

    public void removerPalavra(String palavra) {
        contagemPalavras.remove(palavra);
    }

    public void exibirContagemPalavras() {
        System.out.println(contagemPalavras);
    }

    public Integer encontrarPalavraMaisFrequente() {
        Integer palavraMaisFrequente = Integer.MIN_VALUE;

        if(!contagemPalavras.isEmpty()) {
            for(Integer i : contagemPalavras.values()) {
                if(i > palavraMaisFrequente) {
                    palavraMaisFrequente = i;
                }
            }
        }

        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.adicionarPalavra("Palavra", 10);
        contagemPalavras.adicionarPalavra("Senha", 15);
        contagemPalavras.adicionarPalavra("Download", 8);
        contagemPalavras.adicionarPalavra("Livro", 50);
        contagemPalavras.adicionarPalavra("Brasil", 25);

        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.removerPalavra("Download");

        contagemPalavras.exibirContagemPalavras();

        System.out.println("Palavra mais frequente: " + contagemPalavras.encontrarPalavraMaisFrequente() + " vezes");
    }
}
