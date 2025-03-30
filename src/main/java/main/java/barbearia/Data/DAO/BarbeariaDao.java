package main.java.barbearia.Data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import main.java.barbearia.Data.DataConnection;
import main.java.barbearia.models.Barbearia;

public class BarbeariaDao {

    private final DataConnection dataConnection = new DataConnection();
    private final Connection connection = dataConnection.getConnection(); 

    private List<Barbearia> barbearia;


    public void addBarbearia(Barbearia barbearia) {
        String sql = "INSERT INTO barbearia (Nome, Email, WhatsApp, Profissional ) VALUES (?, ?, ?, ?)";
        
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, barbearia.getNome());
            preparedStatement.setString(2, barbearia.getEmail());
            preparedStatement.setString(3, barbearia.getWhatsApp());
            preparedStatement.setString(4, barbearia.getProfissional());
            
            preparedStatement.executeUpdate();
            System.out.println("Barbearia adicionada com sucesso!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  

    public void editarBarbearia(Barbearia barbearia){
        String sql = "UPDATE FROM barbearia SET Nome = ?, Email = ?, Whatsapp = ?, Profissional = ? ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, barbearia.getNome());
            preparedStatement.setString(2, barbearia.getEmail());
            preparedStatement.setString(3, barbearia.getWhatsApp());
            preparedStatement.setString(4, barbearia.getProfissional());

            preparedStatement.executeUpdate();
            System.out.println("Barbearia editada com Sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteBarbearia(Barbearia barbearia){
        String sql = "DELETE FROM barbearia WHERE nome=?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,barbearia.getNome());

        

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /*public List<Barbearia> getBarbearia(){
        String sql ="SELECT * FROM barbearia";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String nome = preparedStatement.getString("nome");
            String  email = preparedStatement.getString("email");
            String whatsApp = preparedStatement.getString("whatsApp");
            String profissional = preparedStatement.getString("profissional");

            Barbearia b = new Barbearia(nome, email, whatsApp, profissional);
            barbearia.cadastrarBarbearia(b);




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.barbearia;
    }*/
}