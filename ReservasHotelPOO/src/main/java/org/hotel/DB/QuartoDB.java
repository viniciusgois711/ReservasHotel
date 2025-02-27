package org.hotel.DB;

import org.hotel.Entidades.Quarto;
import org.hotel.Entidades.Reserva;
import org.hotel.Filhas.QuartoSimples;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.hotel.DB.ConexaoDB.getConnection;

public class QuartoDB {

    public void inserirQuarto(Quarto quarto){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into quartos (numero, valor, ocupado) values (?, ?, ?)")){
            statement.setString(1, quarto.getNumero());
            statement.setDouble(2, quarto.getValor());
            statement.setString(3, quarto.isOcupado());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public List<Quarto> listarQuartos(){
        List<Quarto> quartos = new ArrayList<>();

        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("select * from quartos")
        ){

            ResultSet rs =  statement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String numero = rs.getString("numero");
                double valor = rs.getDouble("valor");
                String ocupado = rs.getString("ocupado");
                Quarto quarto = new QuartoSimples(id, numero, valor, ocupado);
                quartos.add(quarto);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return quartos;
    }

    public void editarQuarto(int id, Quarto quarto){
        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("update quartos set numero = ?, valor = ?, ocupado = ? where id = ?")
        ){
            statement.setString(1, quarto.getNumero());
            statement.setDouble(2, quarto.getValor());
            statement.setString(3, quarto.isOcupado());
            statement.setInt(4, id);
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public void deletarQuarto(int id){

        try(Connection conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("delete from quartos where id = ?")
        ){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }

    }
}
