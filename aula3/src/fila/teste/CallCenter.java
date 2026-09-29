package fila.teste;

import fila.Atendimento;
import fila.Fila;
import fila.Operador;
import vetor.Vetor;

import java.util.Random;

public class CallCenter {


    Fila<Atendimento> atendimentos;
    Vetor<Operador> atendentes;
    Vetor<Operador> atendendentesDisponiveis;

    void main() {

    atendimentos = new Fila<>(1000);
    atendentes = new Vetor<>(20);


    }

// criar os 20 atendentes
// a cada while, os 20 atendentes vão pegar um chamado se estiverem ociosos

// a cada iteração, aleatoriamente, os atendentes serão ou não liberados para
// atender alguém e serão adicionados a uma fila de atendentes ociosos

}
