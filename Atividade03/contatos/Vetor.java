package contatos;

public class Vetor<T extends Comparable<T>> {

    private T[] elementos;
    private int tamanhoPreenchido;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade){
        elementos = (T[]) new Comparable[quantidade];
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
        T[] novo = (T[]) new Comparable[elementos.length*2];
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
            T[] novo = (T[]) new Comparable[elementos.length / 2];
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

    int valorInsercao = buscarIndiceOrdenado(valor);
    if (valorInsercao < 0){
        return;
    }

    inserir(valor, valorInsercao);

    }

    // usando a lógica da busca binária para determinar em que posição um elemento deve ir
    // ex com contato: 'Ana' e 'ana' devem ser posicionados na mesma posição
    private int buscarIndiceOrdenado(T valor){
        int inicio = 0;
        int fim = tamanhoPreenchido - 1;

        while (inicio<=fim){
            int meio = (inicio+fim) / 2;

            if (valor.compareTo(elementos[meio]) == 0){
                return meio; // elemento ja existe
            }

            if (valor.compareTo(elementos[meio]) > 0){
                inicio = meio+1;
            }

            else fim = meio - 1;
        }
        return inicio;
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
        IO.println("Adicionando elemento em " + index);
    }

    public int localizar(T elemento) {
        for (int i = 0; i < tamanhoPreenchido; i++) {
            if (elementos[i] != null && elementos[i].compareTo(elemento) == 0) {
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
            if (elementos[i].compareTo(valor) > 0) {
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
        elementosNovos = (T[]) new Comparable[tamanhoPreenchido];
        if (tamanhoPreenchido >= 0) System.arraycopy(elementos, 0, elementosNovos, 0, (tamanhoPreenchido));
        return elementosNovos;
    }

    public int obterTamanho(){
        return tamanhoPreenchido;
    }

    public void substituir(T o, int i) {
        elementos[i] = o;
    }
}