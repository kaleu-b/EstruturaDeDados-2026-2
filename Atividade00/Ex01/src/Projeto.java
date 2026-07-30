public class Projeto {

    private String nome;
    private Gerente gerente;
    private String nomeGerente;
    private Subordinado[] equipe = new Subordinado[100];
    private double custoTotal;
    private boolean finalizado = false;

    public Projeto(String nome, Gerente gerente, Subordinado[] equipe, boolean finalizado) {
        this.nome = nome;
        this.equipe = equipe;
        this.gerente = gerente;
        nomeGerente = gerente.getNome();
        this.finalizado = finalizado;

        aplicarRemuneração();
        setCustoTotal();
    }

    public void aplicarRemuneração(){
        // bonus de 10% no salário se o projeto for finalizado
        if (finalizado){
            for (Subordinado s: equipe){
                if (s != null){
                    s.setSalario(s.getSalario()*1.10);
                }
            }
            gerente.setSalario(gerente.getSalario()*1.10);
        }
        // bonus de 1% pro gerente por funcionario na equipe
        for (Subordinado s: equipe){
            if (s != null){
            gerente.setSalario(gerente.getSalario()*1.10);
            }
        }
    }

    public void setCustoTotal() {
        int quantidade = equipe.length;
        double salarioGerente = quantidade * 0.01 + gerente.getSalario();
        double salarioEquipe = 0;

        for (int i = 0; i < quantidade; i++) {
        if(equipe[i] != null) {
            salarioEquipe += equipe[i].getSalario();
            }
        }
        custoTotal = salarioGerente + salarioEquipe;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("==========================\n");
        sb.append("PROJETO " + this.nome + "\n");
        sb.append("------------------------\n");
        sb.append("GERENTE: " + nomeGerente + "\n");
        sb.append("------------------------\n");
        sb.append(String.format("SALÁRIO GERENTE: %.2f \n", gerente.getSalario()));

        for (int i = 0; i < equipe.length; i++){
            if (equipe[i] != null){
                sb.append("------------------------\n");
                // sb.append("FUNCIONARIO " + (i+1) + " : " + equipe[i].getSalario() + "\n");
                sb.append(String.format("FUNCIONARIO %d \n", (i+1) ));
                sb.append("NOME:" + equipe[i].getNome() + "\n");
                sb.append(String.format("SALARIO: %.2f \n", equipe[i].getSalario()));
                sb.append("------------------------\n");
            }
        }

        sb.append( String.format("CUSTOS TOTAIS: %.2f \n", custoTotal) );
        sb.append("==========================\n");
        return sb.toString();
    }
}
