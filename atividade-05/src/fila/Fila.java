package fila;

public class Fila<T extends Comparable> {

    private int tail;
    private int queueIndex;
    private int tamanhoPreenchido;
    private T[] elementos;

    public Fila(int capacidade) {
        // tail - ponteiro que indica onde remover
        this.tail = 0;
        // queueIndex - ponteiro que indica onde inserir
        this.queueIndex = 0;
        this.tamanhoPreenchido = 0;
        this.elementos = (T[]) new Comparable[capacidade];
    }

    public boolean isFull(){
        return tamanhoPreenchido >= elementos.length;
    }

    public boolean isEmpty() {
        return tamanhoPreenchido == 0;
    }

    public void enfileirar(T elemento) {

        if (isFull()) {
            throw new RuntimeException("Fila cheia!!!!!!!!!!!");
        }

        if (isEmpty()){
            queueIndex = 0;
            tail = 0;
        }

        elementos[queueIndex] = elemento;
        queueIndex = ++queueIndex % elementos.length;

        tamanhoPreenchido++;
    }

    public T desenfileirar() {

        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!!!!!!!");
        }

        T elemento = elementos[tail];

        elementos[tail] = null;
        tail = ++tail % elementos.length;
        tamanhoPreenchido--;

        return elemento;
    }

    public T frente() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!!!!!!!");
        }
        return elementos[tail];
    }

    public void imprimir() {
        if (isEmpty()) {
            IO.println("Fila vazia.");
        } else {
            IO.println("Fila: ");
            for (T elemento : elementos) {
                IO.print(elemento + ";");
            }
        }
    }
}
