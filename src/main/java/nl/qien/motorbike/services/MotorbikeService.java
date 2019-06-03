package nl.qien.motorbike.services;

import nl.qien.motorbike.aop.Timed;
import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.persistence.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {

    private MotorbikeRepository motorbikeRepository;

    public MotorbikeService(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    public Motorbike save(Motorbike motorbike) {

        return this.motorbikeRepository.save(motorbike);
    }

    public Optional<Motorbike> findById(Long aLong) {
        return motorbikeRepository.findById(aLong);
    }

    @Timed
    public List<Motorbike> findAll() {
        return motorbikeRepository.findAll();
    }

    public void deleteById(Long aLong) {
        motorbikeRepository.deleteById(aLong);
    }
}
