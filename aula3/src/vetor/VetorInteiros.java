package vetor;

import java.util.Random;

public class VetorInteiros {

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
        }
    }

    public void listar(){
        vetor.imprimir();
    }

}
