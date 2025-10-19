package model;


import java.util.*;

public class Compatibilite {

    private static final Map<String, List<String>> COMPATIBILITE = new HashMap<>();

    static {
        COMPATIBILITE.put("O-", Arrays.asList("O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"));
        COMPATIBILITE.put("O+", Arrays.asList("O+", "A+", "B+", "AB+"));
        COMPATIBILITE.put("A-", Arrays.asList("A-", "A+", "AB-", "AB+"));
        COMPATIBILITE.put("A+", Arrays.asList("A+", "AB+"));
        COMPATIBILITE.put("B-", Arrays.asList("B-", "B+", "AB-", "AB+"));
        COMPATIBILITE.put("B+", Arrays.asList("B+", "AB+"));
        COMPATIBILITE.put("AB-", Arrays.asList("AB-", "AB+"));
        COMPATIBILITE.put("AB+", Arrays.asList("AB+"));
    }

    public static boolean estCompatible(String groupeDonneur, String groupeReceveur) {
        return COMPATIBILITE.getOrDefault(groupeDonneur, List.of())
                .contains(groupeReceveur);
    }
}
