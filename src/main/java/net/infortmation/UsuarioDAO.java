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
public class UsuarioDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UsuarioDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Usuario> list() {
		String sql = "SELECT * FROM USUARIO";
		
		List<Usuario> listUsuario = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));
		
        return listUsuario;
    }
  
    public void save(Usuario usuario) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
    	insertActor.withTableName("usuario").usingColumns("username", "password", "correo");
    	
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usuario);
    	insertActor.execute(param);
    }
  
    public Usuario get(String id) {
    	String sql = "SELECT * FROM USUARIO WHERE username = ?";
    	Object[] args = {id};
    	Usuario usuario = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Usuario.class));
        return usuario;
    }
  
    public void update(Usuario usuario) {
    	String sql = "UPDATE USUARIO SET password =:password, correo=:correo WHERE username =:username";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usuario);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	
    	template.update(sql, param);
    }
  
    public void delete(String id) {
    	String sql = "DELETE FROM USUARIO WHERE username = ?";
    	jdbcTemplate.update(sql, id);
    }
}
