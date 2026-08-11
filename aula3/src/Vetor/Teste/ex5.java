package Vetor.Teste;

import Vetor.VetorDinamico;

public class ex5 {

    void main(){
        VetorDinamico vetor = new VetorDinamico(4);

        vetor.inserir("A");
        vetor.inserir("A");
        vetor.inserir("A");

        vetor.imprimir();

        vetor.remover(0);
        vetor.remover(0);
        vetor.imprimir();
    }

}
