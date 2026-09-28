package fila;

public class Fila<T extends Comparable> {

    private int tail;
    private int queueIndex;
    private int tamanhoPreenchido;
    private T[] elementos;

    public Fila(int capacidade) {
        // tail - onde remover
        this.tail = 0;
        // queueIndex - onde inserir
        this.queueIndex = 0;
        this.tamanhoPreenchido = 0;
        this.elementos = (T[]) new Comparable[capacidade];
    }

    public void enfileirar(T elemento) {

        if (tamanhoPreenchido == elementos.length) {
            throw new RuntimeException("Fila cheia!!!!!!!!!!!");
        }

        elementos[queueIndex] = elemento;
        queueIndex = ++queueIndex % elementos.length;

        if (elementos[queueIndex] != null){
            queueIndex = tail % elementos.length;
        }

        tamanhoPreenchido++;
    }

    private boolean isEmpty() {
        return tamanhoPreenchido == 0;
    }

    public T desenfileirar() {

        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!!!!!!!");
        }

        T elemento = elementos[tail];

        /*for (int i = 0; i < tamanhoPreenchido - 1; i++) {
            elementos[i] = elementos[i + 1];
        }*/

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
            for (int i = 0; i < tamanhoPreenchido; i++) {
                IO.print(elementos[i] + ";");
            }
        }
    }
}
