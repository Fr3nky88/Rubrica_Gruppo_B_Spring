package it.develhope.gruppob.rubrica.configurations;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://raspberrypi:3306/rubricab");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("Fr3nky88?");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        return dataSourceBuilder.build();
//    }

}
