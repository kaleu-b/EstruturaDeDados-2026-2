package Vetor;

public class VetorLista {

    private VetorEstatico[] nomesPorLetra;

    public VetorLista(){
        nomesPorLetra = new VetorEstatico[26];

        for (int i = 0; i < nomesPorLetra.length; i++) {
            nomesPorLetra[i] = new VetorEstatico(20);
        }
    }

    public void inserir(String nome){
        char letra = Character.toUpperCase(nome.charAt(0));
        int indice = letra - 'A';

        nomesPorLetra[indice].inserir(nome);
    }

    public void imprimir(){
        for (int i = 0; i < 26; i++){
            char letra = (char) ('A' + i);
            System.out.print(letra + " ");
            nomesPorLetra[i].imprimir();
        }
    }

}
