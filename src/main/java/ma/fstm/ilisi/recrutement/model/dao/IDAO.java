package ma.fstm.ilisi.recrutement.model.dao;

import ma.fstm.ilisi.recrutement.model.bo.User;

import java.util.Collection;

public interface IDAO<T> {
    boolean Create(T user);
    Collection<T> Retrieve();
    void update(T user);
    boolean delete(T user);
}
