package cat.itacademy.s04.t02.n03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruit")
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
