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
public class ArmaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArmaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Arma> list() {
		String sql = "SELECT * FROM ARMA";
		
		List<Arma> listArma = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Arma.class));
		
        return listArma;
    }
  
    public void save(Arma arma) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
    	insertActor.withTableName("arma").usingColumns("tipo", "nombre", "rareza", "damage", "cargador", "cadencia");
    	
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(arma);
    	insertActor.execute(param);
    }
  
    public Arma get(int id) {
    	String sql = "SELECT * FROM ARMA WHERE id = ?";
    	Object[] args = {id};
    	Arma arma = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Arma.class));
        return arma;
    }
  
    public void update(Arma arma) {
    	String sql = "UPDATE ARMA SET tipo=:tipo, nombre =:nombre, rareza =:rareza, damage =:damage, cargador =:cargador, cadencia =:cadencia WHERE id =:id";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(arma);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	
    	template.update(sql, param);
    }
  
    public void delete(int id) {
    	String sql = "DELETE FROM ARMA WHERE id = ?";
    	jdbcTemplate.update(sql, id);
    }
	
}
