package fila;

public class Operador {

    private String nome;

    private Atendimento atendimento;

    private boolean ocioso;

    public String getNome() {
        return nome;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public boolean getOcioso(){return this.ocioso;}

    public void flipOcioso(){ocioso = !ocioso;}
}
