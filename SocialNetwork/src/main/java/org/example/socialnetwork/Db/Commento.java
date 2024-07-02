package org.example.socialnetwork.Db;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Commento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCommento;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente autore;

    @ManyToOne
    @JoinColumn(name = "posts_id", nullable = false)
    private Posts posts;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenuto;

    private LocalDateTime dataCreazione;

    public Commento(){
        this.dataCreazione = LocalDateTime.now();
    }

    public Commento(Utente autore, Posts posts,
                    String contenuto) {
        this.autore = autore;
        this.posts = posts;
        this.contenuto = contenuto;
        this.dataCreazione = LocalDateTime.now();
    }

    public int getIdCommento() {
        return IdCommento;
    }

    public void setIdCommento(int idCommento) {
        IdCommento = idCommento;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
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
}




