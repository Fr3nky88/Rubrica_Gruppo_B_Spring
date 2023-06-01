package it.develhope.gruppob.rubrica.services;

import it.develhope.gruppob.rubrica.daos.ContattoDao;
import it.develhope.gruppob.rubrica.models.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContattoService {

    @Autowired
    private ContattoDao contattoDao;

    public List<Contatto> getContatti() {
        return contattoDao.getContatti();
    }

    public List<Contatto> getContattiSenzaIndirizzo() {
        return contattoDao.getContattiSenzaIndirizzo();
    }
}
