package contatos;

public class Telefone {
    static void main() {
        AgendaTelefonica agenda = new AgendaTelefonica(7);

        Contato c1 = new Contato("Ana", "123");
        Contato c2 = new Contato("Gabriel", "234");
        Contato c3 = new Contato("Eduardo", "345");
        Contato c4 = new Contato("Gabriela", "456");
        Contato c5 = new Contato("Anas", "567");
        
        Contato b1 = new Contato("Teste", "236452");
        Contato b2 = new Contato("Teste2", "68768687687");

        Contato[] contatos = {b1, b2};


        agenda.adicionar(c1);
        agenda.adicionar(c2);
        agenda.adicionar(c3);
        agenda.adicionar(c4);
        agenda.adicionar(c5);

        agenda.listar();
        System.out.println();

        Contato c6 = new Contato("Ane", "678");
        agenda.atualizar(c1, c6);

        agenda.listar();
        System.out.println();

        agenda.buscar(c2);
        System.out.println();
        

        agenda.remover(c3);

        agenda.listar();
        System.out.println();
    
        agenda.manipulacao(contatos);
        agenda.listar();
        

        Contato[] contatoIguaisTeste = agenda.buscarprefixo("Gabriel");

        for (int i = 0; i < contatoIguaisTeste.length; i++) {
            IO.println(contatoIguaisTeste[i]);
        }

    }
}