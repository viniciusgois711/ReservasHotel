package org.hotel;

import org.hotel.Entidades.Quarto;
import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.Hospede;

public interface Pagamento {

    public double calcularValorTotal(Reserva reserva, Quarto quarto);
    public void exibirNota(int id_reserva);

}
