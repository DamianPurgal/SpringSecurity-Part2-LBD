package lbd.fissst.springsecurity2lbd.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneratedValuesDTO {
    private Double valueOne;
    private Double valueTwo;
    private Integer decimalPlaces;
    private Integer multiplier;
}
