import vetor.VetorEstatico;

public class Vetorporlista {

    private VetorEstatico[] nomesporletra;

    public Vetorporlista(){
        nomesporletra = new VetorEstatico[26];

        for (int i = 0; i < nomesporletra.length; i++) {
            nomesporletra[i] = new VetorEstatico(20);
        }

    }

    public void inserir(String nome){
        char letra = Character.toUpperCase(nome.charAt(0));
        int indice = letra - 'A';
        nomesporletra[indice].inserir(nome);
    }

    public void imprimir(){
        for (int i = 0; i < 26; i++) {
            char letra = (char) ('A' + i);
            System.out.println(letra + " ");
            nomesporletra[i].imprimir();
        }
    }
}
