package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "receveur")
public class Receveur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String telephone;
    private String cin;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    private String sexe;

    @Column(name = "groupe_sanguin")
    private String groupeSanguin;

    private String situation; // CRITIQUE, URGENT, NORMAL
    private String etat; // EN_ATTENTE, SATISFAIT

    public Receveur() {}

    public Receveur(String nom, String prenom, String telephone, String cin, LocalDate dateNaissance, String sexe, String groupeSanguin, String situation) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.groupeSanguin = groupeSanguin;
        this.situation = situation;
        this.etat = "EN_ATTENTE";
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

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }

    public String getSituation() { return situation; }
    public void setSituation(String situation) { this.situation = situation; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
}
