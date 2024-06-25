import java.util.Date;

public class PessoaFisica extends Cliente {

    private String cpf;

    private int idade;

    private char genero;

    public PessoaFisica(String nome, String endereco, Date data, String cpf, int idade, char genero) {
        super(nome, endereco, data);
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return this.getNome() + "\n" + this.getData() + "\n" + this.getEndereco() + "\n" + cpf + "\n" + idade + "\n" + genero + "\n";
    }
    @Override
    public boolean autenticar(String chave) {
        if(this.getCpf().equals(chave)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.cpf.equals(((PessoaFisica) obj).cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
