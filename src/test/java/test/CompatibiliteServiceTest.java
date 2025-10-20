package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Donneur;
import model.EtatReceveur;
import model.Receveur;
import model.StatutDonneur;
import service.AssociationService;
import service.Compatibilite;

public class CompatibiliteServiceTest {

    private final AssociationService service = new AssociationService();

    @Test
    void testCompatibiliteSanguineValide() {
        // Donneur et receveur compatibles
        Donneur d = new Donneur();
        d.setGroupeSanguin("O-");
        d.setStatut(StatutDonneur.DISPONIBLE);

        Receveur r = new Receveur();
        r.setGroupeSanguin("A+");
        r.setEtat(EtatReceveur.EN_ATTENTE);

        boolean compatible = Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin());
        Assertions.assertTrue(compatible, "O- devrait être compatible avec A+.");
    }

    @Test
    void testCompatibiliteSanguineInvalide() {
        // Donneur et receveur incompatibles
        Donneur d = new Donneur();
        d.setGroupeSanguin("B+");
        d.setStatut(StatutDonneur.DISPONIBLE);

        Receveur r = new Receveur();
        r.setGroupeSanguin("A-");
        r.setEtat(EtatReceveur.EN_ATTENTE);

        boolean compatible = Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin());
        Assertions.assertFalse(compatible, "B+ ne devrait pas être compatible avec A-.");
    }

    @Test
    void testCompatibiliteIdentique() {
        // Même groupe sanguin
        Donneur d = new Donneur();
        d.setGroupeSanguin("AB+");
        d.setStatut(StatutDonneur.DISPONIBLE);

        Receveur r = new Receveur();
        r.setGroupeSanguin("AB+");
        r.setEtat(EtatReceveur.EN_ATTENTE);

        boolean compatible = Compatibilite.estCompatible(d.getGroupeSanguin(), r.getGroupeSanguin());
        Assertions.assertTrue(compatible, "AB+ devrait être compatible avec AB+.");
    }
}
