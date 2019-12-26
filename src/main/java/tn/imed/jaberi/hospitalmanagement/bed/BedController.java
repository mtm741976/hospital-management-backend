package tn.imed.jaberi.hospitalmanagement.bed;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/beds")
public class BedController {
	
	@Autowired
	private BedService bedService;
	
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Bed>> getAllBeds() {

    	List<Bed> result =  bedService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBedById(@PathVariable String id) {
    	
    	Bed result = bedService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Bed> createNewBed(@Valid @RequestBody Bed bed) {
    	Bed result = bedService.save(bed);
    	
    	return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBed(@PathVariable String id) {
        bedService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
