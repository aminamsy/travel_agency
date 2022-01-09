package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class sitecontroler {
    final ArrayList<Inscription> inscriptions = new ArrayList<>();
    @PostMapping("api/inscription")
    public ArrayList<Inscription> ajouter(@RequestBody Inscription user){
        for(Inscription inscription:inscriptions){
            if (inscription.userName().equals(user.userName()))
                return inscriptions;
        }
        inscriptions.add(user);
        return inscriptions;
    }
    @GetMapping("api/travels")
    public ArrayList<Pays> getpays(@RequestParam String userName){
        ArrayList<Pays> pays = new ArrayList<>();
        for(Inscription inscription:inscriptions){
            if (inscription.userName().equals(userName)){
            pays.add(new Pays("France", 30));}
        }
        return pays;
    }
}
