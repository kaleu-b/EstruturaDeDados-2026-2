package processo;

public enum Status {

    PRONTO("Pronto", 0),
    EXECUTANDO("Executando",1),
    FINALIZADO("Finalizado", 2);

    private final String descricao;
    private final int codigo;

    Status(String descricao, int codigo){
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
