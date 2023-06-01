package it.develhope.gruppob.rubrica.models;

import java.math.BigInteger;

public class Contatto {

    private BigInteger id;
    private String nome;
    private String cognome;
    private String telefono;
    private Indirizzo indirizzo;
    private String email;

    public Contatto() {
    }

    public Contatto(String nome, String cognome, String telefono, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    /**
     * Metodo che imposta il nome del contatto
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        if (indirizzo == null) {
            return "\n☻ " + nome + " " + cognome + "\n☎ " + telefono + "\n";
        }
        return "\n☻ " + nome + " " + cognome + "\n☎ " + telefono + "\n☗ " + indirizzo;
    }

    public String toString1() {
        if (indirizzo == null) {
            return nome + "," + cognome + "," + telefono + "\n";
        }
        return nome + "," + cognome + "," + telefono + "," + indirizzo.toString1() + "\n";
    }
}
