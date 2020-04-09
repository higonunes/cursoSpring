package com.higo.learning.services;

import com.higo.learning.domain.Cliente;
import com.higo.learning.repositories.ClienteRepository;
import com.higo.learning.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);

        if (cliente == null) {
            throw new ObjectNotFoundException("Email nao encontrado");
        }

        String newPass = newPassword();
        cliente.setSenha(bCryptPasswordEncoder.encode(newPass));
        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = random.nextInt(3);
        switch (opt) {
            case 1:
                return (char) (random.nextInt(10) + 48);
            case 2:
                return (char) (random.nextInt(26) + 65);
            default:
                return (char) (random.nextInt(26) + 97);
        }

    }
}
