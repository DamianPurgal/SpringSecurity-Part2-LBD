package lbd.fissst.springsecurity2lbd.service.implementation;

import lbd.fissst.springsecurity2lbd.exception.AppUserNotFoundException;
import lbd.fissst.springsecurity2lbd.model.AppUser;
import lbd.fissst.springsecurity2lbd.repository.AppUserRepository;
import lbd.fissst.springsecurity2lbd.service.definition.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository userRepository;

    @Override
    public void createUser(AppUser user) {
        userRepository.save(user);
    }

    @Override
    public AppUser getUser(String username) {
        return userRepository.findAppUserByUsername(username)
                .orElseThrow(
                        AppUserNotFoundException::new
                );
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteAppUserByUsername(username);
    }

    @Override
    public void updatePassword(String username, String password) {
        AppUser user = userRepository.findAppUserByUsername(username)
                .orElseThrow(
                        AppUserNotFoundException::new
                );
        user.setPassword(password);

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findAppUserByUsername(username)
                .orElseThrow(
                        AppUserNotFoundException::new
                );
    }
}
