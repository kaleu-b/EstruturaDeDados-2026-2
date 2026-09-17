package atividade;

public class Posicao implements Comparable<Posicao> {

    private int linha;
    private int coluna;
    private char conteudo;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Posicao(int coluna, int linha, char conteudo) {
        this.coluna = coluna;
        this.linha = linha;
        this.conteudo = conteudo;
    }

    @Override
    public int compareTo(Posicao o) {
        return 0;
    }

    public char getConteudo() {
        return conteudo;
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }
}
