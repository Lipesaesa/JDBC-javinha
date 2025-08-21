public class Categoria {
    public class Produto {

    private int id;
    private String nome;
    private boolean ativo;
    
    public Produto(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
    //Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getativo() {
        return ativo;
    }

    public void setativo(boolean ativo) {
        this.ativo = ativo;
    }

}
}
