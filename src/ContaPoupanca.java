public class ContaPoupanca extends Conta implements ITaxas {
    private double limite;
    ContaPoupanca(Cliente dono) {}
    @Override
    public boolean setLimite(double limite) {
        if(limite < 1000 && limite < 100){
            this.limite = limite;
            return true;
        }else return false;
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}
