package cat.itacademy.s04.t02.n03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.services.FruitService;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

	@Autowired
	private FruitService fruitService;

	@PostMapping("/add")
	public ResponseEntity<Fruit> add(@RequestBody Fruit fruit) {
		Fruit newFruit = fruitService.addFruit(fruit);
		return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Fruit> update(@RequestBody Fruit fruit) {
		try {
			Fruit updatedFruit = fruitService.updateFruit(fruit);
			return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		try {
			fruitService.deleteFruit(id);
			return new ResponseEntity<>("Fruit ID: " + id + " has been deleted.", HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>("Fruit ID: " + id + " not found.", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruit> getOne(@PathVariable int id) {
		try {
			Fruit fruit = fruitService.getFruitById(id);
			return new ResponseEntity<>(fruit, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Fruit>> getAll() {
		List<Fruit> fruits = fruitService.getAllFruits();
		return new ResponseEntity<>(fruits, HttpStatus.OK);
	}
}
