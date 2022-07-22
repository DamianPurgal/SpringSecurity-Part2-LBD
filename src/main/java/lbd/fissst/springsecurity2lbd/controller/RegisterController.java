package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.DTO.UserRegistrationRequest;
import lbd.fissst.springsecurity2lbd.model.AppUser;
import lbd.fissst.springsecurity2lbd.security.UserPermissions;
import lbd.fissst.springsecurity2lbd.service.definition.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/auth/register")
public class RegisterController {

    private final AppUserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        AppUser user = AppUser.builder()
                .id(null)
                .username(userRegistrationRequest.getUsername())
                .password(passwordEncoder.encode(userRegistrationRequest.getPassword()))
                .authorities(userRegistrationRequest.getPermissions())
                .locked(false)
                .enabled(true)
                .build();

        userService.createUser(user);

        return ResponseEntity.ok()
                .build();
    }
}
