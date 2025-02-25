package org.hotel.DB;

import org.hotel.Entidades.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.hotel.DB.ConexaoDB.getConnection;

public class ReservaDB {

    // Método para inserir uma reserva no banco de dados
    public void inserirReserva(Reserva reserva){
        // faz um statement para fazer a inserção a partir da conexão feita na classe ConexaoDB
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into reservas (id_hospede, id_quarto, data_check_in, data_check_out) values (?,?,?,?)")){
            // aloca os dados da reserva para a query de inserir
            statement.setInt(1, reserva.getId_hospede());
            statement.setInt(2, reserva.getId_quarto());
            statement.setDate(3, reserva.getDataChekIn());
            statement.setDate(4, reserva.getDataCheckOut());
            statement.executeUpdate();
        }catch(SQLException e){
            // caso aconteça algum erro, é printado
            // os erros podem ser desde a conexão com o banco, até mesmo dados errados
            // como por exemplo tentar criar uma reserva com o id_hospede que nao existe no banco ou id_quarto
            System.out.println(e);
        }
    }

    public List<Reserva> listarReservas(){
        List<Reserva> reservas = new ArrayList<>();

        try(Connection conexao = getConnection(); PreparedStatement statement = conexao.prepareStatement("select * from reservas")){

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int id_hospede = rs.getInt("id_hospede");
                int id_quarto = rs.getInt("id_quarto");
                Date data_check_in = rs.getDate("data_check_in");
                Date data_check_out = rs.getDate("data_check_out");
                Reserva reserva = new Reserva(id, id_hospede, id_quarto, data_check_in, data_check_out);
                reservas.add(reserva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return reservas;
    }

    public void editarReserva(int id, Reserva reserva){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("update reservas set id_hospede = ?, id_quarto = ?, data_check_in = ?, data_check_out = ? where id = ?")
        ){
            statement.setInt(1, reserva.getId_hospede());
            statement.setInt(2, reserva.getId_quarto());
            statement.setDate(3, reserva.getDataChekIn());
            statement.setDate(4, reserva.getDataCheckOut());
            statement.setInt(5, id);
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public void deletarReserva(int id){

        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("delete from reservas where id = ?")
        ){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }

    }

}
