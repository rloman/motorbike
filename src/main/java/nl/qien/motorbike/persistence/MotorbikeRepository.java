package nl.qien.motorbike.persistence;

import nl.qien.motorbike.model.Motorbike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorbikeRepository extends CrudRepository <Motorbike, Long> {

  List<Motorbike> findAll();
}
