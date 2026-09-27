package fila;

public class Atendimento {

    private String nome;
    private int telefone;
    private int cod;
    private static int COD_ATENDIMENTO = 0;

    public Atendimento(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
        cod = ++COD_ATENDIMENTO;
    }
}
