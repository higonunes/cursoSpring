package com.higo.learning.services.validation;

import com.higo.learning.dto.ClienteNewDTO;
import com.higo.learning.enums.TipoCliente;
import com.higo.learning.resources.exception.FieldMessage;
import com.higo.learning.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClientInsert, ClienteNewDTO> {


    @Override
    public void initialize(ClientInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClienteNewDTO clienteNewDTO, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();

        if (clienteNewDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(clienteNewDTO.getCpfOuCnpj())) {
            list.add(new FieldMessage("CpfOuCnpj", "O CPF não é valido"));
        }
        if (clienteNewDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(clienteNewDTO.getCpfOuCnpj())) {
            list.add(new FieldMessage("CpfOuCnpj", "O CNPJ não é valido"));
        }

        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
