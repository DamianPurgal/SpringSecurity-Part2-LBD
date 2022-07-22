package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.DTO.AppUserDTO;
import lbd.fissst.springsecurity2lbd.model.AppUser;
import lbd.fissst.springsecurity2lbd.service.definition.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final AppUserService userService;

    @GetMapping("/{username}")
    public AppUserDTO getUser(@PathVariable("username") String username){
        AppUser user = userService.getUser(username);

        return AppUserDTO.builder()
                .username(user.getUsername())
                .authorities(user.getUserPermissions())
                .build();
    }

    @Transactional
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
    }

    @PutMapping("/{username}")
    public void updateUserPassword(@PathVariable("username") String username, @RequestParam String newPassword){
        userService.updatePassword(username, newPassword);
    }
}
