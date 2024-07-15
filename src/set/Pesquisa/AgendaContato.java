package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {
    private Set<Contato> contatoSet;

    public AgendaContato() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibitContato() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();

        for(Contato c : contatoSet) {
            if(c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;

        for(Contato c : contatoSet) {
            if(c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();

        agendaContato.exibitContato();

        agendaContato.adicionarContato("Danilo", 123456);
        agendaContato.adicionarContato("Danilo", 0);
        agendaContato.adicionarContato("Danilo Almeida", 111111);
        agendaContato.adicionarContato("Danilo Milhome", 654987);
        agendaContato.adicionarContato("Camila Cavalcante", 111111);

        agendaContato.exibitContato();

        System.out.println(agendaContato.pesquisarPorNome("Danilo"));

        System.out.println("Contato atualizado: " + agendaContato.atualizarNumeroContato("Camila Cavalcante", 555555));

        System.out.println(agendaContato.pesquisarPorNome("Camila"));
    }
}
