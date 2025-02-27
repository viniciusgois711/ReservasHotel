package org.hotel.DB;


import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.Hospede;
import org.hotel.Filhas.QuartoSimples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hotel.DB.ConexaoDB.getConnection;

public class NotaFiscalDB {

    public Hospede buscarHospedePorId(int id){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from hospedes where id = ?")){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return new Hospede(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"));
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public QuartoSimples buscarQuartoPorId(int id){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from quartos where id = ?")){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return new QuartoSimples(rs.getInt("id"), rs.getString("numero"), rs.getDouble("valor"), rs.getString("ocupado"));
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public Reserva buscarReservaPorId(int id){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from reservas where id = ?")){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return new Reserva(rs.getInt("id"), rs.getInt("id_hospede"), rs.getInt("id_quarto"),rs.getDate("data_check_in"), rs.getDate("data_check_out"));
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
