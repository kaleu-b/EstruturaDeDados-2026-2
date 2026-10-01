package vetor.teste;


import vetor.Produto;
import vetor.Vetor;

public class ex8 {

    void main(){
        Vetor<Produto> estoque = new Vetor<>(10);
        estoque.inserir(new Produto(1, "teclado", 10));
        estoque.imprimir();
    }


}



