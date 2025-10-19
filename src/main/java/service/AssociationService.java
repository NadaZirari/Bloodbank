package service;

import dao.AssociationDAO;
import dao.DonneurDAO;
import dao.ReceveurDAO;
import model.Association;
import model.Donneur;
import model.EtatReceveur;
import model.Receveur;
import model.SituationReceveur;
import model.StatutDonneur;

import java.util.List;
import java.util.stream.Collectors;

public class AssociationService {

    private final DonneurDAO donneurDAO = new DonneurDAO();
    private final ReceveurDAO receveurDAO = new ReceveurDAO();
    private final AssociationDAO associationDAO = new AssociationDAO();

    public boolean associer(Long idDonneur, Long idReceveur) {
        Donneur d = donneurDAO.findById(idDonneur);
        Receveur r = receveurDAO.findById(idReceveur);

        if (d == null || r == null) return false;
        if (d.getStatut() != StatutDonneur.DISPONIBLE) return false;
        if (r.getEtat() != EtatReceveur.EN_ATTENTE) return false;
        if (!Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin())) return false;

        Association a = new Association(d, r);
        associationDAO.save(a);

        d.setStatut(StatutDonneur.NON_DISPONIBLE);
        donneurDAO.update(d);

        r.setEtat(EtatReceveur.SATISFAIT);
        receveurDAO.update(r);

        return true;
    }

    public List<Donneur> donneursCompatibles(Long receveurId) {
        List<Donneur> disponibles = donneurDAO.findDisponibles();
        if (receveurId == null) return disponibles;
        Receveur r = receveurDAO.findById(receveurId);
        return disponibles.stream()
                .filter(d -> Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin()))
                .collect(Collectors.toList());
    }

    public List<Receveur> receveursCompatibles(Long donneurId) {
        List<Receveur> nonSatisfaits = receveurDAO.findNonSatisfaits();
        if (donneurId == null) return nonSatisfaits;
        Donneur d = donneurDAO.findById(donneurId);
        return nonSatisfaits.stream()
                .filter(r -> Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin()))
                .collect(Collectors.toList());
    }
}
