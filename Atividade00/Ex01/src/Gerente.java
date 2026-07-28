public class Gerente extends Funcionario{

    private String nome;

    public Gerente(Double salario, String nome) {
        super(salario);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
