package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donneur")
public class Donneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String telephone;
    private String cin;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    private double poids;
    private String sexe;
    private boolean contreIndication; 
    

    @Column(name = "groupe_sanguin")
    private String groupeSanguin;
    private Long receveurId;
    @OneToOne
    @JoinColumn(name = "receveur_id") // colonne FK dans la table donneur
    private Receveur receveur;
    
    @Enumerated(EnumType.STRING)
    private StatutDonneur statut;
    
    // Constructeurs
    public Donneur() {}
    public Donneur(String nom, String prenom, String telephone, String cin,
            LocalDate dateNaissance, double poids, String sexe, String groupeSanguin) {
 this.nom = nom;
 this.prenom = prenom;
 this.telephone = telephone;
 this.cin = cin;
 this.dateNaissance = dateNaissance;
 this.poids = poids;
 this.sexe = sexe;
 this.groupeSanguin = groupeSanguin;

 // Initialisation automatique
 this.statut = StatutDonneur.DISPONIBLE;  // par défaut
 this.contreIndication = false;           // par défaut
}

    public Donneur(String nom, String prenom, String telephone, String cin,
            LocalDate dateNaissance, double poids, String sexe, String groupeSanguin,
            StatutDonneur statut, boolean contreIndication) {
 this.nom = nom;
 this.prenom = prenom;
 this.telephone = telephone;
 this.cin = cin;
 this.dateNaissance = dateNaissance;
 this.poids = poids;
 this.sexe = sexe;
 this.groupeSanguin = groupeSanguin;
 this.statut = statut;
 this.contreIndication = contreIndication;
}
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }
    public StatutDonneur getStatut() { return statut; }
    public void setStatut(StatutDonneur statut) { this.statut = statut; }
    public boolean hasContreIndication() { return contreIndication; }
    public void setContreIndication(boolean contreIndication) { this.contreIndication = contreIndication; }
    public Receveur getReceveur() { return receveur; }
    public void setReceveur(Receveur receveur) { this.receveur = receveur; }
    public Long getReceveurId() { return receveurId; }
    public void setReceveurId(Long receveurId) { this.receveurId = receveurId; }
}

