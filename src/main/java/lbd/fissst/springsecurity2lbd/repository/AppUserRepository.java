package lbd.fissst.springsecurity2lbd.repository;

import lbd.fissst.springsecurity2lbd.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByUsername(String username);

    void deleteAppUserByUsername(String username);
}
