package pilha.teste;

import pilha.Pilha;

public class Teste0 {

    static void main(){
        Pilha<Integer> pilha = new Pilha<>(10);

        // verificando se esta vazia

        IO.println("Esta vazia: " + (pilha.isEmpty() ? "Sim":"Não") );

        // inserindo dados

        pilha.push(10);
        pilha.push(11);
        pilha.push(12);

        // removendo dados

        pilha.pop();
        int valor = pilha.pop();
        IO.println("Segundo valor desempilhado: " + valor);
        pilha.pop();
        pilha.pop();
    }

}
