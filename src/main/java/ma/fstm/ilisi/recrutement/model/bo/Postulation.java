package ma.fstm.ilisi.recrutement.model.bo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "postulation", schema = "public", catalog = "db_shuf")
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private Date datepost;
    private String nom;
    private String prenom;
    private String cv;
    private String lettre;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "offer")
    private Offer offer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    @Basic
    @Column(name = "datepost")
    public Date getDatepost() {
        return datepost;
    }

    public void setDatepost(Date datepost) {
        this.datepost = datepost;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postulation that = (Postulation) o;
        return cv == that.cv && offer == that.offer && Objects.equals(id, that.id) && Objects.equals(datepost, that.datepost) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(lettre, that.lettre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datepost, nom, prenom, cv, lettre, offer);
    }
}
