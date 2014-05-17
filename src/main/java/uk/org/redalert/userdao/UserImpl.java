package uk.org.redalert.userdao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import uk.org.redalert.dbmapping.UserEntity;

import java.util.List;

@Transactional
@Repository
public class UserImpl implements UserDAO {

    @Autowired private SessionFactory sessionFactory;
    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<UserEntity> listOfStock =  session.createQuery("from UserEntity").list();
        tx.commit();
        return listOfStock;
    }
}
