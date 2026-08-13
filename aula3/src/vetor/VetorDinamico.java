package vetor;

public class VetorDinamico {

    private String elementos[];
    private int tamanhoPreenchido;

    public VetorDinamico(int quantidadePosicoes){
        elementos = new String[quantidadePosicoes];
        this.tamanhoPreenchido = 0;
    }

    public void inserir(String elemento){
        if(tamanhoPreenchido == elementos.length) {
            expandir();
        }
        elementos[tamanhoPreenchido] = elemento;
        tamanhoPreenchido++;
    }

    private void expandir(){
        String[] novo = new String[elementos.length*2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        this.elementos = novo;
    }

    public void imprimir(){
        System.out.print("[");
        for (String elemento : elementos) {
            System.out.print(elemento + ",");
        }
        System.out.println("]");
    }

    private void reduzir(){
        if (tamanhoPreenchido <= elementos.length/4) {
            // quanto diminuir??????????????? **METADE**!!!!!!!!!!!!!!!
            String[] novo = new String[elementos.length / 2];
            for (int i = 0; i < tamanhoPreenchido; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
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
        reduzir();
    }

    public int obterTamanho(){
        return elementos.length;
    }

}