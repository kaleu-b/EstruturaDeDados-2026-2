public class Gerente extends Funcionario{

    public Gerente(Double salario, String nome) {
        super(salario, nome);
    }

    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }
}
