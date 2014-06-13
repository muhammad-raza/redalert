package uk.org.redalert.commentsdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.org.redalert.dbmapping.CommentEntity;

import java.util.List;

@Transactional
@Repository
public class CommentsImpl implements CommentsDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addComment(CommentEntity comment) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(comment);
        tx.commit();
    }

    @Override
    public void deleteComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(getComment(id));
        tx.commit();
    }

    @Override
    public void updateComment(int id, int isApproved) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        CommentEntity comment = getComment(id);
        comment.setApproved(isApproved);
        session.update(comment);
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CommentEntity> getAllComments() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<CommentEntity> comments = session.createCriteria(CommentEntity.class).list();
        tx.commit();
        return comments;
    }

    @SuppressWarnings("unchecked")
    @Override
    public CommentEntity getComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (CommentEntity) session.get(CommentEntity.class, id);
    }

}
