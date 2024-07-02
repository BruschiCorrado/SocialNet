package org.example.socialnetwork.Db.Repo;

import org.example.socialnetwork.Db.ListaAmici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaAmiciRepo extends JpaRepository<ListaAmici, Integer> {


}
