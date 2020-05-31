package com.danilorocha.sistema.bancario;
/**
 *
 * @author danilorocha
 */
import java.util.ArrayList;
import java.util.List;

public class Conta implements Cadastro {
    private long id;
    private String numero;
    private boolean poupanca;
    private boolean especial;
    private double saldo;
    private double limite;
    private final List<Movimentacao> movimentacoes = new ArrayList<>();

    public Conta() {
    }

    public Conta(final Agencia agencia, final boolean especial, final double limite) {
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void addMovimentacao(final Movimentacao movimentacao) {
    }

    public double getSaldoTotal() {
        return 0.0d;
    }

    public void saque(final double valor) {
        saldo -= valor;
    }

    public void depositoEnvelope(final double valor) {
    }

    public void depositoCheque(final double valor) {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(final long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(final String numero) {
        if (!numero.matches("\\d{5}-\\d") || "".equals(numero)) {            
                throw new IllegalArgumentException("Número inválido. Deve estar no formato 99999-9");
        }       
        this.numero = numero;
    }

    public boolean isPoupanca() {
        return poupanca;
    }

    public void setPoupanca(final boolean poupanca) {
        this.poupanca = poupanca;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(final boolean especial) {
        this.especial = especial;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(final double limite) {
        if(!especial && limite > 0) {
            throw new IllegalStateException("Somente contas especiais podem ter limites");
        }
        this.limite = limite;
    }
}
