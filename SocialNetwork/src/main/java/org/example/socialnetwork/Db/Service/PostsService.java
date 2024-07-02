package org.example.socialnetwork.Db.Service;

import org.example.socialnetwork.Db.Posts;
import org.example.socialnetwork.Db.Repo.PostsRepo;
import org.example.socialnetwork.Db.Repo.UtenteRepo;
import org.example.socialnetwork.Db.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    @Autowired
    private PostsRepo postsRepo;

    @Autowired
    private UtenteRepo utenteRepo;

    public Posts creaPost(Posts posts) {
        return postsRepo.save(posts);
    }

    public List<Posts> findAll() {
        return postsRepo.findAll();
    }

    public void eliminaPost(int id) {
        postsRepo.deleteById(id);
    }

    public void aggiungiLike(int postId, int utenteId) {
        Optional<Posts> postOpt = postsRepo.findById(postId);
        Optional<Utente> utenteOpt = utenteRepo.findById(utenteId);

        if (postOpt.isPresent() && utenteOpt.isPresent()) {
            Posts post = postOpt.get();
            Utente utente = utenteOpt.get();
            post.aggiungiLike(utente);
            postsRepo.save(post);
        } else {
            throw new IllegalArgumentException("Post o Utente non trovato");
        }
    }
}
