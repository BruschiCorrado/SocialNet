package org.example.socialnetwork.Db.Service;

import org.example.socialnetwork.Db.ListaAmici;
import org.example.socialnetwork.Db.Repo.ListaAmiciRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaAmiciService {

    @Autowired
    private ListaAmiciRepo listaAmiciRepo;

    public ListaAmici aggiornaListaAmici(ListaAmici listaAmici) {
        return listaAmiciRepo.save(listaAmici);
    }
}
