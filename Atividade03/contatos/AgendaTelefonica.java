package contatos;

public class AgendaTelefonica {
    private final Vetor[] alfabeto;

    public AgendaTelefonica() {
        alfabeto = new Vetor[26];
        for (int i = 0; i < alfabeto.length; i++) {
            // inicia cada vetor de letra com 1 unico elemento
            // a medida que contatos são inseridos, o vetor deve aumentar.
            alfabeto[i] = new Vetor<Contato>(1);
        }
    }
    // método público que recebe o contato e adiciona ele
    public void adicionar(Contato contato) {
        int indiceAlfabeto = retornaIndice(contato);
        // chama o método que insere o contato de forma ordenada
        adicionarContato(contato, indiceAlfabeto);
    }
    // método privado que adiciona o contato
    private void adicionarContato(Contato contato, int i) {
        alfabeto[i].inserirOrdenadov2(contato);
    }

    // recebe um obj. contato e passa o nome do contato como parâmetro pra outra função
    // e retorna o indice
    public int retornaIndice(Contato contato) {
        return retornaIndice(contato.getNome());
    }

    // recebe uma string (nome) e retorna em que indice
    // (letra do alfabeto) o contato deve ser inserido.
    // 0 -> A, 1 -> B, etc.
    // complexidade: O(1)
    public int retornaIndice(String texto) {
        char letra = Character.toUpperCase(texto.charAt(0));
        return letra - 'A';
    }

    // recebe uma string de busca (nome) e remove o contato
    public void remover(String busca) {
        int indiceAlfabeto = retornaIndice(busca);
        // busca o índice do contato usando a string be busca
        // e o indice no alfabeto para buscar o contato
        int indiceElemento = buscaBinariaInt(busca, alfabeto[indiceAlfabeto]);

        if (indiceElemento < 0) {
            IO.println("Contato não encontrado.");
            return;
        }
        // remove o contato da lista usando o indice do alfabeto
        // e o indice dentro da seção do alfabeto
        removerContato(indiceAlfabeto, indiceElemento);
    }
    // remove o contato usando duas informaçõea:
    // indice no alfabeto, indice dentro da letra do alfabeto
    private void removerContato(int indiceAlfabeto, int indiceElemento) {
        IO.println(String.format(
                "Removendo contato %s ", (Contato) alfabeto[indiceAlfabeto].get(indiceElemento)));
        alfabeto[indiceAlfabeto].remover(indiceElemento);
    }
    // atualiza o email com base no nome do contato e o novo valor do email
    public void atualizarEmail(String busca, String email) {
        int indiceAlfabeto = retornaIndice(busca);
        int indiceElemento = buscaBinariaInt(busca, alfabeto[indiceAlfabeto]);
        // se não for encontrado
        if (indiceElemento < 0) {
            IO.println("Contato nãoo encontrado");
            return;
        }
        // se for encontrado atualiza o email
        ((Contato) alfabeto[indiceAlfabeto].get(indiceElemento)).setEmail(email);
    }
    // lista todos os contatos de todas as letras do alfabeto
    // complexidade: O(n²) ou O(26*O(n))
    public void listar() {
        char letra = 'A';
        for (Vetor<Contato> vetor : alfabeto) {
            IO.println("===========================================");
            IO.println(letra);
            for (int j = 0; j < vetor.obterTamanho(); j++) {
                if (vetor.get(j) != null) {
                    IO.println(String.format(
                            "Nome: %s , Telefone: %s", vetor.get(j).getNome(), vetor.get(j).getTelefones()));
                }
            }
            IO.println("===========================================");
            letra++;
        }
    }
    // retorna um obj. contato com base em uma string de busca (nome)
    public Contato buscar(String busca) {
        // descobre em que letra do alfabeto o possível contato deve estar
        int indiceAlfabeto = retornaIndice(busca);
        // busca na letra do alfabeto o termo da busca
        return buscaBinaria(busca, alfabeto[indiceAlfabeto]);
    }

    // busca binaria que retorna um obj. contato ou null se o obj. não for encontrado
    // a string de busca precisa ser uma correspondecia exata ao nome
    // ex: busca "ana paula" === nome "ana paula" ou "Ana Paula" === "ana paula"
    // complexidade: O(log n)
    protected static Contato buscaBinaria(String busca, Vetor<Contato> contatos) {
        int inicioVetor = 0;
        int fimVetor = contatos.obterTamanho() - 1;

        while (inicioVetor <= fimVetor) {
            int meio = (inicioVetor + fimVetor) / 2;
            // se for igual a string de busca
            if (contatos.get(meio).getNome().equalsIgnoreCase(busca)) {
                return contatos.get(meio);
            }
            // se for maior
            if (contatos.get(meio).compareTo(busca) < 0) {
                inicioVetor = meio + 1;
            }

            else
                fimVetor = meio - 1;
        }
        return null;
    }

    // recebe uma string de busca (o nome do contato) e o vetor (letra) em que o contato se encontra
    // e retorna o indice do contato
    // complexidade: O(log n)
    protected static int buscaBinariaInt(String busca, Vetor<Contato> contatos) {
        int inicioVetor = 0;
        int fimVetor = contatos.obterTamanho() - 1;

        while (inicioVetor <= fimVetor) {
            int meio = (inicioVetor + fimVetor) / 2;
            // se for igual a string de busca
            if (contatos.get(meio).getNome().equalsIgnoreCase(busca)) {
                return meio;
            }
            // se for maior
            if (contatos.get(meio).compareTo(busca) < 0) {
                inicioVetor = meio + 1;
            }
            // se não for
            else
                fimVetor = meio - 1;
        }
        // se não for encontrado
        return -1;
    }

    // adiciona vários contatos de uma vez só
    // complexidade: O(m * O(n)), m sendo o número
    // da lista de contatos a ser adicionado e O(n)
    // sendo a complexidade da inserção ordenada de contatos
    public void manipulacao(Contato[] lista) {
        for (Contato contato : lista) {
            adicionar(contato);
        }
    }
}