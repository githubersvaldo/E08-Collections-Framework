import java.util.Comparator;
import java.util.*;
public abstract class Conta implements ITaxas/*,Comparable*/{

    private int numero;

    protected Cliente dono;

    protected double saldo;

    private double limite;

    private List<Operacao> operacoes = new ArrayList<Operacao>();

    private int proximaOperacao = 0;

    private static int totalContas = 0;

    public Conta() {}
    public void sacar(double valor) {
        this.saldo -= valor;

        this.operacoes.add(new OperacaoSaque(valor));
        this.proximaOperacao++;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes.add(new OperacaoDeposito(valor));
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.numero + this.dono.toString() + this.saldo + this.limite;
    }
    @Override
    public boolean equals(Object obj) {
        return this.numero == ((Conta) obj).numero;
    }
    //1 Ordem padrão por data 2 ordenado por tipo
    public void imprimirExtrato(int ordem) {
        System.out.println("======= Extrato " + dono.getNome() + " ======");
        if(ordem == 1) {
            Collections.sort(operacoes,new Operacao.TipoComparator());
            for (Operacao atual : this.operacoes) {
                if (atual != null) {
                    System.out.println(atual.toString());
                }
            }

        }else if(ordem == 2) {
            Collections.sort(operacoes,new Operacao.TipoComparator2());
            for (Operacao atual : this.operacoes) {
                if (atual != null) {
                    System.out.println(atual.toString());
                }
            }
        }
        System.out.println("=======================");
    }
    public double calculaTaxas(){return 0;}
    public void imprimirExtratoTaxas(){
        double Total = calculaTaxas();
        System.out.printf("======= Extrato %s Taxas ======",dono.getNome());
        System.out.printf("Manutenção da conta: %.2f\n" ,this.calculaTaxas());
        System.out.printf("Operações\n");
        for(Operacao atual : this.operacoes) {
            if(atual.calculaTaxas() != 0) {
                System.out.printf("%s %.2f\n", atual.getTipo(), atual.calculaTaxas());
                Total += atual.calculaTaxas();
            }
        }
        this.saldo -= Total;
        System.out.printf("Total: %.2f\n", Total);
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public abstract boolean setLimite(double limite);
}
