package service;



import dao.ReceveurDAO;
import model.Receveur;
import java.util.List;

public class ReceveurService {

    private final ReceveurDAO receveurDAO = new ReceveurDAO();

    public void ajouterReceveur(Receveur r) {
        r.verifierEtat();
        receveurDAO.save(r);
    }

    public List<Receveur> listerTous() {
        return receveurDAO.findAll();
    }

    public List<Receveur> listerNonSatisfaits() {
        return receveurDAO.findNonSatisfaits();
    }

    public Receveur chercher(Long id) {
        return receveurDAO.findById(id);
    }

    public void mettreAJour(Receveur r) {
        r.verifierEtat();
        receveurDAO.update(r);
    }

    public void supprimer(Long id) {
        receveurDAO.delete(id);
    }
}
