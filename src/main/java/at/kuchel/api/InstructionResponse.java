package at.kuchel.api;

import lombok.Data;

@Data
public class InstructionResponse {

    private String step;
    private String instructionDescription;
}
