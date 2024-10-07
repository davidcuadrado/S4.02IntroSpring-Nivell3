package cat.itacademy.s04.t02.n03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

	@Autowired
	private FruitRepository fruitRepository;

	@Transactional
	public Fruit addFruit(Fruit fruit) {
		return fruitRepository.save(fruit);
	}

	@Transactional
	public Fruit updateFruit(Fruit fruit) {
		if (fruitRepository.existsById(fruit.getId())) {
			return fruitRepository.save(fruit);
		} else {
			throw new IllegalArgumentException("Fruit ID not found.");
		}
	}

	@Transactional
	public void deleteFruit(int id) {
		if (fruitRepository.existsById(id)) {
			fruitRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Fruit ID not found.");
		}
	}

	@Transactional(readOnly = true)
	public Fruit getFruitById(int id) {
		Optional<Fruit> fruit = fruitRepository.findById(id);
		return fruit.orElseThrow(() -> new IllegalArgumentException("Fruit ID not found."));
	}

	@Transactional(readOnly = true)
	public List<Fruit> getAllFruits() {
		return fruitRepository.findAll();
	}
}
