package cat.itacademy.s04.t02.n03.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import cat.itacademy.s04.t02.n03.model.Fruit;


public interface FruitRepository extends MongoRepository<Fruit, Integer> {

}
