package org.example.socialnetwork.Db;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ListaAmici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaAmici;

    @OneToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToMany
    @JoinTable(
            name = "amicizie",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "amico_id")
    )
    private Set<Utente> amici = new HashSet<>();

    //COSTRUTTORI
    public ListaAmici(){

    }

    public ListaAmici(Utente utente) {
        this.utente = utente;
    }
}
