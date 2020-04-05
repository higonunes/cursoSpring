package com.higo.learning.services.validation;

import com.higo.learning.domain.Cliente;
import com.higo.learning.dto.ClienteNewDTO;
import com.higo.learning.enums.TipoCliente;
import com.higo.learning.repositories.ClienteRepository;
import com.higo.learning.resources.exception.FieldMessage;
import com.higo.learning.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClientInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

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

        Cliente aux = clienteRepository.findByEmail(clienteNewDTO.getEmail());

        if(aux != null) {
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
