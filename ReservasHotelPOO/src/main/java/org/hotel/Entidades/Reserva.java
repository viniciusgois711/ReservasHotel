package org.hotel.Entidades;

import java.sql.Date;

public class Reserva {
    private int id;
    private int id_hospede;
    private int id_quarto;
    private Date dataChekIn;
    private Date dataCheckOut;

    public Reserva(int id_hospede, int id_quarto, Date dataChekIn, Date dataCheckOut) {
        this.id_hospede = id_hospede;
        this.id_quarto = id_quarto;
        this.dataChekIn = dataChekIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Reserva(int id, int id_hospede, int id_quarto, Date dataChekIn, Date dataCheckOut) {
        this.id = id;
        this.id_hospede = id_hospede;
        this.id_quarto = id_quarto;
        this.dataChekIn = dataChekIn;
        this.dataCheckOut = dataCheckOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hospede() {
        return id_hospede;
    }

    public void setId_hospede(int id_hospede) {
        this.id_hospede = id_hospede;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public Date getDataChekIn() {
        return dataChekIn;
    }

    public void setDataChekIn(Date dataChekIn) {
        this.dataChekIn = dataChekIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}
