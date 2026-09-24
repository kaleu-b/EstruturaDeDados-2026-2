package fila;

public class Fila<T extends Comparable> {

    private int tail;
    private int tamanho;
    private T[] elementos;

    public Fila(int capacidade) {
        this.tail = 0;
        this.tamanho = 0;
        this.elementos = (T[]) new Comparable[capacidade];
    }

    public void enfileirar(T elemento){

        if (tamanho == elementos.length){
            throw new RuntimeException("Fila cheia!!!!!!!!!!!");
        }

        elementos[tamanho] = elemento;
        tamanho++;
    }

    private boolean isEmpty(){return tamanho == 0;}

    public T desenfileirar(){

        if (isEmpty()){
            throw new RuntimeException("Fila vazia!!!!!!!");
        }

        T elemento = elementos[0];

        for (int i = 0; i < tamanho-1; i++) {
            elementos[i] = elementos[i+1];
        }

        elementos[tamanho-1] = null;
        tamanho--;

        return elemento;
    }

    public T frente(){
        if (isEmpty()){
            throw new RuntimeException("Fila vazia!!!!!!!");
        }
        return elementos[0];
    }

    public void imprimir(){
        if (isEmpty()){
            IO.println("Fila vazia.");
        }else {
            for (int i=0; i<tamanho; i++){
                IO.print(elementos[i] + ";");
            }
        }
    }
}
