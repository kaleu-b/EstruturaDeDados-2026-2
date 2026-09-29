package fila;

public class Operador implements Comparable {

    private String nome;

    private Atendimento atendimento;

    private boolean ocioso;

    public Operador(Atendimento atendimento) {
        this.atendimento = atendimento;
        ocioso = true;
    }

    public Operador(){
        ocioso = true;
    }

    public String getNome() {
        return nome;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
        flipOcioso();
    }

    public boolean getOcioso(){return this.ocioso;}

    public void flipOcioso(){ocioso = !ocioso;}

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
