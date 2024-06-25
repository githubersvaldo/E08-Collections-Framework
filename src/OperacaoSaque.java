public class OperacaoSaque extends Operacao implements ITaxas{

    public OperacaoSaque(double valor) {
        super('s', valor);
    }
    @Override
    public double calculaTaxas() {
        return 0.05;
    }
}
