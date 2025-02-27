package org.hotel.Filhas;

import org.hotel.Entidades.Quarto;

public class QuartoLuxo extends Quarto {

    public QuartoLuxo(String numero, double valor) {
        super(numero, valor);
    }

    public QuartoLuxo(int id, String numero, double valor, String ocupado) {
        super(id, numero, valor, ocupado);
    }
}
