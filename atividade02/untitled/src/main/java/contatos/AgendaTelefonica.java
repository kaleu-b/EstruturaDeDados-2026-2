package contatos;

public class AgendaTelefonica extends Vetor<Contato>{

    public AgendaTelefonica(int quantidade) {
        super(quantidade);
       // contatos = new Vetor<>(quantidade);
    }

    public void adicionar(Contato contato) {
        for (int i = 0; i < this.obterTamanho(); i++) {
            /*if (contatos.[i].getNome().equals(contato.getNome())) {
                System.out.println("Nome repetido!");
                return;
            }
            if (contatos[i].getTelefones().equals(contato.getTelefones())) {
                System.out.println("Telefone repetido!");
                return;
            }*/

            if(this.get(i).getNome().equalsIgnoreCase(contato.getNome())){
                System.out.println("Nome repetido!");
                return;
            }

            if(this.get(i).getTelefones().equals(contato.getTelefones())){
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

        this.inserirOrdenado(contato);
    }

    public void remover(int indice) {

        if (indice < 0 || indice >= this.obterTamanho()){
            System.out.println("Indice invalido");
            return;
        }

        super.remover(indice);

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

        for (int i = 0; i<this.obterTamanho(); i++){
            if  (this.get(i).getNome().equalsIgnoreCase(contato.getNome()) ||
                    this.get(i).getTelefones().equals(contato.getTelefones())){
                    this.remover(i);
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

        for (int i=0; i<this.obterTamanho(); i++){
            if (this.get(i).getNome().equalsIgnoreCase(contato.getNome()) || this.get(i).getTelefones().equals(contato.getTelefones())){
                //System.out.println("Nome: " + contatos[i].getNome() + " Telefone: " + contatos[i].getTelefones());
                System.out.println("Nome: " + this.get(i).getNome() + " Telefone:" + this.get(i).getTelefones());
            }
        }
    }

    public Contato[] buscarprefixo(String nome) {
        Contato[] contatosIguais;
        int tamanhoInicial = 0;
        // obtendo quantidade de elementos com mesmo nome
        for(int i = 0; i< this.obterTamanho(); i++){
            if(this.get(i).getNome().toLowerCase().startsWith(nome.toLowerCase())){
                tamanhoInicial++;
            }
        }

        contatosIguais = new Contato[tamanhoInicial];
        int preenchido = 0;
        for (int i = 0; i < this.obterTamanho(); i++) {
            if(this.get(i).getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                contatosIguais[preenchido] = this.get(i);
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
        for (int i = 0; i < this.obterTamanho(); i++) {
            if (this.get(i).getNome().equalsIgnoreCase(contatoantigo.getNome()) || this.get(i).getTelefones().equals(contatoantigo.getTelefones())) {
                this.remover(i);
                this.inserirOrdenado(contatonovo);
                return;
            }
        }
    }

    public void listar() {
        System.out.print("[ ");

        for (int i = 0; i<this.obterTamanho(); i++){
            System.out.println("Nome: " + this.get(i).getNome() + " Telefone:" + this.get(i).getTelefones());
        }
        /*for (int i = 0; i < tamanho; i++) {
            System.out.print("Nome: " + contatos[i].getNome() + " Telefone: " + contatos[i].getTelefones());
            if (i < contatos.length - 1) {
                System.out.println("");
            }
        }*/
        System.out.print(" ]");
    }

    public Contato buscaLinear(String busca){
        for (int i = 0; i < this.obterTamanho(); i++) {
            if (this.get(i).getNome().equalsIgnoreCase(busca))return this.get(i);
        }
        return null;
    }

    public static Contato buscaBinaria(String busca, AgendaTelefonica contatos){

        int inicioVetor = 0;
        int fimVetor = contatos.obterTamanho() - 1;

        while(inicioVetor <= fimVetor){
            int meio = (inicioVetor + fimVetor) / 2;
            // se for igual a string de busca
            if (contatos.get(meio).getNome().equalsIgnoreCase(busca)){
                return contatos.get(meio);
            }
            // se for maior
            if(contatos.get(meio).compareTo(busca) < 0 ){
                inicioVetor = meio+1;
            }

            else fimVetor = meio-1;
        }
        return null;
    }


    public void manipulacao(Contato[] contato) {
        for (Contato value : contato) adicionar(value);
    }
}