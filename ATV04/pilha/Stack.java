package atividade.pilha;

import atividade.vetor.Vetor;
//import vetor;

public class Stack<T extends Comparable<T>> {

    private Vetor<T> elementos;

    public Stack(int capacidade){
        elementos = new Vetor<>(capacidade);
    }

    public void push(T elemento){
        elementos.inserir(elemento);
    }

    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("Pilha vazia");
        }
        T valor = elementos.get(elementos.obterTamanho() - 1);
        elementos.remover(elementos.obterTamanho() - 1);
        return valor;
    }

    public boolean isEmpty(){
        return elementos.obterTamanho() == 0;
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Pilha Vazia");
        }
        return elementos.get(elementos.obterTamanho()-1);
    }

    public int tamanho(){
        return elementos.obterTamanho();
    }

}