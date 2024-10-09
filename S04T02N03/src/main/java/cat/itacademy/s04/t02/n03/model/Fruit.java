package cat.itacademy.s04.t02.n03.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@Document(collection = "Fruits")
@Configuration
@EnableMongoRepositories(basePackages = "cat.itacademy.s04.t02.n03")
public class Fruit {

	@Id
	private int id;
	private String name;
	private int kiloQuantity;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKiloQuantity() {
		return kiloQuantity;
	}

	public void setKiloQuantity(int kiloQuantity) {
		this.kiloQuantity = kiloQuantity;
	}

	public String toString() {
		return "Fruit ID: " + id + "\nName: " + name + "\nQuantity (kg): " + kiloQuantity + " \n ";
	}

}
