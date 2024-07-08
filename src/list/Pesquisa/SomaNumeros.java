package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numerosInteiros;

    public SomaNumeros() {
        numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numerosInteiros.add(numero);
    }

    @Override
    public String toString() {
        return "SomaNumeros{" +
                "numerosInteiros=" + numerosInteiros +
                '}';
    }

    public void calcularSoma() {
        Integer soma = null;

        if(!numerosInteiros.isEmpty()) {
            soma = 0;
            for(Integer i : numerosInteiros) {
                soma += i;
            }
        }

        System.out.println(soma);
    }

    public void encontrarMaiorNumero() {
        Integer numero = null;

        if(!numerosInteiros.isEmpty()) {
            numero = 0;
            for(Integer i : numerosInteiros) {
                if(i > numero) {
                    numero = i;
                }
            }
        }

        System.out.println(numero);
    }

    public void encontrarMenorNumero() {
        Integer numero = null;

        if(!numerosInteiros.isEmpty()) {
            numero = numerosInteiros.get(0);
            for(Integer i : numerosInteiros) {
                if(numero > i) {
                    numero = i;
                }
            }
        }

        System.out.println(numero);
    }

    public void exibirNumeros() {
        System.out.println(numerosInteiros);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(7);
        somaNumeros.adicionarNumero(11);

        somaNumeros.calcularSoma();
        somaNumeros.encontrarMaiorNumero();
        somaNumeros.encontrarMenorNumero();
        somaNumeros.exibirNumeros();
    }
}
