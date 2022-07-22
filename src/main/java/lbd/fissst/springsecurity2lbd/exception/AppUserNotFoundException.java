package lbd.fissst.springsecurity2lbd.exception;

import org.springframework.http.HttpStatus;

public class AppUserNotFoundException extends BusinessException {

    public AppUserNotFoundException(){
        super(HttpStatus.NOT_FOUND, "User not found!");
    }

}