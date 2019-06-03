package nl.qien.motorbike.services;

import nl.qien.motorbike.model.Motorbike;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class MotorBikeRepoMock  implements CrudRepository<Motorbike, Long> {


    @Override
    public Motorbike  save(Motorbike s) {
        return null;
    }


    @Override
    public <S extends Motorbike> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Motorbike> findById(Long aLong) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Motorbike> findAll() {
        return null;
    }

    @Override
    public Iterable<Motorbike> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Motorbike motorbike) {

    }

    @Override
    public void deleteAll(Iterable<? extends Motorbike> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
