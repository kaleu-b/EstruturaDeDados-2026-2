package contatos;

public class AgendaTelefonica {

    private Vetor[] alfabeto;

    public AgendaTelefonica(int quantidade) {
        alfabeto = new char[26];
        for(int i=0; i<alfabeto.length; i++){
            alfabeto[i] = new Vetor<Contato>(1);
        }
    }

    public void adicionar(Contato contato) {
       /*  for (int i = 0; i < this.obterTamanho(); i++) {

            if(this.get(i).getNome().equalsIgnoreCase(contato.getNome())){
                System.out.println("Nome repetido!");
                return;
            }

            if(this.get(i).getTelefones().equals(contato.getTelefones())){
                System.out.println("Telefone repetido!");
                return;
            }
        }

        this.inserirOrdenado(contato);*/

        indiceAlfabeto = retornaIndice(contato);

        adicionarContato(contato, indiceAlfabeto);
    }

    private void adicionarContato(Contato contato, int i){
        alfabeto[i].inserirOrdenadov2(contato);
    }

    public int retornaIndice(Contato contato){
        char letra = Character.toUpperCase(contato.getNome().charAt(0));
        return letra - 'A';
    }


    public void remover(int indice) {

        if (indice < 0 || indice >= this.obterTamanho()){
            System.out.println("Indice invalido");
            return;
        }

        super.remover(indice);
    }



    public void remover(Contato contato) {

        for (int i = 0; i<this.obterTamanho(); i++){
            if  (this.get(i).getNome().equalsIgnoreCase(contato.getNome()) ||
                    this.get(i).getTelefones().equals(contato.getTelefones())){
                    this.remover(i);
                break;
            }
        }
    
    }

    public void buscar(Contato contato) {

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
        System.out.print(" ]");
    }
    // busca linear que retorna um obj. contato
    public Contato buscaLinear(String busca){
        for (int i = 0; i < this.obterTamanho(); i++) {
            if (this.get(i).getNome().equalsIgnoreCase(busca))return this.get(i);
        }
        return null;
    }
    // busca binaria que retorna um obj. contato
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