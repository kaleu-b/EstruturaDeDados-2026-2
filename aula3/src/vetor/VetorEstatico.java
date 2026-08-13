package vetor;

public class VetorEstatico {

    private String elementos[];
    private int tamanhoPreenchido;

    public VetorEstatico(int quantidadePosicoes){
        elementos = new String[quantidadePosicoes];
        this.tamanhoPreenchido = 0;
    }

    public void inserir(String elemento){
        if(tamanhoPreenchido < elementos.length) {
            elementos[tamanhoPreenchido] = elemento;
            tamanhoPreenchido++;
        }else {
            IO.println("Vetor cheio !!!");
        }
    }

    public void inserir(int indice, String elemento){
        if(tamanhoPreenchido >= elementos.length){
            System.out.println("Vetor cheio");
            return;
        }

        if (indice < 0 || indice > elementos.length){
            System.out.println("Posição inválida");
            return;
        }

        for (int i = tamanhoPreenchido; i > indice; i--) {
            elementos[i] = elementos[i-1];
        }

        elementos[indice] = elemento;
        tamanhoPreenchido++;
    }

    public void imprimir(){
       System.out.print("[");

        for (String elemento : elementos) {
            System.out.print(elemento + ",");
        }
        System.out.println("]");
    }

    public int obterTamanho(){
        return tamanhoPreenchido;
    }

    public String ler(int indice){

        if (indice >= 0 && indice < tamanhoPreenchido){
            return elementos[indice];
        }else {
            throw new IndexOutOfBoundsException("Indice invalido :(");
        }

    }

    public void remover(int indice){
        if (indice < 0 || indice > elementos.length){
            System.out.println("Posição inválida");
            return;
        }

        for(int i = indice; i < tamanhoPreenchido; i++){
            elementos[i] = elementos[i+1];
        }
        elementos[tamanhoPreenchido-1] = null;
        tamanhoPreenchido--;
    }


    public void removerUltimo(){

        if (tamanhoPreenchido > 0){
            elementos[tamanhoPreenchido-1] = null;
            tamanhoPreenchido--;
        }else {
            System.out.println("Vetor vazio");
        }

    }

}