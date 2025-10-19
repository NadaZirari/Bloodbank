package model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "donneurs")
public class Donneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String cin;
    private String telephone;
    private LocalDate dateNaissance;
    private double poids;
    private String sexe;
    private String groupeSanguin;
    private String statut; // DISPONIBLE / NON_DISPONIBLE / NON_ELIGIBLE
    private boolean hepatie;
    private boolean vih;
    private boolean diabete;
    private boolean grossesse;

    @ManyToOne
    @JoinColumn(name = "receveur_id")
    private Receveur receveur;

    public Donneur() {}

    // Vérifie l'éligibilité selon les règles
    public void verifierEligibilite() {
        int age = Period.between(this.dateNaissance, LocalDate.now()).getYears();
        if (age < 18 || age > 65 || poids < 50 || hepatie || vih || diabete || grossesse) {
            this.statut = "NON_ELIGIBLE";
        } else {
            this.statut = "DISPONIBLE";
        }
    }

    // Getters et Setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }
    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }
    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public boolean isHepatie() { return hepatie; }
    public void setHepatie(boolean hepatie) { this.hepatie = hepatie; }
    public boolean isVih() { return vih; }
    public void setVih(boolean vih) { this.vih = vih; }
    public boolean isDiabete() { return diabete; }
    public void setDiabete(boolean diabete) { this.diabete = diabete; }
    public boolean isGrossesse() { return grossesse; }
    public void setGrossesse(boolean grossesse) { this.grossesse = grossesse; }
    public Receveur getReceveur() { return receveur; }
    public void setReceveur(Receveur receveur) { this.receveur = receveur; }
}
