package main.java.barbearia.models;

import java.util.ArrayList;

import main.java.barbearia.Data.DAO.CortesDao;
import java.util.ArrayList;

public class Cortes {

    CortesDao cortesDao = new CortesDao();
    
    private int idCliente;
    private String nome;
    private String email;
    private String whatsApp;
    private String tipoCorte;
    private String dataHora;
    private boolean ativo;
    private ArrayList <Cortes> cortes;

    public Cortes(int idCliente, String nome, String email, String whatsApp, String tipoCorte, String dataHora, boolean ativo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.whatsApp = whatsApp;
        this.tipoCorte = tipoCorte;
        this.dataHora = dataHora;
        this.ativo = ativo;
        this.cortes = new ArrayList<>();
    } 

    public Cortes() {
        // Construtor vazio
    }

    public void criarCorte(int idCliente, String nome, String email, String whatsApp, String tipoCorte, String dataHora, boolean ativo) {
      Cortes corte = new Cortes(idCliente, nome, email, whatsApp, tipoCorte, dataHora, ativo);
      cortesDao.AdicionarCorte(corte);
    }

    public ArrayList<Cortes> listarCortesAtivos() {
        return cortesDao.getCortesAtivos();
    }

    public ArrayList<Cortes> listarCortesInativos() {
        return cortesDao.getCortesInativos();
    }

    public void alterarCorte(int idCliente, String nome, String email, String whatsApp, String tipoCorte, String dataHora, boolean ativo){
        Cortes ct = new Cortes(idCliente, nome, email, whatsApp, tipoCorte, dataHora, ativo);
        cortesDao.alterarCorte(ct);
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
}
