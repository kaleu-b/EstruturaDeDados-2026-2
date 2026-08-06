package Vetor.Teste;

import Vetor.VetorEstatico;

public class ex2 {


    void main(){
        VetorEstatico vetorEstatico = new VetorEstatico(10);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("boom");
        vetorEstatico.inserir(3, "teste");
        vetorEstatico.imprimir();
    }
}
