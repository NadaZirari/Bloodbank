package service;

import dao.AssociationDAO;
import dao.DonneurDAO;
import model.Association;
import model.Donneur;
import model.Receveur;
import model.StatutDonneur;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
public class DonneurService {

    private final DonneurDAO dao = new DonneurDAO();
    private final AssociationDAO assocDao = new AssociationDAO();

    public void ajouterDonneur(Donneur d) {
        d.setStatut(verifierEligibilite(d));
        dao.save(d);
    }

    public void mettreAJour(Donneur d) {
        d.setStatut(verifierEligibilite(d));
        dao.update(d);
    }

    public void supprimer(Long id) {
        dao.delete(id);
    }

    public Donneur chercher(Long id) {
        return dao.findById(id);
    }

    public List<Donneur> listerTous() {
        return dao.findAll();
    }

    public List<Donneur> listerDisponibles() {
        return dao.findDisponibles();
    }

    public Receveur getReceveurPourDonneur(Long donneurId) {
        // Ici on suppose qu'on a une méthode dans AssociationDAO pour récupérer par donneur
        Association assoc = assocDao.findByDonneurId(donneurId);
        if (assoc != null) {
            return assoc.getReceveur();
        }
        return null;
    }
    private StatutDonneur verifierEligibilite(Donneur d) {
        int age = Period.between(d.getDateNaissance(), LocalDate.now()).getYears();
        if (age < 18 || age > 65) return StatutDonneur.NON_ELIGIBLE;
        if (d.getPoids() < 50) return StatutDonneur.NON_ELIGIBLE;
        // Ajouter d'autres validations médicales si nécessaire
        return StatutDonneur.DISPONIBLE;
    }
}
