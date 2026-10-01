package fila;

public class Atendimento implements Comparable {

    private String nome;
    private int telefone;
    private int cod;
    private static int COD_ATENDIMENTO = 0;

    public Atendimento() {
        this.nome = "João de tal";
        this.telefone = (int) (Math.random() * 1000);
        cod = ++COD_ATENDIMENTO;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "ATENDIMENTO: " + cod;
    }
}
