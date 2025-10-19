package service;



import dao.DonneurDAO;
import model.Donneur;
import java.util.List;

public class DonneurService {

    private final DonneurDAO donneurDAO = new DonneurDAO();

    public void ajouterDonneur(Donneur d) {
        d.verifierEligibilite();
        donneurDAO.save(d);
    }

    public List<Donneur> listerTous() {
        return donneurDAO.findAll();
    }

    public List<Donneur> listerDisponibles() {
        return donneurDAO.findDisponibles();
    }

    public Donneur chercher(Long id) {
        return donneurDAO.findById(id);
    }

    public void supprimer(Long id) {
        donneurDAO.delete(id);
    }

    public void mettreAJour(Donneur d) {
        donneurDAO.update(d);
    }
}
