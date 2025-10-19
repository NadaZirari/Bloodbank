package service;

import java.util.*;

public class Compatibilite {

    private static final Map<String, List<String>> compatibilite = new HashMap<>();

    static {
        compatibilite.put("O-", List.of("O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"));
        compatibilite.put("O+", List.of("O+", "A+", "B+", "AB+"));
        compatibilite.put("A-", List.of("A-", "A+", "AB-", "AB+"));
        compatibilite.put("A+", List.of("A+", "AB+"));
        compatibilite.put("B-", List.of("B-", "B+", "AB-", "AB+"));
        compatibilite.put("B+", List.of("B+", "AB+"));
        compatibilite.put("AB-", List.of("AB-", "AB+"));
        compatibilite.put("AB+", List.of("AB+"));
    }

    public static boolean estCompatible(String donneur, String receveur) {
        return compatibilite.getOrDefault(donneur, List.of()).contains(receveur);
    }
}
