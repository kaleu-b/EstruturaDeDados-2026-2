package Agenda;

public class Agenda {

    private Contato contatos[];
    private int tamanhoPreenchido;

    public Agenda(int quantidadePosicoes){
        contatos = new Contato[quantidadePosicoes];
        tamanhoPreenchido = 0;
    }

    public void inserir(Contato contato){
        if(tamanhoPreenchido < contatos.length){
            contatos[tamanhoPreenchido] = contato;
            tamanhoPreenchido++;
        }else {
           IO.println("Agenda cheia.");
        }
    }

    public void inserir(int indice, Contato contato){
        if(tamanhoPreenchido >= contatos.length){
            System.out.println("Vetor cheio");
            return;
        }

        if (indice < 0 || indice > contatos.length){
            System.out.println("Posição inválida");
            return;
        }

        for (int i = tamanhoPreenchido; i > indice; i--) {
            contatos[i] = contatos[i-1];
        }

        contatos[indice] = contato;
        tamanhoPreenchido++;
    }

    public void remover(){
        if(tamanhoPreenchido > 0){
            contatos[tamanhoPreenchido-1] = null;
            tamanhoPreenchido--;
        }else {
            IO.println("Vetor vazio.");
        }
    }

    public void remover(int indice){
        if (indice < 0 || indice > contatos.length){
            System.out.println("Posição inválida");
            return;
        }

        for(int i = indice; i < tamanhoPreenchido; i++){
            contatos[i] = contatos[i+1];
        }
        contatos[tamanhoPreenchido-1] = null;
        tamanhoPreenchido--;
    }

}
