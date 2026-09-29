package fila.teste;

import fila.Atendimento;
import fila.Fila;
import fila.Operador;
import vetor.Vetor;

import java.util.Random;

public class CallCenter {


    Fila<Atendimento> atendimentos;
    Vetor<Operador> atendentes;



    void main() {

    atendimentos = new Fila<>(100);
    // criar os 20 atendentes
    atendentes = new Vetor<>(10);

        for (int i = 0; i < 25; i++) {
            //atendentes.inserir(new Operador());
            atendentes.inserir(new Operador(), i);
        }

    Random r = new Random();

    while (!atendimentos.isEmpty() || !atendimentos.isFull()){

    int numAtendimentos;

    numAtendimentos = r.nextInt(0,20);
        IO.println("Adicionando " + numAtendimentos + "atendimentos");
        for (int i = 0; i < numAtendimentos; i++) {
            atendimentos.enfileirar(new Atendimento());
        }
        // adicionar atendimentos aos atendentes se eles estiverem ociosos
        for (int i = 0; i < atendentes.obterTamanho(); i++) {
            if (atendentes.get(i).getOcioso() && !atendimentos.isEmpty()){
                atendentes.get(i).setAtendimento(atendimentos.desenfileirar());
            }else {
                if (r.nextInt(0, 2) != 1){
                    IO.println("Marcando atendente como ocioso");
                    atendentes.get(i).flipOcioso();
                    if (!atendimentos.isEmpty()) atendentes.get(i).setAtendimento(atendimentos.desenfileirar());
                }
            }
        }

    }

}


// a cada while, os 20 atendentes vão pegar um chamado se estiverem ociosos

// a cada iteração, aleatoriamente, os atendentes serão ou não liberados para
// atender alguém e serão adicionados a uma fila de atendentes ociosos

}
