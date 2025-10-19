package model;

import jakarta.persistence.*;

@Entity
@Table(name = "association")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    @ManyToOne
    @JoinColumn(name = "receveur_id")
    private Receveur receveur;

    public Association() {}

    public Association(Donneur donneur, Receveur receveur) {
        this.donneur = donneur;
        this.receveur = receveur;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Donneur getDonneur() { return donneur; }
    public void setDonneur(Donneur donneur) { this.donneur = donneur; }

    public Receveur getReceveur() { return receveur; }
    public void setReceveur(Receveur receveur) { this.receveur = receveur; }
}
