package contatos;

import java.util.Scanner;

public class Telefone {

    void main(){
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

            if (opcao.equals("1")) {
                IO.print("Digite o nome do contato: ");
                String contato = leitor.nextLine();
                IO.print("Digite telefone: ");
                String telefone = leitor.nextLine();
                // .adicionar();
                IO.println();
            } else if (opcao.equals("2")){
                IO.print("Digite o nome do contato a remover: ");
                String remover = leitor.nextLine();
                // .remover();
                IO.println();
            } else if (opcao.equals("3")){
                IO.print("Digite o nome do contato a buscar: ");
                String buscar = leitor.nextLine();
                // .buscar();
                IO.println();
            } else if (opcao.equals("4")){ 
                IO.print("Digite o nome do contato a atualizar: ");
                String contato = leitor.nextLine();
                IO.print("Digite o novo telefone: ");
                String telefone = leitor.nextLine();
                // atualizar();
                IO.println();
            } else if (opcao.equals("5")){ 
            continuarRodando = false;
            }  else {
                IO.println("Opção inexistente, tente novamente!");
                IO.println();
            }
        } 
    }
}