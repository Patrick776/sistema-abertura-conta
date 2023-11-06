package CadastroPessoa;

public class Conta {
    private int numero;
    private double saldo;
    private Conta (int nunmero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor){
        saldo -= valor;
    }

    public String toString(){
        return numero + "saldo: " + saldo;
    }
}