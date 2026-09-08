package contatos;

import java.util.Scanner;

public class Telefone {
    void main() {
        AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
        //  descomente essas linhas abaixo para adicionar contatos de teste sem precisar
        //  interagir com o CLI

/*            Contato[] lista = {
              new Contato("Ana Paula Zulane", "9809797"),
              new Contato("Ana Paula Carolina", "908098"),
              new Contato("Ana", "09789807"),
              new Contato("Ana Paula Zzlane", "98080"),
              new Contato("Ana Paula Carolina da Silva", "8098"),
              new Contato("Ana Paula Carolina da Santos", "08908")
            };

            agendaTelefonica.manipulacao(lista);
            agendaTelefonica.listar();
            agendaTelefonica.remover("Ana");
            agendaTelefonica.listar();

            IO.println(agendaTelefonica.buscar("Ana Paula Carolina"));
            agendaTelefonica.atualizarTelefone("Ana Paula Carolina", "9877697");
            agendaTelefonica.listar();

            agendaTelefonica.atualizarTelefone("Ana", "989797");
            agendaTelefonica.remover("Ana");
*/
        Scanner leitor = new Scanner(System.in);
        boolean continuarRodando = true;
        while (continuarRodando) {
            IO.println("""
                    --- MENU DA AGENDA DE CONTATOS ---
                    1 - Adicionar Contato (Ordenado)
                    2 - Remover Contato
                    3 - Buscar Contato
                    4 - Atualizar Contato
                    5 - Sair
                    """);
            IO.print("Escolha uma opção: ");
            String opcao = leitor.nextLine();
            IO.println();

            switch (opcao) {
                case "1" -> {
                    IO.print("Digite o nome do contato: ");
                    String contato = leitor.nextLine();
                    IO.print("Digite telefone: ");
                    String telefone = leitor.nextLine();
                    Contato novoContato = new Contato(contato, telefone);
                    agendaTelefonica.adicionar(novoContato);
                    IO.println();
                }
                case "2" -> {
                    IO.print("Digite o nome do contato a remover: ");
                    String remover = leitor.nextLine();
                    agendaTelefonica.remover(remover);
                    IO.println();
                }
                case "3" -> {
                    IO.print("Digite o nome do contato a buscar: ");
                    String buscar = leitor.nextLine();
                    IO.println(agendaTelefonica.buscar(buscar));
                    IO.println();
                }
                case "4" -> {
                    IO.print("Digite o nome do contato a atualizar: ");
                    String contato = leitor.nextLine();
                    IO.print("Digite o novo telefone: ");
                    String telefone = leitor.nextLine();
                    agendaTelefonica.atualizarTelefone(contato, telefone);
                    IO.println();
                }
                case "5" -> continuarRodando = false;
                default -> {
                    IO.println("Opção inexistente, tente novamente!");
                    IO.println();
                }
            }
        }
    }
}