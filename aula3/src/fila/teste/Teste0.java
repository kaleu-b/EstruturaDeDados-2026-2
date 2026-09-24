package fila.teste;

import fila.Fila;

public class Teste0 {

    static void main() {
        Fila<String> fila = new Fila<>(10);

        fila.enfileirar("A");
        fila.enfileirar("B");
        fila.enfileirar("C");
        fila.enfileirar("D");
        fila.enfileirar("E");
        fila.enfileirar("F");
        fila.enfileirar("G");
        fila.enfileirar("H");
        fila.enfileirar("I");
        fila.enfileirar("J");

        fila.imprimir();

        fila.desenfileirar();
        fila.desenfileirar();
        fila.imprimir();
    }
}
