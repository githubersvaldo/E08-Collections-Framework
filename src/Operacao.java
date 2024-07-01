/**
 * Operacao.java
 *
 * @author João Eduardo Montandon
 */

import java.util.Comparator;
import java.util.Date;

import static java.lang.String.valueOf;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao implements ITaxas {

    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;

    private static int totalOperacoes = 0;

    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     *
     * Exemplos de uso:
     *
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     * @param tipo Tipo da operação, podendo ser 'd' ou 's'
     * @param valor Valor da operação
     */
    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();

        Operacao.totalOperacoes++;
    }
    @Override
    public String toString() {
        return this.data + " " + this.tipo + " " + valueOf(this.valor);
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        if(this.tipo == 'd'){
            return "Deposito";
        }else{return "Saque";}
    }

    public double getValor() {
        return valor;
    }

    public static int getTotalOperacoes() {
        return Operacao.totalOperacoes;
    }

    public void setTipo(char tipo) {
        if(tipo == 'd' || tipo == 's')
            this.tipo = tipo;
    }
    //compara as operação com o tipo de operação como referencia
    public static class TipoComparator2 implements Comparator<Operacao> {
        @Override
        public int compare(Operacao o1, Operacao o2) {
            return Integer.compare(o1.tipo, o2.tipo);
        }
    }
    //compara as operação com a data da operação como referencia
    public static class TipoComparator implements Comparator<Operacao> {
        @Override
        public int compare(Operacao o1, Operacao o2) {
            return o1.data.compareTo(o2.data);
        }
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}