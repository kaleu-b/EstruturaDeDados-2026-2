package contatos;

public class AgendaTelefonica {

    private final Vetor[] alfabeto;

    public AgendaTelefonica() {
        alfabeto = new Vetor[26];
        for(int i=0; i<alfabeto.length; i++){
            // inicia cada vetor de letra com 1 unico elemento
            // a medida que contatos são inseridos, o vetor deve aumentar.
            alfabeto[i] = new Vetor<Contato>(1);
        }
    }

    public void adicionar(Contato contato) {
        int indiceAlfabeto = retornaIndice(contato);

        adicionarContato(contato, indiceAlfabeto);
    }

    private void adicionarContato(Contato contato, int i){
        alfabeto[i].inserirOrdenadov2(contato);
    }

    public int retornaIndice(Contato contato){
        return retornaIndice(contato.getNome());
    }

    public int retornaIndice(String texto){
        char letra = Character.toUpperCase(texto.charAt(0));
        return letra - 'A';
    }

    public void remover(String busca) {
         int indiceAlfabeto = retornaIndice(busca);
         int indiceElemento = buscaBinariaInt(busca, alfabeto[indiceAlfabeto]);

         removerContato(indiceAlfabeto, indiceElemento);
    }

    private void removerContato(int indiceAlfabeto, int indiceElemento){
        IO.println(String.format("Removendo contato %s ", (Contato) alfabeto[indiceAlfabeto].get(indiceElemento)));
        alfabeto[indiceAlfabeto].remover(indiceElemento);
    }

    public void atualizarEmail(String busca, String email) {
        int indiceAlfabeto = retornaIndice(busca);
        int indiceElemento = buscaBinariaInt(busca, alfabeto[indiceAlfabeto]);

        Contato contatoAtualizado = (Contato) alfabeto[indiceAlfabeto].get(indiceElemento);
        ((Contato) alfabeto[indiceAlfabeto].get(indiceElemento)).setEmail(email);
    }

    public void listar() {
        char letra = 'A';
        for (Vetor<Contato> vetor : alfabeto) {
            IO.println("===========================================");
            IO.println(letra);
            for (int j = 0; j < vetor.obterTamanho(); j++) {
                if (vetor.get(j) != null) {
                    IO.println(
                            String.format("Nome: %s , Telefone: %s",
                                     vetor.get(j).getNome(),
                                     vetor.get(j).getTelefones())
                    );
                }
            }
            IO.println("===========================================");
            letra++;
        }

    }

    public Contato buscar(String busca){
        // descobre em que letra do alfabeto o possível contato deve estar
        int indiceAlfabeto = retornaIndice(busca);
        // busca na letra do alfabeto o termo da busca
        return buscaBinaria(busca, alfabeto[indiceAlfabeto]);
    }


    // busca binaria que retorna um obj. contato ou null se o obj. não for encontrado
    // a string de busca precisa ser uma correspondecia exata ao nome
    // ex: busca "ana paula" === nome "ana paula"
    protected static Contato buscaBinaria(String busca, Vetor<Contato> contatos){

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


    protected static int buscaBinariaInt(String busca, Vetor<Contato> contatos){
        int inicioVetor = 0;
        int fimVetor = contatos.obterTamanho() - 1;

        while(inicioVetor <= fimVetor){
            int meio = (inicioVetor + fimVetor) / 2;
            // se for igual a string de busca
            if (contatos.get(meio).getNome().equalsIgnoreCase(busca)){
                return meio;
            }
            // se for maior
            if(contatos.get(meio).compareTo(busca) < 0 ){
                inicioVetor = meio+1;
            }

            else fimVetor = meio-1;
        }
        return -1;
    }




    public void manipulacao(Contato[] lista) {
        for (Contato contato : lista){
            adicionar(contato);
        }
    }
}