package vetor.teste;

import vetor.VetorEstatico;

public class ex3 {

    public void main(){
        VetorEstatico vetorEstatico = new VetorEstatico(10);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("boom");
        vetorEstatico.inserir(3, "teste");
        vetorEstatico.imprimir();

        vetorEstatico.remover(0);

        vetorEstatico.imprimir();

        vetorEstatico.inserir(0, "R");

        vetorEstatico.imprimir();
    }

}
