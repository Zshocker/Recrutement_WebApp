package ma.fstm.ilisi.recrutement.model.bo;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "offers")
public class Offer
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String profile;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type")
    private ContratType type;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "creator")
    private User creator;
    public ContratType getType() {
        return type;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setType(ContratType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String ISBN) {
        this.description = ISBN;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Offer(int id, String description, String prof, ContratType type) {
        this.id=id;
        this.description = description;
        profile = prof;
        this.type=type;
    }

    public Offer(String description, String profile, ContratType type,User user) {
        this.description = description;
        this.profile = profile;
        this.type = type;
        this.creator=user;
    }

    public Offer()
    {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer livre = (Offer) o;
        return id == livre.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
