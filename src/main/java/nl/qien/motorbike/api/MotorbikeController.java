package nl.qien.motorbike.api;

import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.persistence.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/motorbikes")
@CrossOrigin// (origins = {"http://localhost:4200", "http://192.168.1.20:3000"}, methods = {RequestMethod.POST, RequestMethod.PUT}, allowedHeaders = {"content-type"})
public class MotorbikeController {

    @Autowired
    private MotorbikeRepository repository;

    @PostMapping
    public Motorbike create(@RequestBody Motorbike motorbike) {
        return this.repository.save(motorbike);
    }

    @GetMapping
    public ResponseEntity<Iterable<Motorbike>> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
