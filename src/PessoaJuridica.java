import java.util.Date;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    private int numFuncionarios;

    private String setor;

    public PessoaJuridica(String nome, String endereco, Date data, String cnpj, int numFuncionarios, String setor) {
        super(nome, endereco, data);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }

    @Override
    public String toString() {
        return this.getNome() + "\n" + this.getData() + "\n" + this.getEndereco() + "\n" + cnpj + "\n" + numFuncionarios + "\n" + setor + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        return cnpj.equals(((PessoaJuridica) obj).getCnpj());
    }

    @Override
    public boolean autenticar(String chave) {
        if(this.getCnpj().equals(chave)) {
            return true;
        }else {
            return false;
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}

