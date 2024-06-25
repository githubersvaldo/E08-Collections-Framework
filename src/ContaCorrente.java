public class ContaCorrente extends Conta implements ITaxas {
    private double limite;
    int[] teste ={1,2,3,4};

    ContaCorrente(Cliente donos) {
        this.dono = donos;
    }

    public int[] getTeste() {
        return teste;
    }

    public void setTeste(int[] teste) {
        this.teste = teste;
    }


    @Override
    public boolean setLimite(double limite) {
        if(limite > -100){
            this.limite = limite;
            return true;
        }else return false;
    }
    @Override
    public double calculaTaxas(){
        if(this.dono instanceof PessoaFisica ) {
            return 10;
        }
        else if (this.dono instanceof PessoaJuridica ) {
            return 20;
        }
        else return 0; //codigo de erro
    }
}
