package it.develhope.gruppob.rubrica.daos;

import it.develhope.gruppob.rubrica.models.Contatto;
import it.develhope.gruppob.rubrica.models.Indirizzo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContattoDao {

    private static final Logger logger = LoggerFactory.getLogger(ContattoDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("rowMapperContatto")
    private RowMapper<Contatto> rowMapper;

    public List<Contatto> getContatti() {
        return jdbcTemplate.query("SELECT * FROM Contatto c LEFT JOIN Indirizzo i ON i.id = c.indirizzo", rowMapper);
    }

    public List<Contatto> getContattiSenzaIndirizzo() {
        return jdbcTemplate.query("SELECT * FROM Contatto", rowMapper);
    }
}
