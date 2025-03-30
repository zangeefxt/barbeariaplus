package main.java.barbearia.Data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.barbearia.Data.DataConnection;
import main.java.barbearia.models.Cortes;


public class CortesDao {

    private final DataConnection dataConnection = new DataConnection();
    private final Connection connection = dataConnection.getConnection();


    public void AdicionarCorte(Cortes corte) {
        String sql = "INSERT INTO cortes (idClient, Nome, Email, WhatsApp, TipoCorte, DataHora, Ativo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {    
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
           
            preparedStatement.setInt(1, corte.getIdCliente());
            preparedStatement.setString(2, corte.getNome());
            preparedStatement.setString(3, corte.getEmail());
            preparedStatement.setString(4, corte.getWhatsApp());
            preparedStatement.setString(5, corte.getTipoCorte());
            preparedStatement.setString(6, corte.getDataHora());
            preparedStatement.setBoolean(7, corte.isAtivo());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("Corte adicionado com sucesso!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cortes> getCortesAtivos(){
            String sql = "SELECT * FROM cortes WHERE Ativo = true";
            
            try {    
                ArrayList<Cortes> cortesAtivos = new ArrayList<>();
                
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                var rs = preparedStatement.executeQuery();

                while (rs.next()){
                    Cortes ct = new Cortes(rs.getInt("idClient"),rs.getString("Nome"), rs.getString("Email"), rs.getString("WhatsApp"), rs.getString("TipoCorte"), rs.getString("DataHora"), rs.getBoolean("Ativo"));
                    cortesAtivos.add(ct);

                    System.out.println(ct.getNome());
                }

            System.out.println(cortesAtivos);

            return cortesAtivos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cortes getCorteByProfissional(String profissional){
        String sql = "SELECT * FROM cortes WHERE Profissional = ?";
        
        try {    
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, profissional);
            
            var rs = preparedStatement.executeQuery();

            while (rs.next()){
                Cortes ct = new Cortes(rs.getInt("idCliente"),rs.getString("Nome"), rs.getString("Email"), rs.getString("WhatsApp"), rs.getString("TipoCorte"), rs.getString("DataHora"), rs.getBoolean("Ativo"));
                return ct;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void restaurarCorte(String nome){
        String sql = "UPDATE cortes SET Ativo = true WHERE Nome = ?";
        
        try {    
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Corte restaurado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelarCorte(){
        String sql = "UPDATE cortes SET Ativo = false WHERE idClient = ?";
        
        try {    
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("Corte cancelado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cortes getCorteByNome(String nome){
        String sql = "SELECT * FROM cortes WHERE Nome = ?";
        
        try {    
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            
            var rs = preparedStatement.executeQuery();

            if (rs.next()){
                Cortes ct = new Cortes(rs.getInt("idCliente"),rs.getString("Nome"), rs.getString("Email"), rs.getString("WhatsApp"), rs.getString("TipoCorte"), rs.getString("DataHora"), rs.getBoolean("Ativo"));
                return ct;
            }

            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Cortes> getCortesInativos(){
        String sql = "SELECT * FROM cortes WHERE Ativo = 0";
        
        try {    
            ArrayList<Cortes> cortesInativos = new ArrayList<>();
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            var rs = preparedStatement.executeQuery();

            while (rs.next()){
                Cortes ct = new Cortes(rs.getInt("idCliente"),rs.getString("Nome"), rs.getString("Email"), rs.getString("WhatsApp"), rs.getString("TipoCorte"), rs.getString("DataHora"), rs.getBoolean("Ativo"));
                cortesInativos.add(ct);
            }

            return cortesInativos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
    }

    public void alterarCorte(Cortes corte){
        String sql = "UPDATE cortes SET Nome = ?, Email = ?, WhatsApp = ?, TipoCorte = ?, DataHora = ? WHERE idClient = ?";
        
        try {        
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
           
            preparedStatement.setString(1, corte.getNome());
            preparedStatement.setString(2, corte.getEmail());
            preparedStatement.setString(3, corte.getWhatsApp());
            preparedStatement.setString(4, corte.getTipoCorte());
            preparedStatement.setString(5, corte.getDataHora());
            preparedStatement.setInt(6, corte.getIdCliente());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("Corte alterado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
