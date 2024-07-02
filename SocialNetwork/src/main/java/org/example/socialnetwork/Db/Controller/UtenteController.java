package org.example.socialnetwork.Db.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.socialnetwork.Db.Service.UtenteService;
import org.example.socialnetwork.Db.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
//@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

//    @GetMapping
//    public String getAllUsers(Model model) {
//        List<Utente> users = utenteService.findAll();
//        model.addAttribute("users", users);
//        for (Utente user : users){
//            System.out.println("utente: " + user.getIdUtente());
//        }


//        return "/ShowAllUsers";
//    }

    @GetMapping("/registrazione")
    public String showRegistrazioneForm(Model model){
        model.addAttribute("utente", new Utente());
        return "/registrazione";
    }

    @PostMapping("/registrazione")
    public String registrazione(@ModelAttribute Utente utente, Model model) {
        utenteService.creaUtente(utente);
        return "redirect:/entro";
    }

    @GetMapping("/entro")
    public String showLoginForm() {
        return "/entro";
    }

    @PostMapping("/entro")
    public String loginUser(@ModelAttribute Utente utente,
                            HttpServletRequest request, Model model) {
        String email = utente.getEmail();
        String password = utente.getPassword();

        Optional<Utente> exist = utenteService.findByEmailAndPassword(email, password);

        if (exist.isPresent()) {
            Utente esiste = exist.get();
            HttpSession session = request.getSession();
            session.setAttribute("user", esiste);
            return "redirect:/profilo";
        } else {
            model.addAttribute("error", "Email o password errati");
            return "entro";
        }
    }

    @GetMapping("/profilo")
    public String showProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            Utente utente = (Utente) session.getAttribute("user");
            model.addAttribute("utente", utente);
            return "profilo";
        } else {
            return "redirect:/entro";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/entro";
    }


}

