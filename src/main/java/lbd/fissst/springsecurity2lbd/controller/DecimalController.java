package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.service.implementation.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/decimal")
@AllArgsConstructor
public class DecimalController {

    private final MessageServiceImpl messageService;

    @PostMapping
    public Integer setDecimal(@RequestParam Integer decimal){
        messageService.setDecimalPlaces(decimal);
        return decimal;
    }

    @GetMapping
    public Integer getDecimal(){
        return messageService.getDecimalPlaces();
    }

}
