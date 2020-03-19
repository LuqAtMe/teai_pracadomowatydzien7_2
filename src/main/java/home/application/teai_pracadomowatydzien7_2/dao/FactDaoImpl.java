package home.application.teai_pracadomowatydzien7_2.dao;

import home.application.teai_pracadomowatydzien7_2.model.AnimalFactDB;
import home.application.teai_pracadomowatydzien7_2.model.AnimalFactFromApi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class FactDaoImpl implements FactDao {

    private JdbcTemplate jdbcTemplate;

    public FactDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createNewFactInDatabase(AnimalFactFromApi animalFactFromApi) {
        String sql = "INSERT INTO facts VALUES (?, ?)";
        jdbcTemplate.update(sql, counter() + 1, animalFactFromApi.getText());
    }

    @Override
    public void updateFact(AnimalFactDB animalFactDB) {
        String sql = "UPDATE facts SET facts.fact_text = ? WHERE facts.fact_id = ?";
        jdbcTemplate.update(sql, animalFactDB.getText(), animalFactDB.getId());
    }

    @Override
    public List<AnimalFactDB> getAllFacts() {
        String sql = "SELECT * FROM facts";
        List<AnimalFactDB> animalFactFromApis = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(fact -> animalFactFromApis.add(new AnimalFactDB(
                Long.parseLong(String.valueOf(fact.get("fact_id"))),
                String.valueOf(fact.get("fact_text"))
        )));
        return animalFactFromApis;
    }

    @Override
    public AnimalFactDB findFact(long id) {
        String sql = "SELECT * FROM facts WHERE facts.fact_id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<AnimalFactDB>() {
            @Override
            public AnimalFactDB mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new AnimalFactDB(rs.getInt("fact_id"), rs.getString("fact_text"));
            }
        }, id);
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM facts WHERE facts.fact_id = ?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public Integer counter() {
        String sql = "SELECT count(fact_id) FROM facts";
        Integer counter = jdbcTemplate.queryForObject(sql, Integer.class);
        return counter;

    }
}
