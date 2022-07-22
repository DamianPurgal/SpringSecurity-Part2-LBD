package lbd.fissst.springsecurity2lbd.DTO;

import lbd.fissst.springsecurity2lbd.security.UserPermissions;
import lombok.Data;

import java.util.List;

@Data
public class UserRegistrationRequest {
    private String username;
    private String password;
    private List<UserPermissions> permissions;
}
