package Vetor.Teste;

import Vetor.VetorLista;

public class ex5 {
    void main() {
        VetorLista vetorNomes = new VetorLista();

        vetorNomes.inserir("Joao");
        vetorNomes.inserir("Ana");
        vetorNomes.inserir("Ana");
        vetorNomes.inserir("Pedro");
        vetorNomes.inserir("gael");

        vetorNomes.imprimir();
    }
}
