package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import model.Donneur;
import model.StatutDonneur;

public class DonneurTest {

    @Test
    void testSettersAndGetters() {
        Donneur d = new Donneur();
        d.setNom("Ahmed");
        d.setGroupeSanguin("A+");
        d.setStatut(StatutDonneur.DISPONIBLE);

        Assertions.assertEquals("Ahmed", d.getNom());
        Assertions.assertEquals("A+", d.getGroupeSanguin());
        Assertions.assertEquals(StatutDonneur.DISPONIBLE, d.getStatut());
    }
}
