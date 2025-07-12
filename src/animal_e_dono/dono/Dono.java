package animal_e_dono.dono;

public class Dono{
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;

    public Dono(int id, String nome, String telefone, String endereco,String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    
    public void atualizarCadastro(String telefone, String endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public void atualizarCadastro(int id,String nome,String telefone, String endereco) {
        this.id=id;
        this.nome=nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public String consultarDonos() {
        return "Dono: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
    public String getCpf(){
        return cpf;
    }


}