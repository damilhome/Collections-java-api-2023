package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    List<Integer> numerosInteiros;

    public OrdenacaoNumeros(){
        this.numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumero(Integer numero) {
        numerosInteiros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendente = numerosInteiros;
        Collections.sort(numerosAscendente);
        return numerosAscendente;
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDescendente = numerosInteiros;
        Collections.sort(numerosDescendente, Collections.reverseOrder());
        return numerosDescendente;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.adicionarNumero(50);
        ordenacaoNumeros.adicionarNumero(40);
        ordenacaoNumeros.adicionarNumero(60);
        ordenacaoNumeros.adicionarNumero(45);
        ordenacaoNumeros.adicionarNumero(55);

        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
