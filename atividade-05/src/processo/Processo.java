package processo;

public class Processo implements Comparable{

    private String nome;
    private int instrucoesRestantes;
    private int tempo;
    private Status status;

    public Processo(String nome, int instrucoes, int tempo){
        this.nome = nome;
        this.instrucoesRestantes = instrucoes;
        this.tempo = tempo;
        this.status = Status.PRONTO;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getInstrucoesRestantes() {
        return instrucoesRestantes;
    }

    public void setInstrucoesRestantes(int instrucoesRestantes) {
        this.instrucoesRestantes = instrucoesRestantes;
        //AtualizaStatus();
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Status getStatus() {
        return status;
    }
    // método que atualiza o status do processo
    // abandonado mas faz o que precisa
    public void AtualizaStatus() {
        //muda o status do processo para finalizado se não tiver mais instruções
        if (instrucoesRestantes <= 0){
            status = Status.FINALIZADO;
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Processo: ");
        sb.append(" nome: ").append(nome).append('\'');
        sb.append(" instrucoesRestantes: ").append(instrucoesRestantes);
        sb.append(" tempo: ").append(tempo);
        sb.append(" status: ").append(status);
        sb.append("\n");
        return sb.toString();
    }
}
