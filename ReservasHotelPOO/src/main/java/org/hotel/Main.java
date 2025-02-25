package org.hotel;

import org.hotel.Entidades.Quarto;
import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.Hospede;
import org.hotel.Filhas.QuartoLuxo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("HotelPOO");

        // Quarto

        QuartoLuxo quartoObj = new QuartoLuxo("100", 500.00, false);
        hotel.addQuartoLuxo(quartoObj);
        List<Quarto> quartos = hotel.listarQuartos();

        // Reservas

        Reserva reservaObj = new Reserva(2, 1, Date.valueOf("2024-01-01"), Date.valueOf("2024-01-05"));
        //hotel.addReserva(reservaObj);
        List<Reserva> reservas = new ArrayList<>();
        reservas = hotel.listarReservas();
        //hotel.deletarReserva(4);
        //hotel.editarReserva(4, reservaObj);


        // Hospedes

        //Hospede hospedeObj = new Hospede("vinicius", "22222", "9999999");
        //hotel.addHospede(hospedeObj);
        List<Hospede> hospedes = new ArrayList<>();
        hospedes = hotel.listarHospedes();



        for(Quarto quarto : quartos){
            System.out.print("id quarto: " + quarto.getId() + " ");
            System.out.print("numero: " + quarto.getNumero() + " ");
            System.out.print("valor: " + quarto.getValor() + " ");
            System.out.println("ocupado? " + quarto.isOcupado() + " ");
        }

        System.out.println("-------------------------------");

        for(Hospede hospede : hospedes){
            System.out.print("id hospede: " + hospede.getId() + " ");
            System.out.print("nome: " + hospede.getNome() + " ");
            System.out.print("cpf: " + hospede.getCpf() + " ");
            System.out.println("telefone: " + hospede.getTelefone() + " ");
        }

        System.out.println("-------------------------------");


        // listar reservas
        for(Reserva reserva : reservas){
            System.out.print("id: " + reserva.getId() + " ");
            System.out.print("id_hospede: " + reserva.getId_hospede() + " ");
            System.out.print("id_quarto: " + reserva.getId_quarto() + " ");
            System.out.print("data In: " + reserva.getDataChekIn() + " ");
            System.out.println("data Out: " + reserva.getDataCheckOut() + " ");
        }

        System.out.println(hotel.toString());
    }
}