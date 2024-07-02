package org.example.socialnetwork.Db.Repo;

import org.example.socialnetwork.Db.Commento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentoRepo extends JpaRepository<Commento, Integer> {

}
