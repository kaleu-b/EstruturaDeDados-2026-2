public class Main{

    private Projeto[] projetos = new Projeto[100];
    private Subordinado[] funcionarios = new Subordinado[100];

    void main() {
        while (true) {
            IO.println("-------------PROJETOS------------");
            IO.println("1 - Cadastrar Projetos");
            IO.println("2 - Mostrar Projetos");

            String escolha = IO.readln("Escolha: ");

            switch (escolha) {
                case "1":
                    cadastrarProjetos();
                case "2":
                    mostrarProjetos();
            }
        }
    }

    public void cadastrarProjetos() {
        String nomeGerente = IO.readln("Digite o nome do gerente: ");
        double salarioGerente = Double.parseDouble(IO.readln("Digite o salario do gerente: "));
        String nomeProjeto = IO.readln("Digite o nome do projeto: ");
        Gerente gerente = new Gerente(salarioGerente, nomeGerente);

        int qtdeSubordinados = Integer.parseInt(IO.readln("Digite a qtde. de subordinados (1-100): "));

        for (int i = 0; i < qtdeSubordinados; i++) {
            double salario = Double.parseDouble(IO.readln("Digite o salario do funcionario " + (i + 1) + " :"));
            funcionarios[i] = new Subordinado(salario);
        }

        String inFinalizado = IO.readln("Projeto finalizado (s/n): ");
        boolean finalizado = false;

        if (inFinalizado.charAt(0) == 's'){
            finalizado = true;
        }

        Projeto projeto = new Projeto(nomeProjeto, gerente, funcionarios, finalizado);

        for (int i = 0; i < projetos.length; i++) {
            if (projetos[i] == null){
                projetos[i] = projeto;
                break;
            }
        }
    }
    public void mostrarProjetos(){
        for (int i = 0; i < projetos.length; i++) {
            if(projetos[i] == null){
                break;
            }
            IO.println(projetos[i]);
        }
    }

}
