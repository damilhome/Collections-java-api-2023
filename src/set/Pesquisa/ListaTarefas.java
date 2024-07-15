package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefasSet;

    public ListaTarefas(){
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefasSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefasParaRemover = null;

        for(Tarefa c : tarefasSet) {
            if(c.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover = c;
                break;
            }
        }

        tarefasSet.remove(tarefasParaRemover);
    }

    public void exibirTarefas() {
        System.out.println(tarefasSet);
    }

    public void contarTarefas() {
        int numeroDeTarefas = 0;

        for(Tarefa c : tarefasSet) {
            numeroDeTarefas++;
        }

        System.out.println(numeroDeTarefas);
    }

    public void obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for(Tarefa c : tarefasSet) {
            if(c.getConcluido()) {
                tarefasConcluidas.add(c);
            }
        }

        System.out.println(tarefasConcluidas);
    }

    public void obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for(Tarefa c : tarefasSet) {
            if(!c.getConcluido()){
                tarefasPendentes.add(c);
            }
        }

        System.out.println(tarefasPendentes);
    }

    public Tarefa marcarTarefaConcluida(String descricao) {
        Tarefa tarefaConcluida = null;

        for(Tarefa c : tarefasSet) {
            if(c.getDescricao().equalsIgnoreCase(descricao)){
                c.setConcluido(true);
                tarefaConcluida = c;
                break;
            }
        }

        return tarefaConcluida;
    }

    public Tarefa marcarTarefaPendente(String descricao) {
        Tarefa tarefaPendente = null;

        for(Tarefa c : tarefasSet) {
            if(c.getDescricao().equalsIgnoreCase(descricao)) {
                c.setConcluido(false);
                tarefaPendente = c;
                break;
            }
        }

        return tarefaPendente;
    }

    public void limparListaTarefa() {
        tarefasSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();

        listaTarefas.adicionarTarefa("descrição 1");
        listaTarefas.adicionarTarefa("descrição 2");
        listaTarefas.adicionarTarefa("descrição 3");
        listaTarefas.adicionarTarefa("descrição 4");
        listaTarefas.adicionarTarefa("descrição 5");

        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();

        listaTarefas.removerTarefa("descrição 3");

        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();
        listaTarefas.obterTarefasConcluidas();
        listaTarefas.obterTarefasPendentes();

        listaTarefas.marcarTarefaConcluida("descrição 1");
        listaTarefas.marcarTarefaConcluida("descrição 2");
        listaTarefas.marcarTarefaConcluida("descrição 5");

        listaTarefas.obterTarefasConcluidas();
        listaTarefas.obterTarefasPendentes();

        listaTarefas.marcarTarefaPendente("descrição 1");

        listaTarefas.obterTarefasConcluidas();
        listaTarefas.obterTarefasPendentes();

        listaTarefas.limparListaTarefa();

        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();
    }
}
