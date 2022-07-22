package lbd.fissst.springsecurity2lbd.security;

import lombok.Getter;

@Getter
public enum UserPermissions {

    DECIMAL_READ("decimal:read"),
    DECIMAL_WRITE("decimal:write"),
    MULTIPLIER_READ("multiplier:read"),
    MULTIPLIER_WRITE("multiplier:write"),
    ACCESS_ALL("accessAll");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

}
