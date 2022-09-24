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
public class CosmeticoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CosmeticoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Cosmetico> list() {
		String sql = "SELECT * FROM COSMETICO";
		
		List<Cosmetico> listCosmetico = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cosmetico.class));
		
        return listCosmetico;
    }
  
    public void save(Cosmetico cosmetico) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
    	insertActor.withTableName("cosmetico").usingColumns("tipo", "nombre", "rareza", "precio");
    	
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(cosmetico);
    	insertActor.execute(param);
    }
  
    public Cosmetico get(int id) {
    	String sql = "SELECT * FROM COSMETICO WHERE id = ?";
    	Object[] args = {id};
    	Cosmetico cosmetico = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Cosmetico.class));
        return cosmetico;
    }
  
    public void update(Cosmetico cosmetico) {
    	String sql = "UPDATE COSMETICO SET tipo=:tipo, nombre =:nombre, rareza =:rareza, precio =:precio WHERE id =:id";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(cosmetico);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	
    	template.update(sql, param);
    }
  
    public void delete(int id) {
    	String sql = "DELETE FROM COSMETICO WHERE id = ?";
    	jdbcTemplate.update(sql, id);
    }
	
}
