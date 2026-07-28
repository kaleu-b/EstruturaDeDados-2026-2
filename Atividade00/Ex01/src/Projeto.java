import java.sql.Array;

public class Projeto {

    private String nome;
    private Gerente gerente;
    private String nomeGerente = gerente.getNome();
    private Subordinado[] equipe = new Subordinado[100];
    private double custoTotal;

    public Projeto(String nome, Gerente gerente, Subordinado[] equipe) {
        this.nome = nome;
        this.equipe = equipe;
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public Subordinado[] getEquipe() {
        return equipe;
    }

    public void setEquipe(Subordinado[] equipe) {
        this.equipe = equipe;
    }

    public void addEquipe(Subordinado sub){
        for (int i = 0; i<equipe.length; i++){
            if(equipe[i] == null){
                equipe[i] = sub;
            }
        }
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        int quantidade = equipe.length;
        double salarioGerente = quantidade * 0.01 + gerente.getSalario();
        double salarioEquipe = 0;

        for (int i = 0; i < quantidade; i++) {
            salarioEquipe += equipe[i].getSalario();
        }

        custoTotal = salarioGerente + salarioEquipe;
        this.custoTotal = custoTotal;
    }

    public void mostraEquipe(){
        for (int i = 0; i < equipe.length; i++) {
            IO.println("Funcionario " + i + ":");
            IO.println(equipe[i].getSalario());
        }
    }


}
