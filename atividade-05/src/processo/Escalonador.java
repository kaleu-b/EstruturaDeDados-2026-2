package processo;

import fila.Fila;

import javax.lang.model.element.QualifiedNameable;

public class Escalonador {

    Fila<Processo> processos;
    private final int QUANTUM = 2;
    private int tempo;

    public Escalonador(int capacidade){
        processos = new Fila<>(capacidade);
    }
    // processar reduz o num. de processos restantes e retorna o processo
    private Processo processar(Processo processo){
        int numProcessos = processo.getInstruçõesRestantes();
        processo.setInstruçõesRestantes(--numProcessos);
        return processo;
    }

    public int getQUANTUM() {
        return QUANTUM;
    }

    public void adicionarProcesso(String nomeProcesso){
        //tempo++;
        if (tempo == 1) {
            nomeProcesso = "P" + tempo;
            processos.enfileirar(new Processo(nomeProcesso, 4, tempo));
        } else if (tempo == 3) {
            nomeProcesso = "P" + tempo;
            processos.enfileirar(new Processo(nomeProcesso, 1, tempo));
        } else if (tempo == 5) {
            nomeProcesso = "P" + tempo;
            processos.enfileirar(new Processo(nomeProcesso, 2, tempo));
        }
    }

    void main(){
        tempo = 0;
        String nomeProcesso = "";

        //nomeProcesso = "P" + tempo;
        processos.enfileirar(new Processo("P0", 5, tempo));
        processos.enfileirar(new Processo("P1", 2, tempo));

        while (!processos.isEmpty()){

            Processo processo = processos.desenfileirar();
            processo.setStatus(Status.EXECUTANDO);
            for (int i = 0; i < QUANTUM; i++) {
                tempo++;
                adicionarProcesso(nomeProcesso);
                if (processo.getInstruçõesRestantes() > 0){
                    IO.println("Processando: " + processo);
                    processo = processar(processo);
                }else{
                    processo.setStatus(Status.FINALIZADO);
                    IO.println("Processo Finalizado: " + processo);
                    break;
                }
            }

            if (processo.getStatus() != Status.FINALIZADO){
                processo.setStatus(Status.PRONTO);
                processos.enfileirar(processo);
            }

        }
    }

}
