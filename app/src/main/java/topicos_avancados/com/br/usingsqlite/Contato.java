package topicos_avancados.com.br.usingsqlite;

/**
 * Created by PedroPaulo on 02/03/17.
 */

public class Contato {
    int _id;
    String nome;
    String telefone;

    public Contato() { }

    public Contato(int id, String nome, String telefone) {
        this._id = id;
        this.nome = nome;
        this.telefone = telefone;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
