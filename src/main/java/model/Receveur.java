package model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receveurs")
public class Receveur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String cin;
    private String telephone;
    private String sexe;
    private String groupeSanguin;
    @Enumerated(EnumType.STRING)
    private SituationReceveur situation;

    @Enumerated(EnumType.STRING)
    private EtatReceveur etat;

    @OneToMany(mappedBy = "receveur", cascade = CascadeType.ALL)
    private List<Donneur> donneurs = new ArrayList<>();

    public Receveur() {}

    public void verifierEtat() {
        int besoin = switch (situation) {
            case "CRITIQUE" -> 4;
            case "URGENT" -> 3;
            default -> 1;
        };
        this.etat = (donneurs.size() >= besoin) ? "SATISFAIT" : "EN_ATTENTE";
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }
    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }
    public String getSituation() { return situation; }
    public void setSituation(String situation) { this.situation = situation; }
    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
    public List<Donneur> getDonneurs() { return donneurs; }
    public void setDonneurs(List<Donneur> donneurs) { this.donneurs = donneurs; }
}
