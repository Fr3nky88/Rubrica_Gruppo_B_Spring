package it.develhope.gruppob.rubrica.configurations;

import it.develhope.gruppob.rubrica.daos.ContattoDao;
import it.develhope.gruppob.rubrica.models.Contatto;
import it.develhope.gruppob.rubrica.models.Indirizzo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class JdbcTemplateConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "rowMapperContatto")
    public RowMapper<Contatto> getRowMapperContatto() {
        return new RowMapper<Contatto>() {

            private static final Logger logger = LoggerFactory.getLogger(RowMapper.class);

            @Override
            public Contatto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contatto c = new Contatto();
                c.setId(BigInteger.valueOf(rs.getInt(1)));
                c.setNome(rs.getString("nome"));
                c.setCognome(rs.getString("cognome"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));

                try {
                    BigDecimal indirizzo = rs.getBigDecimal(6);
                    if (indirizzo != null) {
                        Indirizzo i = new Indirizzo();
                        i.setId(BigInteger.valueOf(rs.getInt(7)));
                        i.setVia(rs.getString("via"));
                        i.setCitta(rs.getString("citta"));
                        i.setNumeroCivico(rs.getString("numero_civico"));
                        i.setCap(rs.getString("cap"));
                        i.setProvincia(rs.getString("provincia"));
                        c.setIndirizzo(i);
                    }
                } catch (Exception e) {
                    logger.info("L'indirizzo non esiste per il contatto " + c.getId());
                }

                return c;
            }
        };
    }
}
