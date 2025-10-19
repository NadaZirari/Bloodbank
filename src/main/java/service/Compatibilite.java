package service;

import java.util.*;

public class Compatibilite {

    private static final Map<String, List<String>> compatibilite = new HashMap<>();

    static {
        compatibilite.put("O-", Arrays.asList("O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"));
        compatibilite.put("O+", Arrays.asList("O+", "A+", "B+", "AB+"));
        compatibilite.put("A-", Arrays.asList("A-", "A+", "AB-", "AB+"));
        compatibilite.put("A+", Arrays.asList("A+", "AB+"));
        compatibilite.put("B-", Arrays.asList("B-", "B+", "AB-", "AB+"));
        compatibilite.put("B+", Arrays.asList("B+", "AB+"));
        compatibilite.put("AB-", Arrays.asList("AB-", "AB+"));
        compatibilite.put("AB+", Arrays.asList("AB+"));
    }

    public static boolean estCompatible(String donneur, String receveur) {
        return compatibilite.getOrDefault(donneur, Collections.emptyList()).contains(receveur);
    }

}
