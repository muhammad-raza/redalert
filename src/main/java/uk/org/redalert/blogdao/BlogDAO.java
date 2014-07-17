package uk.org.redalert.blogdao;

import uk.org.redalert.dbmapping.BlogEntity;

import java.util.List;

public interface BlogDAO {

    public void addBlog(BlogEntity blogEntity);

    public List<BlogEntity> getAllBlog();

    public void deleteBlog(int id);

}
