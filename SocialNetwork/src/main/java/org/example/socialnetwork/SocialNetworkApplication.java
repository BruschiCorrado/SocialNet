package org.example.socialnetwork;


import org.example.socialnetwork.Db.Service.UtenteService;
import org.example.socialnetwork.Db.Repo.UtenteRepo;
import org.example.socialnetwork.Db.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SocialNetworkApplication implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteRepo utenteRepo;

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Utente marco = new Utente("abc@gmail.com", "1234", "luca", "rossi");
        utenteRepo.save(marco);

        Utente luca = new Utente("def@gmail.com", "1234", "marco", "verdi");
        utenteRepo.save(luca);
    }
}
