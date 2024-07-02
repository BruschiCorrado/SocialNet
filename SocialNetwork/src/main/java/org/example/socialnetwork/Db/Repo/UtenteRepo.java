package org.example.socialnetwork.Db.Repo;

import org.example.socialnetwork.Db.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {

   Optional<Utente> findByEmailAndPassword(String email, String password);

   Optional<Utente> findByEmail(String email);

   Optional<Utente> findByNomeAndCognome(String nome, String cognome);
}
