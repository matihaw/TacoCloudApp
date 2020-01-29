package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {
	
	private Long id;
	
	private Date placedAt;
	
	@NotBlank(message = "To pole jest wymagane!")
	private String name;
	
	@NotBlank(message = "To pole jest wymagane!")
	private String street;
	
	@NotBlank(message = "To pole jest wymagane!")
	private String city;
	
	@NotBlank(message = "To pole jest wymagane!")
	private String state;
	
	@NotBlank(message = "To pole jest wymagane!")
	private String zip;
	
	@CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", 
			message = "Podaj date wygasniecia karty w formacie MM/RR")
	private String ccExpiration;
	
	@Digits(integer = 3,fraction = 0,message = "Nieprawidłowy kod CVV")
	private String ccCVV;
	
	private List<Taco> tacos = new ArrayList<>();
	
	public void addDesign(Taco design) {
	    this.tacos.add(design);
	  }
}
