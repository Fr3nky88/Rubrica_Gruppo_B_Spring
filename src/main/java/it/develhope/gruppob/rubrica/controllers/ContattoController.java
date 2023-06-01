package it.develhope.gruppob.rubrica.controllers;


import it.develhope.gruppob.rubrica.models.Contatto;
import it.develhope.gruppob.rubrica.services.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contatto/v1")
public class ContattoController {

    @Autowired
    public ContattoService contattoService;

    @GetMapping(path = "/contatti", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contatto> getContatti() {
        return contattoService.getContatti();
    }
    @GetMapping(path = "/contattisenzaindirizzo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contatto> getContattiSenzaIndirizzo() {
        return contattoService.getContattiSenzaIndirizzo();
    }
}