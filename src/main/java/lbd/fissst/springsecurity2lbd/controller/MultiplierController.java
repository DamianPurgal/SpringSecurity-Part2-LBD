package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.service.implementation.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/multiplier")
@AllArgsConstructor
public class MultiplierController {

    private final MessageServiceImpl messageService;

    @PostMapping
    public Integer setMultiplier(@RequestParam Integer multiplier){
        messageService.setMultiplier(multiplier);
        return multiplier;
    }

    @GetMapping
    public Integer getMultiplier(){
        return messageService.getMultiplier();
    }
}
