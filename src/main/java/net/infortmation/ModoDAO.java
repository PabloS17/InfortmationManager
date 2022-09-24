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
public class ModoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ModoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Modo> list() {
		String sql = "SELECT * FROM MODO";
		
		List<Modo> listModo = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Modo.class));
		
        return listModo;
    }
  
    public void save(Modo modo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
    	insertActor.withTableName("modo").usingColumns("cantJugadores", "tipo");
    	
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(modo);
    	insertActor.execute(param);
    }
  
    public Modo get(int id) {
    	String sql = "SELECT * FROM MODO WHERE id = ?";
    	Object[] args = {id};
    	Modo modo = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Modo.class));
        return modo;
    }
  
    public void update(Modo modo) {
    	String sql = "UPDATE MODO SET cantJugadores =:cantJugadores, tipo=:tipo WHERE id =:id";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(modo);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	
    	template.update(sql, param);
    }
  
    public void delete(int id) {
    	String sql = "DELETE FROM MODO WHERE id = ?";
    	jdbcTemplate.update(sql, id);
    }
	
}
