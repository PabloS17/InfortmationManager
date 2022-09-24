package net.infortmation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class RelacionDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RelacionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Relacion> list() {
        String sql = "SELECT * FROM RELACION";

        List<Relacion> listRelacion = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Relacion.class));

        return listRelacion;
    }

    public void save(Relacion relacion) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("relacion").usingColumns("id_tipo", "id_arma");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(relacion);
        insertActor.execute(param);
    }

    public Relacion get(int id) {
        String sql = "SELECT * FROM RELACION WHERE id_arma = ?";
        Object[] args = {id};
        Relacion relacion = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Relacion.class));
        return relacion;
    }

    public void update(Relacion relacion) {
        String sql = "UPDATE RELACION SET id_tipo =:id_tipo WHERE id_arma =:id_arma";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(relacion);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM RELACION WHERE id_arma = ?";
        jdbcTemplate.update(sql, id);
    }

    public void funcion(){
        String sql = "CALL relacionArma()";

        jdbcTemplate.update(sql);
    }
}