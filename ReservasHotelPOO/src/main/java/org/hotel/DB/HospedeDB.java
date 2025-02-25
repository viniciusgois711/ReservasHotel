package org.hotel.DB;

import org.hotel.Filhas.Hospede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hotel.DB.ConexaoDB.getConnection;

public class HospedeDB {

    public void inserirHospede(Hospede hospede){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into hospedes (nome, cpf, telefone) values (?,?,?)")){
            statement.setString(1, hospede.getNome());
            statement.setString(2, hospede.getCpf());
            statement.setString(3, hospede.getTelefone());
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public List<Hospede> listarHospedes(){
        List<Hospede> hospedes = new ArrayList<>();
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from hospedes");
        ){
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                Hospede hospede = new Hospede(id, nome, cpf, telefone);
                hospedes.add(hospede);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return hospedes;
    }

}
