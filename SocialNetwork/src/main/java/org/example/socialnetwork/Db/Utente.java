package org.example.socialnetwork.Db;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUtente;

    @Column(unique = true, nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 80)
    private String password;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 20)
    private String cognome;

    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Posts> posts = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "ListaAmici",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "amico_id")
    )
    private Set<Utente> amici = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "LikesPost",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
private Set<Posts> postPiaciuti = new HashSet<>();


    public Utente(){}
    public Utente(String email, String password, String nome, String cognome) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getIdUtente() {
        return IdUtente;
    }

    public void setIdUtente(int idUtente) {
        IdUtente = idUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }

    public Set<Utente> getAmici() {
        return amici;
    }

    public void setAmici(Set<Utente> amici) {
        this.amici = amici;
    }

    public Set<Posts> getPostPiaciuti() {
        return postPiaciuti;
    }

    public void setPostPiaciuti(Set<Posts> postPiaciuti) {
        this.postPiaciuti = postPiaciuti;
    }
}
