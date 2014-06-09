package uk.org.redalert.admindao;

import uk.org.redalert.dbmapping.AdminEntity;

import java.util.List;

public interface AdminDAO {
    public List<AdminEntity> getAdmin(String username, String password);

}
