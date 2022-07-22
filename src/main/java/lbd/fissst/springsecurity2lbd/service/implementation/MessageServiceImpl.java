package lbd.fissst.springsecurity2lbd.service.implementation;

import lbd.fissst.springsecurity2lbd.DTO.GeneratedValuesDTO;
import org.apache.commons.math3.util.Precision;

public class MessageServiceImpl {
    private Double valueOne;
    private Double valueTwo;
    private Integer decimalPlaces;
    private Integer multiplier;

    public MessageServiceImpl() {
        this.decimalPlaces = 2;
        this.multiplier = 1;
    }

    private void calculateValues(){
        valueOne = Math.random();
        valueTwo = Math.random();

        valueOne *= multiplier;
        valueTwo *= multiplier;

        valueOne = Precision.round(valueOne, decimalPlaces);
        valueTwo = Precision.round(valueTwo, decimalPlaces);
    }

    public GeneratedValuesDTO getValues(){
        calculateValues();

        return GeneratedValuesDTO.builder()
                .valueOne(valueOne)
                .valueTwo(valueTwo)
                .multiplier(multiplier)
                .decimalPlaces(decimalPlaces)
                .build();
    }
}
