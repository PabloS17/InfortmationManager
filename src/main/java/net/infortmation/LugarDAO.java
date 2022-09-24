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
public class LugarDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LugarDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Lugar> list() {
		String sql = "SELECT * FROM LUGAR";
		
		List<Lugar> listLugar = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lugar.class));
		
        return listLugar;
    }
  
    public void save(Lugar lugar) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
    	insertActor.withTableName("lugar").usingColumns("tipo", "nombre", "popularidad");
    	
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(lugar);
    	insertActor.execute(param);
    }
  
    public Lugar get(int id) {
    	String sql = "SELECT * FROM LUGAR WHERE id = ?";
    	Object[] args = {id};
    	Lugar lugar = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Lugar.class));
        return lugar;
    }
  
    public void update(Lugar lugar) {
    	String sql = "UPDATE LUGAR SET tipo=:tipo, nombre =:nombre, popularidad =:popularidad WHERE id =:id";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(lugar);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	
    	template.update(sql, param);
    }
  
    public void delete(int id) {
    	String sql = "DELETE FROM LUGAR WHERE id = ?";
    	jdbcTemplate.update(sql, id);
    }
	
}
