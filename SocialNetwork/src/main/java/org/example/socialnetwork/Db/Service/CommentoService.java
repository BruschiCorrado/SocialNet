package org.example.socialnetwork.Db.Service;

import org.example.socialnetwork.Db.Commento;
import org.example.socialnetwork.Db.Repo.CommentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentoService {

    @Autowired
    private CommentoRepo commentoRepo;

    public Commento aggiungiCommento(Commento commento){
        return commentoRepo.save(commento);
    }

    public List<Commento> findAll() {
        return commentoRepo.findAll();
    }

    public void eliminaCommento(int id) {
        commentoRepo.deleteById(id);
    }
}
