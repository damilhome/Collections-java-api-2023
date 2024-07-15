package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciarAluno {
    private Set<Aluno> listaDeAlunos;

    public GerenciarAluno() {
        this.listaDeAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        listaDeAlunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno aluno = null;

        for(Aluno a : listaDeAlunos) {
            if(a.getMatricula() == matricula) {
                aluno = a;
                break;
            }
        }

        listaDeAlunos.remove(aluno);
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosOrdenados = new TreeSet<>(listaDeAlunos);
        return alunosOrdenados;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosOrdenados = new TreeSet<>(new ComparatorPorNota());
        alunosOrdenados.addAll(listaDeAlunos);
        return alunosOrdenados;
    }

    public Set<Aluno> exibirAlunos() {
        return listaDeAlunos;
    }

    public static void main(String[] args) {
        GerenciarAluno gerenciarAluno = new GerenciarAluno();
        System.out.println(gerenciarAluno.exibirAlunos());

        gerenciarAluno.adicionarAluno("Danilo", 123456, 10);
        gerenciarAluno.adicionarAluno("João", 123457, 7);
        gerenciarAluno.adicionarAluno("Marcos", 126455, 9);
        gerenciarAluno.adicionarAluno("Matheus", 213458, 8);

        System.out.println(gerenciarAluno.exibirAlunos());
        System.out.println(gerenciarAluno.exibirAlunosPorNome());
        System.out.println(gerenciarAluno.exibirAlunosPorNota());

        gerenciarAluno.removerAluno(123457);

        System.out.println(gerenciarAluno.exibirAlunos());
        System.out.println(gerenciarAluno.exibirAlunosPorNome());
        System.out.println(gerenciarAluno.exibirAlunosPorNota());
    }
}
