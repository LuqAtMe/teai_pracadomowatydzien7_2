package home.application.teai_pracadomowatydzien7_2.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private DataSource dataSource;

    @Autowired
    public DatabaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    public void init(){
//        String sql = "CREATE TABLE facts (fact_id int, fact_text varchar (255), PRIMARY KEY(fact_id))";
//        jdbcTemplate().update(sql);
    }

}
