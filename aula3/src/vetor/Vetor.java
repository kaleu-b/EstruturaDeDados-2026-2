package vetor;

public class Vetor<T> {

    private T[] elementos;
    private int tamanhoPreenchido;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade){
        elementos = (T[]) new Object[quantidade];
        tamanhoPreenchido = 0;
    }

    public void inserir(T elemento){
        if(tamanhoPreenchido == elementos.length) {
            expandir();
        }
        elementos[tamanhoPreenchido] = elemento;
        tamanhoPreenchido++;
    }

    public int existeIgual(T elemento){
        int pos = -1;
        for (int i = 0; i < tamanhoPreenchido; i++) {
            if (elemento == elementos[i]){
                return i;
            }
        }
        return pos;
    }

    public void inserir(T elemento, int index){
        if(index> elementos.length || index<0)return;

        if(tamanhoPreenchido == elementos.length){
           expandir();
        }
        // deslocamento
        for (int i = tamanhoPreenchido; i > index; i--) {
            elementos[i] = elementos[i-1];
        }

        elementos[index] = elemento;
        tamanhoPreenchido++;
    }

    public T get(int index){
        return elementos[index];
    }

    @SuppressWarnings("unchecked")
    private void expandir(){
        T[] novo = (T[]) new Object[elementos.length*2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        this.elementos = novo;
    }

    public void imprimir(){
        System.out.print("[");
        for (T elemento : elementos) {
            System.out.print(elemento + ",");
        }
        System.out.println("]");
    }

    @SuppressWarnings("unchecked")
    private void reduzir(){
        if (tamanhoPreenchido <= elementos.length/4) {
            // quanto diminuir??????????????? **METADE**!!!!!!!!!!!!!!!
            T[] novo = (T[]) new Object[elementos.length / 2];
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
