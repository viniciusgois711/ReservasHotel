package org.hotel;

import org.hotel.DB.HospedeDB;
import org.hotel.DB.ReservaDB;
import org.hotel.Entidades.Quarto;
import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.Hospede;
import org.hotel.DB.QuartoDB;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private ArrayList<Quarto> quartos = new ArrayList<>();
    private ArrayList<Hospede> hospedes = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    ReservaDB reservaDB = new ReservaDB();
    HospedeDB hospedeDB = new HospedeDB();
    QuartoDB quartoDB = new QuartoDB();



    public Hotel(String nome) {
        this.nome = nome;
    }


    public void addQuartoSimples(Quarto quarto){
        quartos.add(quarto);
    }

    public void addQuartoLuxo(Quarto quarto){
        quartoDB.inserirQuarto(quarto);
    }

    public List<Quarto> listarQuartos(){
        return quartoDB.listarQuartos();
    }

    public void addHospede(Hospede hospede){
        hospedeDB.inserirHospede(hospede);
    }

    public List<Hospede> listarHospedes(){
        return hospedeDB.listarHospedes();
    }

    public void addReserva(Reserva reserva){
        reservaDB.inserirReserva(reserva);
    }

    public void editarReserva(int id, Reserva reserva){
        reservaDB.editarReserva(id, reserva);
    }

    public void deletarReserva(int id){
        reservaDB.deletarReserva(id);
    }

    public List<Reserva> listarReservas(){
        return reservaDB.listarReservas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nome='" + nome + '\'' +
                ", quartos=" + quartos +
                ", hospedes=" + hospedes +
                ", reservas=" + reservas +
                '}';
    }
}
