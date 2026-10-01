package fila.teste;

import fila.Fila;
import fila.Pacote;
import fila.Produtor;

public class Teste1 {

    static void main() {
        Fila<Pacote> fila = new Fila<>(10);
        Produtor pr1 = new Produtor("produtor 1", "PC-A");
        Produtor pr2 = new Produtor("produtor 2", "PC-B");

        pr1.produzirPacote(fila, 1, "login", "Servidor 2", "AAAA");
        pr1.produzirPacote(fila, 2, "imagem", "Servidor 1", "AAAA");

        pr2.produzirPacote(fila, 3, "senha", "servidor 3", "ADFAFASDF");

        fila.imprimir();

        Pacote pacoteFila = fila.desenfileirar();

        fila.imprimir();
    }



}
