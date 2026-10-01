package fila.teste;

import fila.FilaCircular;

public class Teste2 {

    static void main() {
        FilaCircular<String> fila = new FilaCircular<>(4);
        fila.enfileirar("A");
        fila.enfileirar("B");
        fila.enfileirar("C");
        fila.enfileirar("D");

        fila.imprimir();

        fila.desenfileirar();
        fila.desenfileirar();

        fila.enfileirar("F");
        fila.enfileirar("G");

        fila.imprimir();
    }

}
