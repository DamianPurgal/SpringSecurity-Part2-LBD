package lbd.fissst.springsecurity2lbd.DTO;

import lbd.fissst.springsecurity2lbd.security.UserPermissions;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppUserDTO {
    private String username;

    private List<UserPermissions> authorities;
}
