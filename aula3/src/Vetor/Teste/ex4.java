package Vetor.Teste;

import Vetor.VetorDinamico;

public class ex4 {

    public VetorDinamico vetor = new VetorDinamico(2);

    void main(){
        vetor.inserir("A");
        vetor.imprimir();
        vetor.inserir("B");
        vetor.imprimir();

        vetor.inserir("A");
        vetor.imprimir();
        vetor.inserir("B");
        vetor.imprimir();
        vetor.inserir("C");
        vetor.imprimir();
    }


}
