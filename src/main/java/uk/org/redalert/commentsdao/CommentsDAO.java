package uk.org.redalert.commentsdao;

import uk.org.redalert.dbmapping.AdminEntity;
import uk.org.redalert.dbmapping.CommentEntity;

import java.util.List;

public interface CommentsDAO {

    public void addComment(CommentEntity comment);

    public void deleteComment(int id);

    public List<CommentEntity> getAllComments();

    public CommentEntity getComment(int id);

    public void updateComment(int id, int isApproved);

}
