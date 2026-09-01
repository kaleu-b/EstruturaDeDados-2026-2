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
    public int compareTo(Contato o) {
        return this.nome.compareToIgnoreCase(o.getNome());
    }

    public int compareTo(String busca){
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
}