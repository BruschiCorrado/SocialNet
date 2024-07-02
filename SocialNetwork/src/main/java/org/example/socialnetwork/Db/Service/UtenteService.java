package org.example.socialnetwork.Db.Service;

import org.example.socialnetwork.Db.Repo.UtenteRepo;
import org.example.socialnetwork.Db.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public Optional<Utente> login(String email, String password) {
        return utenteRepo.findByEmailAndPassword(email, password);
    }

    public Optional<Utente> findByEmail(String email) {
        return utenteRepo.findByEmail(email);
    }

    public Optional<Utente> findByEmailAndPassword(String email, String password) {
        return utenteRepo.findByEmailAndPassword(email, password);
    }

    public Optional<Utente> findByNomeAndCognome(String nome,
                                                 String cognome){
        return utenteRepo.findByNomeAndCognome(nome, cognome);
    }

    public List<Utente> findAll(){
        return utenteRepo.findAll();
    }


    public Utente aggiornaUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    public void aggiungiAmico(int utenteId, int amicoId) {
        Optional<Utente> utente = utenteRepo.findById(utenteId);
        Optional<Utente> amico = utenteRepo.findById(amicoId);

        if (utente.isPresent() && amico.isPresent()) {
            utente.get().getAmici().add(amico.get());
            amico.get().getAmici().add(utente.get());
            utenteRepo.save(utente.get());
            utenteRepo.save(amico.get());
        }
    }

    public void rimuoviAmico(int utenteId, int amicoId) {
        Optional<Utente> utente = utenteRepo.findById(utenteId);
        Optional<Utente> amico = utenteRepo.findById(amicoId);

        if (utente.isPresent() && amico.isPresent()) {
            utente.get().getAmici().remove(amico.get());
            amico.get().getAmici().remove(utente.get());
            utenteRepo.save(utente.get());
            utenteRepo.save(amico.get());
        }
    }

    public void creaUtente(Utente utente) {
        utenteRepo.save(utente);
    }


}
