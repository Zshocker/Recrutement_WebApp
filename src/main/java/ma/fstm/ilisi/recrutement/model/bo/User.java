package ma.fstm.ilisi.recrutement.model.bo;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateCreated;
    private String name, login, passhash, email;
    @OneToMany(fetch = FetchType.EAGER , mappedBy = "creator")
    private Set<Offer> offers=new HashSet<>();
    public User()
    {
    }

    public User(int id, Date dateCreated, String name, String login, String passhash, String email) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.name = name;
        this.login = login;
        this.passhash = passhash;
        this.email = email;
    }

    public Set<Offer> getOffers()
    {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date _dateCreated) {
        this.dateCreated = _dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String _login) {
        this.login = _login;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String _passHash) {
        this.passhash = _passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public static String HashPass(String pass, String Algo)
    {
        try {
            MessageDigest md=MessageDigest.getInstance(Algo);
            byte[] digest=md.digest(pass.getBytes("UTF-8"));
            return DatatypeConverter.printHexBinary(digest).toLowerCase(Locale.ROOT);
        } catch (NoSuchAlgorithmException e) {
             System.err.println(e);
            return null;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e);
            return null;
        }

    }

}
