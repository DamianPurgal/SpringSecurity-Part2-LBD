package lbd.fissst.springsecurity2lbd.service.definition;

import lbd.fissst.springsecurity2lbd.model.AppUser;

public interface AppUserService {

    void createUser(AppUser user);

    AppUser getUser(String username);

    void deleteUser(String username);

    void updatePassword(String username, String password);

}
