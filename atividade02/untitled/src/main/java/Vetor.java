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

    public T get(int i){
        return elementos[i];
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

    // retorna um booleano caso não seja necessária a posição do
    // item existente
    public boolean contem(T elemento) {
        return localizar(elemento) != -1;
    }

    public void inserirOrdenadov2(T valor) {

        if (localizar(valor) != -1) {
           // System.out.println("Valor " + valor + " já existe na lista.");
            return;
        }
        if (tamanhoPreenchido == 0) {
            inserir(valor, tamanhoPreenchido);
            return;
        }
        for (int i = 0; i < tamanhoPreenchido; i++) {
            if ((Integer)valor < (Integer) elementos[i]) {
                inserir(valor,i);
                break;
            }
        }
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

    public int localizar(T elemento) {
        for (int i = 0; i < tamanhoPreenchido; i++) {
            if (elementos[i] != null && elementos[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public void inserirOrdenado(T valor) {
        if (localizar(valor) != -1) {
            //System.out.println("Valor " + valor + " já existe na lista.");
            return;
        }
        if (tamanhoPreenchido == elementos.length) {
            expandir();
        }
        int i;
        for (i = tamanhoPreenchido - 1; i >= 0; i--) {
            Integer atual = (Integer) elementos[i];
            if (atual > (Integer) valor) {
                elementos[i + 1] = elementos[i]; // desloca para a direita
            } else {
                break;
            }
        }
        elementos[i + 1] = valor;
        tamanhoPreenchido++;
    }

    public T[] toArray(){// elementos = (T[]) new Object[quantidade];
        T[] elementosNovos;
        elementosNovos = (T[]) new Object[tamanhoPreenchido];
        if (tamanhoPreenchido >= 0) System.arraycopy(elementos, 0, elementosNovos, 0, (tamanhoPreenchido));
        return elementosNovos;
    }

    public int obterTamanho(){
        return tamanhoPreenchido;
    }

}
