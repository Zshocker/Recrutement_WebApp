package ma.fstm.ilisi.recrutement.model.bo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "contrattypes")
public class ContratType
{
    @Id
    private String type;
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "type")
    private Set<Offer> offers=new HashSet<Offer>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public ContratType(String type) {
        this.type = type;
    }
    public ContratType(){

    }
}
