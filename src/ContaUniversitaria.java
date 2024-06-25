public class ContaUniversitaria extends Conta implements ITaxas{
    private double limite;
    ContaUniversitaria(Cliente dono) {}
    @Override
    public boolean setLimite(double limite) {
        if(limite > 0 && limite < 500){
            this.limite = limite;
            return true;
        }else return false;
    }
    @Override
    public double calculaTaxas() {
        return 0;
    }
}
