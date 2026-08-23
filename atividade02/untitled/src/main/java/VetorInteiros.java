import java.util.Random;

public class VetorInteiros {

    private int comparacoes = 0;
    private long inicio;// = System.nanoTime();
    private long fim;// = System.nanoTime();

    Random r = new Random(67);
    public Vetor<Integer> vetor;

    public VetorInteiros(int qtde){
        vetor = new Vetor<>(qtde);
    }

    private int gerarNumero(int range){
        return r.nextInt(range);
    }

    public void popular(int quantidade, int range){
        while (vetor.obterTamanho() <= quantidade){
            int sorteado = gerarNumero(range);
            vetor.inserirOrdenadov2(sorteado);
            //vetor.inserir(sorteado);
        }
    }

    public void listar(){
        vetor.imprimir();
    }

// busca linear com numeros inteiros
    public int buscaLinear(Vetor<Integer> vetor, int alvo){
        for (int i = 0; i < vetor.obterTamanho(); i++) {
            if(vetor.get(i).equals(alvo)){
                return i;
            }
        }
        return -1;
    }

// busca linear para arranjos ordenados
    public int buscaLinearOrdenada(Vetor<Integer> vetor, int alvo){
        for (int i = 0; i < vetor.obterTamanho(); i++) {
            if(vetor.get(i).equals(alvo)){
                return i;
            } else if (vetor.get(i) > alvo) {
                return -1;
            }
        }
        return -1;
    }

// busca binaria
    public int buscaBinaria(Vetor<Integer> vator, int alvo){
        int inicio = 0;
        int fim = vetor.obterTamanho();

       while (inicio <= fim){

           int meio = inicio+fim/2;

           if(vetor.get(meio) == alvo){
            return meio;
           } else if (vetor.get(meio) > alvo) {
               fim = meio-1;
           }else {
               inicio = meio+1;
           }
       }
        return -1;
    }
}
