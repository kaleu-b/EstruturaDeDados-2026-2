package contatos;

import contatos.Contato;

public class AgendaTelefonica {
    private Vetor<Contato> contatos;

    public AgendaTelefonica(int quantidade) {
        contatos = new Vetor<>(quantidade);
    }

    public void adicionar(Contato contato) {
        for (int i = 0; i < contatos.obterTamanho(); i++) {
            /*if (contatos.[i].getNome().equals(contato.getNome())) {
                System.out.println("Nome repetido!");
                return;
            }
            if (contatos[i].getTelefones().equals(contato.getTelefones())) {
                System.out.println("Telefone repetido!");
                return;
            }*/

            if(contatos.get(i).getNome().equalsIgnoreCase(contato.getNome())){
                System.out.println("Nome repetido!");
                return;
            }

            if(contatos.get(i).getTelefones().equals(contato.getTelefones())){
                System.out.println("Telefone repetido!");
                return;
            }
        }

       /* if (tamanho < contatos.length) {
            contatos[tamanho] = contato;
            tamanho++;
        } else {
            System.out.println("Não existe posição disponivel");
        }/*

        */
        // expandir();

        contatos.inserirOrdenado(contato);
    }

    public void remover(int indice) {

        if (indice < 0 || indice >= contatos.obterTamanho()){
            System.out.println("Indice invalido");
            return;
        }

        contatos.remover(indice);

         /*if (indice < 0 || indice >= tamanho) {
            System.out.println("Indice Inválido");
            return;
        }
        for (int i = indice; i < tamanho; i++) {
            contatos[i] = contatos[i+1];
        }
        contatos[tamanho-1] = null;
        tamanho--;
        reduzir();*/
    }



    public void remover(Contato contato) {

        for (int i = 0; i<contatos.obterTamanho(); i++){
            if (contatos.get(i).getNome().equalsIgnoreCase(contato.getNome()) ||
                    contatos.get(i).getTelefones().equals(contato.getTelefones())){
                contatos.remover(i);
                break;
            }
        }
        /*for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(contato.getNome()) || contatos[i].getTelefones().equals(contato.getTelefones())) {
                remover(i);
            }
            contatos[tamanho-1] = null;
            tamanho--;
            return;
        }
        reduzir();*/
    }

    public void buscar(Contato contato) {
        /*for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(contato.getNome()) || contatos[i].getTelefones().equals(contato.getTelefones())) {
                System.out.println("Nome: " + contatos[i].getNome() + " Telefone: " + contatos[i].getTelefones());
                return;
            }
        }*/

        for (int i=0; i<contatos.obterTamanho(); i++){
            if (contatos.get(i).getNome().equalsIgnoreCase(contato.getNome()) || contatos.get(i).getTelefones().equals(contato.getTelefones())){
                //System.out.println("Nome: " + contatos[i].getNome() + " Telefone: " + contatos[i].getTelefones());
                System.out.println("Nome: " + contatos.get(i).getNome() + " Telefone:" + contatos.get(i).getTelefones());
            }
        }
    }

    public Contato[] buscarprefixo(String nome) {
        Contato[] contatosIguais;
        int tamanhoInicial = 0;
        // obtendo quantidade de elementos com mesmo nome
        for(int i = 0; i< contatos.obterTamanho(); i++){
            if(contatos.get(i).getNome().toLowerCase().startsWith(nome.toLowerCase())){
                tamanhoInicial++;
            }
        }

        contatosIguais = new Contato[tamanhoInicial];
        int preenchido = 0;
        for (int i = 0; i < contatos.obterTamanho(); i++) {
            if(contatos.get(i).getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                contatosIguais[preenchido] = contatos.get(i);
                preenchido++;
            }
        }
        /*for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(nome)) {
                contatosIguais[tamanhoInicial] = contatos[i];
                tamanhoInicial++;
            }
        }*/
        return contatosIguais;
    }

    public void atualizar(Contato contatoantigo, Contato contatonovo) {
        for (int i = 0; i < contatos.obterTamanho(); i++) {
            if (contatos.get(i).getNome().equalsIgnoreCase(contatoantigo.getNome()) || contatos.get(i).getTelefones().equals(contatoantigo.getTelefones())) {
                contatos.remover(i);
                contatos.inserirOrdenado(contatonovo);
                return;
            }
        }
    }

    public void listar() {
        System.out.print("[ ");

        for (int i = 0; i<contatos.obterTamanho(); i++){
            System.out.println("Nome: " + contatos.get(i).getNome() + " Telefone:" + contatos.get(i).getTelefones());
        }
        /*for (int i = 0; i < tamanho; i++) {
            System.out.print("Nome: " + contatos[i].getNome() + " Telefone: " + contatos[i].getTelefones());
            if (i < contatos.length - 1) {
                System.out.println("");
            }
        }*/
        System.out.print(" ]");
        System.out.println("");
    }

    public void manipulacao(Contato[] contato) {
        for (int i = 0; i < contato.length; i++){
            adicionar(contato[i]);
        }
    }
}