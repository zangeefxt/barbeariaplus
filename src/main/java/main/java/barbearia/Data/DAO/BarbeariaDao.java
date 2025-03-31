package main.java.barbearia.Data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.barbearia.Data.DataConnection;
import main.java.barbearia.Models.Barbearia;

public class BarbeariaDao {

    private final DataConnection dataConnection = new DataConnection();
    private final Connection connection = dataConnection.getConnection(); 

    public void addBarbearia(Barbearia barbearia) {
        String sql = "INSERT INTO BARBEARIA_barbearia (nome, email, whatsapp, tipoCorte, profissional, dataHora, ativo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {    
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, barbearia.getNome());
            preparedStatement.setString(2, barbearia.getEmail());
            preparedStatement.setString(3, barbearia.getWhatsapp());
            preparedStatement.setString(4, barbearia.getTipoCorte());
            preparedStatement.setString(5, barbearia.getProfissional());
            preparedStatement.setTimestamp(6, java.sql.Timestamp.valueOf(barbearia.getDataHora()));
            preparedStatement.setBoolean(7,false);
            
            preparedStatement.executeUpdate();
            System.out.println("Barbearia adicionada com sucesso!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  

    public void editarBarbearia(Barbearia barbearia){
        String sql = "UPDATE BARBEARIA_barbearia SET nome = ?, email = ?, whatsapp = ?, tipoCorte = ?, profissional = ? WHERE idCliente = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            System.out.println("Editando barbearia: " + barbearia.toString());

            preparedStatement.setString(1, barbearia.getNome());
            preparedStatement.setString(2, barbearia.getEmail());
            preparedStatement.setString(3, barbearia.getWhatsapp());
            preparedStatement.setString(4, barbearia.getTipoCorte());
            preparedStatement.setString(5, barbearia.getProfissional());
            preparedStatement.setInt(6, barbearia.getIdCliente());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarStatusCorte(int idCliente, Boolean ativo) {
        String sql = "UPDATE BARBEARIA_barbearia SET ativo = ? WHERE idCliente = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, ativo);
            preparedStatement.setInt(2, idCliente);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Barbearia> buscarCortePorNome(String nome){
        String sql = "SELECT * FROM BARBEARIA_barbearia WHERE nome = ?";
        ArrayList<Barbearia> barbearias = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Barbearia barbearia = new Barbearia(
                    resultSet.getInt("idCliente"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("whatsapp"),
                    resultSet.getString("tipoCorte"),
                    resultSet.getString("profissional"),
                    resultSet.getTimestamp("dataHora").toLocalDateTime(),
                    resultSet.getBoolean("ativo")
                );
                barbearias.add(barbearia);
            }

            return barbearias;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Barbearia> buscarCortePorProfissional(String profissional){
        String sql = "SELECT * FROM BARBEARIA_barbearia WHERE profissional = ?";
        ArrayList<Barbearia> barbearias = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, profissional);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Barbearia barbearia = new Barbearia(
                    resultSet.getInt("idCliente"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("whatsapp"),
                    resultSet.getString("tipoCorte"),
                    resultSet.getString("profissional"),
                    resultSet.getTimestamp("dataHora").toLocalDateTime(),
                    resultSet.getBoolean("ativo")
                );
                barbearias.add(barbearia);
            }

            return barbearias;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

 public ArrayList<Barbearia> listarBarbearias() {
        ArrayList<Barbearia> barbearias = new ArrayList<>();
        String sql = "SELECT * FROM BARBEARIA_barbearia";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Barbearia barbearia = new Barbearia(
                    resultSet.getInt("idCliente"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("whatsapp"),
                    resultSet.getString("tipoCorte"),
                    resultSet.getString("profissional"),
                    resultSet.getTimestamp("dataHora").toLocalDateTime(),
                    resultSet.getBoolean("ativo")
                );
                barbearias.add(barbearia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barbearias;
    }

}