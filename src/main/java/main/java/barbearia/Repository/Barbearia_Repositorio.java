package main.java.barbearia.Repository;

import java.util.ArrayList;

import main.java.barbearia.models.Barbearia;
import main.java.barbearia.models.Cortes;

public class Barbearia_Repositorio { 

    Barbearia barbearia;
    Cortes cortes;

    ArrayList<Cortes> CortesAtivos;
    ArrayList<Cortes> CortesInativos;

    public Barbearia_Repositorio() {
        this.barbearia = new Barbearia();
        this.cortes = new Cortes();
        this.CortesAtivos = new ArrayList<>();
        this.CortesInativos = new ArrayList<>();

    }

    public boolean criarBarbearia(String nome, String email, String whatsApp,  String profissional){
        try {
          barbearia = new Barbearia(nome, email, whatsApp, profissional);
          return true;
        } catch (Exception e) {
          System.out.println("Erro ao criar barbearia: " + e.getMessage());
          return false;
        }   
    }

    public boolean agendarCorte(int idCliente, String nome, String email, String whatsApp, String tipoCorte, String dataHora, boolean ativo) {
        try {
               cortes.criarCorte(idCliente, nome, email, whatsApp, tipoCorte, dataHora, ativo);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao criar corte: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Cortes> buscarCortesAtivos() {
        return CortesAtivos = cortes.listarCortesAtivos();
    }
  
    public ArrayList<Cortes> buscarCortesInativos() {
        return CortesInativos = cortes.listarCortesInativos();
    }

    public void alterarCorte(int idCliente, String nome, String email, String whatsApp, String tipoCorte, String dataHora, boolean ativo){
        try {
            cortes.alterarCorte(idCliente, nome, email, whatsApp, tipoCorte, dataHora, ativo);
        } catch (Exception e) {
            System.out.println("Erro ao alterar corte: " + e.getMessage());
        }
    }

    public ArrayList<Cortes> listarCortesAtivos() {

        CortesAtivos = buscarCortesAtivos();

        ArrayList<Cortes> ct = new ArrayList<>();

        for (Cortes corte : CortesAtivos) {
            if (corte.isAtivo()) {
                ct.add(corte);
            }
        }

        return ct;
    }
}
