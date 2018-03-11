package at.kuchel.mapper;

import at.kuchel.api.InstructionResponse;
import at.kuchel.model.Instruction;
import org.springframework.stereotype.Service;

@Service
public class InstructionMapper {

    public InstructionResponse map(Instruction instruction) {
        InstructionResponse ingredientResponse = new InstructionResponse();
        ingredientResponse.setInstructionDescription(instruction.getInstruction());
        ingredientResponse.setStep(instruction.getStep());
        return ingredientResponse;
    }
}
