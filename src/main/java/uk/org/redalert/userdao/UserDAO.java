package uk.org.redalert.userdao;

import uk.org.redalert.dbmapping.UserEntity;

import java.util.List;

public interface UserDAO {
    public List<UserEntity> getAllUsers();

}
