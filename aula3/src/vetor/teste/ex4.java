package vetor.teste;

import vetor.VetorDinamico;

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
