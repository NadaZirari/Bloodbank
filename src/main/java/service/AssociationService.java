package service;


import model.*;
import dao.*;
import java.util.List;

public class AssociationService {

    private final DonneurDAO donneurDAO = new DonneurDAO();
    private final ReceveurDAO receveurDAO = new ReceveurDAO();

    public boolean associer(Long idDonneur, Long idReceveur) {
        Donneur donneur = donneurDAO.findById(idDonneur);
        Receveur receveur = receveurDAO.findById(idReceveur);

        if (donneur == null || receveur == null) return false;

        // Vérifier compatibilité et disponibilité
        if (!donneur.getStatut().equals("DISPONIBLE")) return false;
        if (!receveur.getEtat().equals("EN_ATTENTE")) return false;
        if (!Compatibilite.estCompatible(donneur.getGroupeSanguin(), receveur.getGroupeSanguin())) return false;

        donneur.setReceveur(receveur);
        donneur.setStatut("NON_DISPONIBLE");
        donneurDAO.update(donneur);

        receveur.getDonneurs().add(donneur);
        receveur.verifierEtat();
        receveurDAO.update(receveur);

        return true;
    }

    public List<Donneur> donneursCompatiblesPourReceveur(Long idReceveur) {
        Receveur r = receveurDAO.findById(idReceveur);
        return donneurDAO.findDisponibles().stream()
                .filter(d -> Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin()))
                .toList();
    }

    public List<Receveur> receveursCompatiblesPourDonneur(Long idDonneur) {
        Donneur d = donneurDAO.findById(idDonneur);
        return receveurDAO.findNonSatisfaits().stream()
                .filter(r -> Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin()))
                .toList();
    }
}
