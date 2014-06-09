package uk.org.redalert.admindao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import uk.org.redalert.dbmapping.AdminEntity;

import java.util.List;

@Transactional
@Repository
public class AdminImpl implements AdminDAO {

    @Autowired private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<AdminEntity> getAdmin(String username, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String query = String.format("from AdminEntity where username='%s' and password=md5('%s')", username, password);
        List<AdminEntity> admin= session.createQuery(query).list();
        tx.commit();
        return admin;
    }
}
