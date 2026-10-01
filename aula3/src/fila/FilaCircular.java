package fila;

public class FilaCircular<T extends Comparable> {

    private int fim;
    private int inicio;
    private int tamanho;

    private T[] elementos;

    public FilaCircular(int capacidade){
        elementos = (T[]) new Comparable[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public void enfileirar(T elemento){
        if (tamanho == elementos.length){throw new RuntimeException("Cheio!!!");}

        fim = ++fim % elementos.length;
        elementos[fim] = elemento;
        tamanho++;
    }

    public T desenfileirar(){
        if (isEmpty()){throw new RuntimeException("Fila vazia!!!");}

        T elemento = elementos[inicio];
        elementos[inicio] = null;
        inicio = ++inicio % elementos.length;
        tamanho--;
        return elemento;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public void imprimir(){
        IO.println("Fila: ");
        for (int i = 0; i< tamanho; i++){
            int indice = (inicio+i) % elementos.length;
            IO.print(elementos[indice] + ";");
        }
        IO.println();
    }

}