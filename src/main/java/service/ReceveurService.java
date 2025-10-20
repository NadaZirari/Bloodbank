package service;

import dao.ReceveurDAO;
import model.Receveur;
import model.EtatReceveur;
import java.util.List;

public class ReceveurService {

    private final ReceveurDAO dao = new ReceveurDAO();

    public void ajouterReceveur(Receveur r) {
        r.setEtat(EtatReceveur.EN_ATTENTE);
        dao.save(r);
    }

    public void mettreAJour(Receveur r) {
        verifierEtat(r);
        dao.update(r);
    }

    public void supprimer(Long id) {
        dao.delete(id);
    }
    

    public Receveur chercher(Long id) {
        return dao.findById(id);
    }

    public List<Receveur> listerTous() {
        return dao.findAll();
    }

    public List<Receveur> listerNonSatisfaits() {
        return dao.findNonSatisfaits();
    }

    private void verifierEtat(Receveur r) {
        // Logique pour vérifier si le nombre de donneurs associés satisfait le besoin
        // Exemple simple:
        if (r.getEtat() == EtatReceveur.EN_ATTENTE) return;
    }
}
