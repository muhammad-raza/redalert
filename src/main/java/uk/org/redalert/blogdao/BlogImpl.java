package uk.org.redalert.blogdao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.org.redalert.dbmapping.AdminEntity;
import uk.org.redalert.dbmapping.BlogEntity;
import uk.org.redalert.dbmapping.CommentEntity;

import java.util.List;

@Transactional
@Repository
public class BlogImpl implements BlogDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBlog(BlogEntity blogEntity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(blogEntity);
        tx.commit();
    }

    @Override
    public List<BlogEntity> getAllBlog() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<BlogEntity> blogList = session.createCriteria(BlogEntity.class).addOrder(Order.desc("sortDate")).list();

        tx.commit();
        return blogList;
    }

    @Override
    public void deleteBlog(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(getBlog(id));
        tx.commit();
    }

    private BlogEntity getBlog(int id){
        Session session = sessionFactory.getCurrentSession();
        return (BlogEntity) session.get(BlogEntity.class, id);
    }

}
