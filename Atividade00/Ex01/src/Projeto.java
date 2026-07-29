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
        // bonus de 10 por cento se projeto finalizado
        if (finalizado){
            for (Subordinado s : equipe){

                if (s == null) break;

                s.setSalario(s.getSalario() + (s.getSalario() * 0.1));
            }
            gerente.setSalario(gerente.getSalario() + (gerente.getSalario() * 0.1));
        }

        for (Subordinado s : equipe){
            if (s == null) break;
            gerente.setSalario(gerente.getSalario() + (gerente.getSalario()*0.01));
        }

        setCustoTotal();
    }

    public void setCustoTotal() {
        int quantidade = equipe.length;
        double salarioGerente = quantidade * 0.01 + gerente.getSalario();
        double salarioEquipe = 0;

        for (int i = 0; i < quantidade; i++) {
        if(equipe[i] != null) {
            salarioEquipe += equipe[i].getSalario();
            }
            break;
        }
        custoTotal = salarioGerente + salarioEquipe;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("==========================\n");
        sb.append("PROJETO " + this.nome + "\n");
        sb.append("GERENTE: " + nomeGerente + "\n");

        for (int i = 0; i < equipe.length; i++){
            if (equipe[i] != null){
                sb.append("FUNCIONARIO " + (i+1) + " : " + equipe[i].getSalario() + "\n");
            }
        }

        sb.append( String.format("CUSTOS TOTAIS: %.2f", custoTotal) );

        return sb.toString();
    }
}
