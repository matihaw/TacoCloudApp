package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.netty.handler.codec.http.HttpContentEncoder.Result;
import tacos.Ingredient;


@Repository
public class JdbcIngredientRepository implements IngredientRepository{
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbc.query("SELECT id, name, type FROM Ingredient",
				this::mapRowToIngredient);
	}

	@Override
	public Ingredient findById(String id) {
		return jdbc.queryForObject(
				"SELECY id, name, type FROM Ingredient WHERE id=?",
				this::mapRowToIngredient, id);

	}

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
			throws SQLException{
		return new Ingredient(
				rs.getString("id"), 
				rs.getString("name"),
				Ingredient.Type.valueOf(rs.getString("type"))
				);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbc.update(
				"INSERT INTO Ingredient (id, name, type) VALUES (?, ?, ?)",
				ingredient.getId(),
				ingredient.getName(),
				ingredient.getType().toString()
				);
		return ingredient;
		
		
	}
}
