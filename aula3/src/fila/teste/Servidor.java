package fila.teste;

import fila.Fila;
import fila.Pacote;

import java.util.Random;

public class Servidor {

    private int reqCriadasTotal = 0;
    private int reqAtendidas = 0;
    private int reqPerdidas = 0;
    private int numProcessadores;
    private Random r = new Random();

    public void executar(int ciclos, Fila<Pacote> filaProcessos, int limitePacotes){
        // for de ciclos
        for (int i = 0; i <= ciclos; i++) {
            // levar em consideração que o limite pacotes exclui o ultimo num
            // ex: limitePacotes = 80, numeros gerados entre 0-79
            int numPacotes = r.nextInt(0, limitePacotes);
            // for para criar os pacotes
            for (int j = 0; j < numPacotes; j++) {

                if (!filaProcessos.isFull()) {
                filaProcessos.enfileirar(new Pacote(j, "fulaninho de tal", "aqui", "aloooo"));
                reqCriadasTotal++;
            }
            else{ reqCriadasTotal++; reqPerdidas++; IO.println("Fila cheia!!!!!!!!!!!!!!!!!!");}

            }
            // for para atender os pacotes
            for (int k = 0; k < numProcessadores; k++) {
                if (!filaProcessos.isEmpty()){ filaProcessos.desenfileirar();reqAtendidas++;}
                else {IO.println("Fila vazia :)))");}
            }

        }

        imprimirEstatisticas(filaProcessos);
    }

    void imprimirEstatisticas(Fila<Pacote> fila){
        int numProcessosRestantesNaFila = 0;

        while (!fila.isEmpty()){
            numProcessosRestantesNaFila++;
            fila.desenfileirar();
        }

        IO.println(String.format(
                "pacotes atendidos: %d\npacotes perdidos: %d\npacotes totais: %d\npacotes sobrando na fila: %d\nporcentagem de perda: %f\nporcentagem de atendimentos:%f",
                reqAtendidas, reqPerdidas, reqCriadasTotal, numProcessosRestantesNaFila, (((double) reqPerdidas/reqCriadasTotal)*100), (((double) reqAtendidas/reqCriadasTotal)*100)
        ));


    }

    private void zerarEstatisticas(){
        reqPerdidas = 0;
        reqCriadasTotal = 0;
        reqAtendidas = 0;
    }

    void main() throws InterruptedException {
    Fila<Pacote> filaPequena = new Fila<>(50);
        this.numProcessadores = 4;
        // cenário com poucos pacotes gerados por segundo
        // 4 processadores, até 4 pacotes por segundo
        // fila pequena
        // resultado esperado: mesmo após vários ciclos, todos os pacotes
        // devem ser atendidos
        executar(100, filaPequena, 5);
        Thread.sleep(2000);
        // cenário com o dobro de pacotes podendo ser gerados em
        // relação ao num de processadores, com uma fila pequena
        // resultado esperado: alguma perda de pacotes, mas nada
        // extremamente preocupante.
        zerarEstatisticas();
        executar(100, filaPequena, 9);
        Thread.sleep(2000);
        // cenário com um número máximo de pacotes gerados sendo o tamanho da
        // fila, somente 4 processadores.
        // resultado esperado: muita perda de pacotes
        zerarEstatisticas();
        executar(100, filaPequena, 51);
        //Thread.sleep(2000);
    }


// a cada while, os 20 atendentes vão pegar um chamado se estiverem ociosos

// a cada iteração, aleatoriamente, os atendentes serão ou não liberados para
// atender alguém e serão adicionados a uma fila de atendentes ociosos

}
