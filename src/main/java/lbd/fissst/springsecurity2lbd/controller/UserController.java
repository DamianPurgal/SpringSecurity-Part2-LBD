package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.DTO.AppUserDTO;
import lbd.fissst.springsecurity2lbd.model.AppUser;
import lbd.fissst.springsecurity2lbd.service.definition.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final AppUserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<AppUserDTO> getUser(@PathVariable("username") String username){
        AppUser user = userService.getUser(username);

        AppUserDTO result = AppUserDTO.builder()
                .username(user.getUsername())
                .authorities(user.getUserPermissions())
                .build();

        return ResponseEntity.ok()
                .body(result);
    }

    @Transactional
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<Void> updateUserPassword(@PathVariable("username") String username, @RequestParam String newPassword){
        userService.updatePassword(username, newPassword);
        return ResponseEntity.ok()
                .build();
    }
}
