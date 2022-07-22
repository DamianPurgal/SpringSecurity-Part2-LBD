package lbd.fissst.springsecurity2lbd.controller;

import lbd.fissst.springsecurity2lbd.DTO.CalculatedValuesDTO;
import lbd.fissst.springsecurity2lbd.DTO.GeneratedValuesDTO;
import lbd.fissst.springsecurity2lbd.service.implementation.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/number")
@AllArgsConstructor
public class NumberController {

    private final MessageServiceImpl messageService;

    @GetMapping
    public ResponseEntity<CalculatedValuesDTO> getCalculatedValues(){

        GeneratedValuesDTO generatedValues = messageService.getValues();

        CalculatedValuesDTO result = new CalculatedValuesDTO(
                generatedValues.getValueOne(),
                generatedValues.getValueTwo()
        );

        return ResponseEntity.ok()
                .body(result);
    }
}
