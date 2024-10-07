package cat.itacademy.s04.t02.n03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.itacademy.s04.t02.n03.model.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

}
