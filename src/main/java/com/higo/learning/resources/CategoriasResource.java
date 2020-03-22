package com.higo.learning.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResource {

    @GetMapping
    public String categorias() {
        return "Tudo está funcbcbnvbcionandooooooooooooooo";
    }
}
