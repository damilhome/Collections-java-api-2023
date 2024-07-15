package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {
        palavrasUnicas.remove(palavra);
    }

    public void verificarPalavra(String palavra) {
        int testar = 0;

        for(String p : palavrasUnicas) {
            if(p.equals(palavra)) {
                System.out.println(p);
                testar++;
                break;
            }
        }

        if(testar == 1) {
            System.out.println("nada");
        }
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Danilo");
        conjuntoPalavrasUnicas.adicionarPalavra("João");
        conjuntoPalavrasUnicas.adicionarPalavra("João");
        conjuntoPalavrasUnicas.adicionarPalavra("Matheus");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.verificarPalavra("Matheus");
        conjuntoPalavrasUnicas.verificarPalavra("José");

        conjuntoPalavrasUnicas.removerPalavra("Matheus");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}
