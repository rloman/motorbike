package nl.qien.motorbike.api;

import nl.qien.motorbike.components.Raceteam;
import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.services.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/motorbikes")
@CrossOrigin// (origins = {"http://localhost:4200", "http://192.168.1.20:3000"}, methods = {RequestMethod.POST, RequestMethod.PUT}, allowedHeaders = {"content-type"})
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @Autowired
    private Raceteam raceteam;

    @PostMapping
    public Motorbike create(@RequestBody Motorbike motorbike) {
        return this.motorbikeService.save(motorbike);
    }

    @GetMapping
    public ResponseEntity<Iterable<Motorbike>> list() {
        return ResponseEntity.ok(this.motorbikeService.findAll());
    }

    @GetMapping("/printTeam")
    public ResponseEntity<Raceteam> printteam() {

        System.out.println(this.raceteam);

        return ResponseEntity.ok(this.raceteam);
    }
}
