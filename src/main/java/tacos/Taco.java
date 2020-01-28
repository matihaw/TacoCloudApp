package tacos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	private Long id;
	
	private  Date createdAt;
	
	@NotNull
	@Size(min=5, message="Nazwa musi składać się przynajmniej z pięciu znaków.")
	private String name;
	
	@Size(min = 1, message = "Musisz wybrać przynajmniej jeden skłądnik.")
	private List<Ingredient> ingredients;
}
