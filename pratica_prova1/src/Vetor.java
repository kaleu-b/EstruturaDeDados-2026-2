public class Vetor<T extends Comparable> {

    private int tamanhoPreenchido;
    private T[] elementos;

    public Vetor(int qtde){
        elementos = new ((T[]) Comparable[qtde]);
    }


}
