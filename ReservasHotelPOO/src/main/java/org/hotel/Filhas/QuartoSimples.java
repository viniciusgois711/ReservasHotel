package org.hotel.Filhas;

import org.hotel.Entidades.Quarto;

public class QuartoSimples extends Quarto {

    public QuartoSimples(String numero, double valor) {
        super(numero, valor);
    }

    public QuartoSimples(int id, String numero, double valor, String ocupado) {
        super(id, numero, valor, ocupado);
    }
}
