package ma.fstm.ilisi.recrutement.model.bo;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Locale;
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private Date datecreated;
    private String name, login, passhash, email;

    public User()
    {
    }

    public User(int id, Date datecreated, String name, String login, String passhash, String email) {
        this.id = id;
        this.datecreated = datecreated;
        this.name = name;
        this.login = login;
        this.passhash = passhash;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date _dateCreated) {
        this.datecreated = _dateCreated;
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
