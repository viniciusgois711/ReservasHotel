package org.hotel.Filhas;

import org.hotel.Entidades.Pessoa;

public class Hospede extends Pessoa {

    public Hospede(int id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    public Hospede(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }
}
