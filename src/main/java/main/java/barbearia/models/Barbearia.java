package main.java.barbearia.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.java.barbearia.Data.DAO.BarbeariaDao;

public class Barbearia {

    private int idCliente;
    private String nome, email, whatsapp, tipoCorte, profissional;
    private LocalDateTime dataHora;
    private boolean ativo;

    private static Barbearia instance = new Barbearia();

    public static Barbearia getInstance(){
        return instance;
    }

    public Barbearia(int idCliente, String nome, String email, String whatsApp,  String tipoCorte, String profissional, LocalDateTime dataHora, boolean ativo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.whatsapp = whatsApp;
        this.tipoCorte = tipoCorte;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.ativo = ativo;
    }

    public Barbearia(int idCliente, String nome, String email, String whatsApp,  String tipoCorte, String profissional, LocalDateTime dataHora) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.whatsapp = whatsApp;
        this.tipoCorte = tipoCorte;
        this.profissional = profissional;
        this.dataHora = dataHora;
    }

    public Barbearia(String nome, String email, String whatsApp,  String tipoCorte, String profissional, LocalDateTime dataHora) {
        this.nome = nome;
        this.email = email;
        this.whatsapp = whatsApp;
        this.tipoCorte = tipoCorte;
        this.profissional = profissional;
        this.dataHora = dataHora;
    }

    public Barbearia(){}

    public ArrayList<Barbearia> listarBarbearias() {
        try {
            BarbeariaDao daoBarbearia = new BarbeariaDao();
            return daoBarbearia.listarBarbearias();
        } catch (Exception e) {
            System.out.println("Erro ao listar barbearias: " + e.getMessage());
            return null;
        }
    }

    public boolean agendarCorte(String nome, String email, String whatsApp,  String tipoCorte, String profissional, LocalDateTime dataHora) {
        System.out.println("Agendando corte...");
        try{

            BarbeariaDao daoBarbearia = new BarbeariaDao();

            Barbearia barbearia = new Barbearia(nome, email, whatsApp,tipoCorte, profissional, dataHora);

            daoBarbearia.addBarbearia(barbearia);
    
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar barbearia: " + e.getMessage());
            return false;
        }
    }

    public boolean alterarCorte(int idCliente, String nome, String email, String whatsApp,  String tipoCorte, String profissional, LocalDateTime dataHora) {
        System.out.println("Alterando corte...");
        try{

            BarbeariaDao daoBarbearia = new BarbeariaDao();

            Barbearia barbearia = new Barbearia(idCliente, nome, email, whatsApp,tipoCorte, profissional, dataHora);

            daoBarbearia.editarBarbearia(barbearia);
    
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao alterar barbearia: " + e.getMessage());
            return false;
        }
    }

    public void cancelarCorte(int idCliente) {
        try {
            BarbeariaDao daoBarbearia = new BarbeariaDao();
            
            daoBarbearia.alterarStatusCorte(idCliente, false);
        } catch (Exception e) {
            System.out.println("Erro ao cancelar barbearia: " + e.getMessage());
        }
    }

    public void restaurarCorte(int idCliente) {
        try {
            BarbeariaDao daoBarbearia = new BarbeariaDao();
            daoBarbearia.alterarStatusCorte(idCliente, true);
        } catch (Exception e) {
            System.out.println("Erro ao restaurar barbearia: " + e.getMessage());
        }
    }
    public ArrayList<Barbearia> buscarCortePorNome(String nome) {
        ArrayList<Barbearia> barbearias = new ArrayList<>();
        try {
            BarbeariaDao daoBarbearia = new BarbeariaDao();
            barbearias = daoBarbearia.buscarCortePorNome(nome);
            return barbearias;
        } catch (Exception e) {
            System.out.println("Erro ao restaurar barbearia: " + e.getMessage());
            return null;
        }
    }
    public  ArrayList<Barbearia> buscarCortePorProfissional(String profissional) {
        ArrayList<Barbearia> barbearias = new ArrayList<>();
        try {
            BarbeariaDao daoBarbearia = new BarbeariaDao();
            barbearias = daoBarbearia.buscarCortePorProfissional(nome);
            return barbearias;
        } catch (Exception e) {
            System.out.println("Erro ao restaurar barbearia: " + e.getMessage());
            return null;
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getAtivo() {
        System.out.println("Ativo: " + ativo);
        return ativo ? "Sim" : "Não";
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Barbearia [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", whatsapp=" + whatsapp
                + ", tipoCorte=" + tipoCorte + ", profissional=" + profissional + ", dataHora=" + dataHora + ", ativo="
                + ativo + "]";
    }
}
