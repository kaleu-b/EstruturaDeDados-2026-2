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

    void main(){
        tempo = 0;
        String nomeProcesso;

        nomeProcesso = "P" + tempo;
        processos.enfileirar(new Processo(nomeProcesso, 5, tempo));

        while (!processos.isEmpty()){
            tempo++;
            if (tempo == 1) {
                nomeProcesso = "P" + tempo;
                processos.enfileirar(new Processo(nomeProcesso, 2, tempo));
            } else if (tempo == 3) {
                nomeProcesso = "P" + tempo;
                processos.enfileirar(new Processo(nomeProcesso, 4, tempo));
            } else if (tempo == 5) {
                nomeProcesso = "P" + tempo;
                processos.enfileirar(new Processo(nomeProcesso, 2, tempo));
            }

            Processo processo = processos.desenfileirar();
            processo.setStatus(Status.EXECUTANDO);
            for (int i = 0; i < QUANTUM; i++) {
                if (processo.getInstruçõesRestantes() > 0){
                    IO.println("Processando: " + processo);
                    processo = processar(processo);
                }else{
                    processo.setStatus(Status.FINALIZADO);
                    IO.println("Processo Finalizado: " + processo);
                }
            }

            if (processo.getStatus() != Status.FINALIZADO){
                processo.setStatus(Status.PRONTO);
                processos.enfileirar(processo);
            }

        }
    }

}
