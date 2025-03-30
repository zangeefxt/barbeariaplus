package main.java.barbearia.models;

import java.util.ArrayList;

import main.java.barbearia.Data.DAO.BarbeariaDao;

public class Barbearia {

    private int idClient;
    private String nome, email, whatsApp, tipoCorte, profissional, dataHora;
    private boolean ativo;
    private ArrayList<Barbearia> barbearias;

    public Barbearia( String nome, String email, String whatsApp,  String profissional) {
        this.nome = nome;
        this.email = email;
        this.whatsApp = whatsApp;
        this.profissional = profissional;
        this.barbearias = new ArrayList<>();
    }
    public Barbearia(){
       // Construtor padrão 
    }

    public Barbearia(String nome ) {
        this.nome = nome;
        this.barbearias = new ArrayList<>();
    }

    

    public boolean cadastrarBarbearia(String nome, String email, String whatsApp, String profissional) {
        try{

            BarbeariaDao daoBarbearia = new BarbeariaDao();

            Barbearia barbearia = new Barbearia(nome, email, whatsApp, profissional);

            daoBarbearia.addBarbearia(barbearia);
    
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar barbearia: " + e.getMessage());
            return false;
        }
    }

    public boolean agendarCorte(String nome, String email, String whatsApp, String tipoCorte, String profissional, String dataHora) {
        return true;
    }

    public int getidCliente() {
        return idClient;
    }

    public void setidCliente(int idClient) {
        this.idClient = idClient;
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

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString(){
        String str = "\nNome: "+nome+"\nEmail: "+email+"\nWhatsApp: "+whatsApp+"\nTipo de Corte: "+tipoCorte+"\nProfissional: "+profissional+"\nData e Hora: "+dataHora;

        return str;
    }
}
