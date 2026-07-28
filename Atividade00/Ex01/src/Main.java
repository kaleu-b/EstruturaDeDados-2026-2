public class Main{

    private Projeto[] projetos = new Projeto[100];
    private Subordinado[] funcionarios = new Subordinado[100];

    funcionarios[0] = new Subordinado(1000.0);

    void main() {
            IO.println("-------------PROJETOS------------");
            IO.println("1 - Cadastrar Projetos");
            IO.println("2 - Mostrar Projetos");

            String escolha = IO.readln("Escolha: ");

            switch (escolha){
                case "1":
                    cadastrarProjetos();
                case "2":
                    mostrarProjetos();
            }
    }

    public void cadastrarProjetos(){
        String nomeGerente = IO.readln("Digite o nome do gerente: ");
        double salarioGerente = Double.parseDouble(IO.readln("Digite o salario do gerente: "));
        String nomeProjeto = IO.readln("Digite o nome do projeto: ");
        Gerente gerente = new Gerente(salarioGerente, nomeGerente);
        Projeto projeto = new Projeto(nomeProjeto, gerente, funcionarios);
    }

    public void mostrarProjetos(){
        for (int i = 0; i < projetos.length; i++) {
            IO.println(projetos[i]);
        }
    }

}
