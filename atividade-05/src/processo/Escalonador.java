package processo;

import fila.Fila;

public class Escalonador {

    Fila<Processo> processos;
    private final int QUANTUM = 2;
    private int tempo;
    private int contadorProcesso = 2;

    public Escalonador(int capacidade){
        processos = new Fila<>(capacidade);
    }
    // processar reduz o num. de processos restantes e retorna o processo
    private Processo processar(Processo processo){
        int numProcessos = processo.getInstrucoesRestantes();
        processo.setInstrucoesRestantes(--numProcessos);
        return processo;
    }

    public int getQUANTUM() {
        return QUANTUM;
    }

    public void adicionarProcesso(String nomeProcesso){
        //tempo++;
        if (tempo == 1) {
            nomeProcesso = nomeProcesso + contadorProcesso;
            processos.enfileirar(new Processo(nomeProcesso, 4, tempo));
        } else if (tempo == 3) {
            nomeProcesso = nomeProcesso + ++contadorProcesso;
            processos.enfileirar(new Processo(nomeProcesso, 1, tempo));
        } else if (tempo == 5) {
            nomeProcesso += nomeProcesso + ++contadorProcesso;
            processos.enfileirar(new Processo(nomeProcesso, 2, tempo));
        }
    }

    void main(){
        tempo = 0;
        String nomeProcesso = "P";

        processos.enfileirar(new Processo("P0", 5, tempo));
        processos.enfileirar(new Processo("P1", 2, tempo));

        while (!processos.isEmpty()){
            // desenfileira o processo
            Processo processo = processos.desenfileirar();
            processo.setStatus(Status.EXECUTANDO);
            // pra cada quantum
            for (int i = 0; i < QUANTUM; i++) {
                tempo++;
                adicionarProcesso(nomeProcesso);
                IO.println("Processo: " + processo);
                processo = processar(processo);
                // se for processo sem instruções restantes
                if (processo.getInstrucoesRestantes() <= 0){
                    // processo finalizado
                    processo.setStatus(Status.FINALIZADO);
                    // atualiza o tempo
                    processo.setTempo(tempo);
                    IO.println("Processo finalizado: " + processo);
                    break;
                }

            }
            // se não for processo finalizado
            if (processo.getStatus() != Status.FINALIZADO){
                // status pronto
                processo.setStatus(Status.PRONTO);
                // atualiza o tempo
                processo.setTempo(tempo);
                // reinfilera o processo
                processos.enfileirar(processo);
            }

        }
    }

}