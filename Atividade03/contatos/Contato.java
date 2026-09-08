package contatos;

public class Contato implements Comparable<Contato> {
    private String nome;
    private String telefones;
    private String email; // opcional a inclusão dessa informação pelo usuário

    public Contato(String nome, String telefones) {
        this.nome = nome;
        this.telefones = telefones;
        this.email = "E-mail não informado!";
    }

    @Override
    // recebe um contato e compara se é maior ou não com base no nome
    // exemplo: Aza < Ana, retorno deve ser -1
    // não diferencia maiúsculas de minúsculas
    public int compareTo(Contato o) {
        return this.nome.compareToIgnoreCase(o.getNome());
    }
    // recebe uma string (tem que ser o nome para funcionar como deveria)
    // e retorna um número dizendo se é maior ou não do que o nome desse
    // obj contato.
    // ex: Aza < Ana, o retorno deve ser -1
    public int compareTo(String busca) {
        return this.nome.compareToIgnoreCase(busca);
    }

    public Contato(String nome, String telefones, String email) {
        this.nome = nome;
        this.telefones = telefones;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Telefone: %s Email: %s", nome, telefones, email);
    }
}