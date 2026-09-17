package atividade.pilha;

public class Pilha<T extends Comparable> {

    private T[] elementos;
    private int topo;
    private int fundo;

    public Pilha(int capacidade) {
        this.elementos = (T[]) new Comparable[capacidade];
        this.topo = -1; // vazio
    }

    public void push(T elemento){
        elementos[++topo] = elemento;
    }

    public T pop(){

        if (isEmpty()){
            throw new RuntimeException("Pilha vazia");
        }

        T elemento = elementos[topo];
        elementos[topo--] = null;
        return elemento;

    }

    public boolean isEmpty(){
        return topo == -1;
    }
}