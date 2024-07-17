package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> palavraDefinicao;

    public Dicionario() {
        this.palavraDefinicao = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        palavraDefinicao.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if(!palavraDefinicao.isEmpty()) {
            palavraDefinicao.remove(palavra);
        }
    }

    public void exibirPalavras() {
        System.out.println(palavraDefinicao);
    }

    public String pesquisarPorPalavra(String palavra) {
        if(!palavraDefinicao.isEmpty()) {
            return palavraDefinicao.get(palavra);
        }

        return null;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Perseverança", "A qualidade de persistir.");
        dicionario.adicionarPalavra("Perseverança", "A qualidade de persistir em uma tarefa ou objetivo, apesar das dificuldades ou obstáculos.");
        dicionario.adicionarPalavra("Imprescindível", "Indispensável, algo que não pode ser dispensado.");
        dicionario.adicionarPalavra("Empatia", "A capacidade de compreender e compartilhar os sentimentos de outra pessoa.");
        dicionario.adicionarPalavra("Inerente", "Inato, algo que faz parte da natureza essencial de algo ou alguém.");
        dicionario.adicionarPalavra("Respeito", "Consideração, estima ou deferência por outra pessoa ou coisa.");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Inerente");

        dicionario.exibirPalavras();

        System.out.println("O significado de Empatia é: " + dicionario.pesquisarPorPalavra("Empatia"));
    }
}
