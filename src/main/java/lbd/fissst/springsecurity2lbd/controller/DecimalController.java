package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.service.implementation.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/decimal")
@AllArgsConstructor
public class DecimalController {

    private final MessageServiceImpl messageService;

    @PostMapping
    public ResponseEntity<Integer> setDecimal(@RequestParam Integer decimal){
        messageService.setDecimalPlaces(decimal);

        return ResponseEntity.ok()
                .body(decimal);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('decimal:read', 'accessAll')")
    public ResponseEntity<Integer> getDecimal(){
        return ResponseEntity.ok()
                .body(
                        messageService.getDecimalPlaces()
                );
    }

}
