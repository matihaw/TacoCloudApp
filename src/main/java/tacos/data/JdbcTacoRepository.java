package tacos.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import tacos.Ingredient;
import tacos.Taco;

@Repository
public class JdbcTacoRepository implements TacoRepository{
	
	private JdbcTemplate jdbc;
	
	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);
		for (Ingredient ingredient : taco.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
		}
		return taco;
	}
	
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new java.util.Date());
		PreparedStatementCreator psc =
				new PreparedStatementCreatorFactory(
						"INSERT INTO Taco (name,createdAt) VALUES (?,?)",
						Types.VARCHAR,Types.TIMESTAMP).newPreparedStatementCreator(
								Arrays.asList(
										taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));
		
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbc.update(psc, keyHolder);
		 
		 return keyHolder.getKey().longValue();

		}
	private void saveIngredientToTaco(
			Ingredient ingredient, long tacoId) {
		jdbc.update(
				"INSERT INTO Taco_Ingredients (taco, ingredient) "
				+ "Values (?,?)",tacoId, ingredient.getId());
		
	}

}
