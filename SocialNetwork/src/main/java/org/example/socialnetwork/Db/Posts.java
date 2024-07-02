package org.example.socialnetwork.Db;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPost;

    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Utente autore;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenuto;

    private LocalDateTime dataCreazione;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Commento> commenti = new HashSet<>();

    @ManyToMany (mappedBy = "postPiaciuti")
    private Set<Utente> utentiChePiacciono = new HashSet<>();

    public Posts(){
        this.dataCreazione = LocalDateTime.now();
    }

    public Posts(Utente autore, String contenuto) {
        this.autore = autore;
        this.contenuto = contenuto;
        this.dataCreazione = LocalDateTime.now();
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Set<Commento> getCommenti() {
        return commenti;
    }

    public void setCommenti(Set<Commento> commenti) {
        this.commenti = commenti;
    }

    public Set<Utente> getUtentiChePiacciono() {
        return utentiChePiacciono;
    }

    public void setUtentiChePiacciono(Set<Utente> utentiChePiacciono) {
        this.utentiChePiacciono = utentiChePiacciono;
    }

    public void aggiungiLike(Utente utente) {
        utentiChePiacciono.add(utente);
    }

    public void rimuoviLike(Utente utente) {
        utentiChePiacciono.remove(utente);
    }

    public int getNumeroLike() {
        return utentiChePiacciono.size();
    }

}



