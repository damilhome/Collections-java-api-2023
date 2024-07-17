package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> mapaLivraria;

    public LivrariaOnline() {
        this.mapaLivraria = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        Livro livro = new Livro(titulo, autor, preco);
        mapaLivraria.put(link, livro);
    }

    public void removerLivro(String titulo) {
        String livroParaRemover;

        if(!mapaLivraria.isEmpty()) {
            for(Map.Entry<String, Livro> l : mapaLivraria.entrySet()) {
                if(l.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livroParaRemover = l.getKey();
                    mapaLivraria.remove(livroParaRemover);
                    break;
                }
            }
        }
    }

    public Map<String,Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String,Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(mapaLivraria.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String,Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(mapaLivraria.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String,Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for(Map.Entry<String,Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Livro obterLivroMaisCaro(){
        double produtoMaisCaro = Double.MIN_VALUE;
        Livro livro = null;

        if(!mapaLivraria.isEmpty()) {
            for(Map.Entry<String,Livro> entry : mapaLivraria.entrySet()) {
                if(entry.getValue().getPreco() > produtoMaisCaro) {
                    produtoMaisCaro = entry.getValue().getPreco();
                    livro = entry.getValue();
                }
            }
        }

        return livro;
    }

    public Livro obterLivroMaisBarato(){
        double produtoMaisBarato = Double.MAX_VALUE;
        Livro livro = null;

        if(!mapaLivraria.isEmpty()) {
            for(Map.Entry<String,Livro> entry : mapaLivraria.entrySet()) {
                if(entry.getValue().getPreco() < produtoMaisBarato) {
                    produtoMaisBarato = entry.getValue().getPreco();
                    livro = entry.getValue();
                }
            }
        }

        return livro;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Harry-Potter-Premium-Vermelho-Livros/dp/6555321806", "Box Harry Potter", "J.K Rolling", 336.36);
        livrariaOnline.adicionarLivro("https://www.mercadolivre.com.br/box-percy-jackson-e-os-olimpianos-nova-edico-de-rick-riordan-editora-intrinseca-capa-mole-edico-1-em-portugus-2024/p/MLB30861126", "Box Percy Jackson e os olimpianos", "Rick Riordan", 259.15);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Os-Her%C3%B3is-do-Olimpo-Box/dp/8580579503", "Os Heróis do Olimpo - Box", "Rick Riordan", 202.90);
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Box-Trilogia-Senhor-dos-An%C3%A9is/dp/8595086354", "Box Senhor dos Anéis", "J.R.R. Tolkien", 99.99);

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorAutor());

        livrariaOnline.removerLivro("Box Senhor dos Anéis");

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorAutor());

        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.obterLivroMaisBarato());
    }
}
