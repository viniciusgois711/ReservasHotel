package org.hotel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hotel.DB.NotaFiscalDB;
import org.hotel.Entidades.Quarto;
import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.Hospede;
import org.hotel.Filhas.QuartoSimples;

public class NotaFiscal implements Pagamento {
    private double valorTotal;
    private NotaFiscalDB nf = new NotaFiscalDB();

    public double calcularValorTotal(Reserva reserva, Quarto quarto){
        long diferencaMiliseg = reserva.getDataCheckOut().getTime() - reserva.getDataChekIn().getTime();
        long diarias = TimeUnit.MILLISECONDS.toDays(diferencaMiliseg);
        this.valorTotal = diarias* quarto.getValor();
        return valorTotal;
    }
    public void exibirNota(int id_reserva){
        Reserva reserva = nf.buscarReservaPorId(id_reserva);
        Hospede hospede = nf.buscarHospedePorId(reserva.getId_hospede());
        QuartoSimples quarto = nf.buscarQuartoPorId(reserva.getId_quarto());

        this.calcularValorTotal(reserva, quarto);
        System.out.println("--------------Nota Fiscal--------------");
        System.out.println("");
        System.out.println("--------------Hóspede--------------");
        System.out.print("Nome: " + hospede.getNome() + " ");
        System.out.print("CPF: " + hospede.getCpf() + " ");
        System.out.println("Telefone: " + hospede.getTelefone() + " ");
        System.out.println("--------------Quarto--------------");
        System.out.println("Número: " + quarto.getNumero() + " ");
        System.out.println("Valor: " + quarto.getValor() + " ");
        System.out.println("--------------Reserva--------------");
        System.out.println("Data CheckIn: " + reserva.getDataChekIn() + " ");
        System.out.println("Data CheckOut: " + reserva.getDataCheckOut() + " ");
        System.out.println("-----------------------------------");
        System.out.println("Valor a ser pago: " + this.valorTotal);
        System.out.println("-----------------------------------");
    }
}
