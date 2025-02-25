package org.hotel.Entidades;


// Classe abstrata que será usada na criação dos quarto
public abstract class Quarto {
    private int id;
    private String numero;
    private double valor;
    private String ocupado;

    // construtor
    public Quarto(String numero, double valor) {
        this.numero = numero;
        this.valor = valor;
        this.ocupado = "Livre";
    }

    public Quarto(int id, String numero, double valor, String ocupado) {
        this.id = id;
        this.numero = numero;
        this.valor = valor;
        this.ocupado = ocupado;
    }

    // getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOcupado() {
        return ocupado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String isOcupado() {
        return ocupado;
    }

    public void setOcupado(String ocupado) {
        this.ocupado = ocupado;
    }
}
