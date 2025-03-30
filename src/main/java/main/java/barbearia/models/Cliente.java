package main.java.barbearia.models;

public class Cliente {
    private String nome, email, cpf, whatsApp;

    public Cliente(String nome, String email, String cpf, String whatsApp) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.whatsApp = whatsApp;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nEmail: " + this.email + "\nCPF: " + this.cpf + "\nWhatsApp: " + this.whatsApp;
    }
}



