package tn.imed.jaberi.hospitalmanagement.doctor;

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
@RequestMapping("/api/doctors")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Doctor>> getAllDoctors() {

    List<Doctor> result =  doctorService.findAll();

      return new ResponseEntity<>(result, HttpStatus.OK);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
    
    Doctor result = doctorService.findById(id);
      return new ResponseEntity<>(result, HttpStatus.OK);

  }
  
  @PostMapping(value = {"", "/"})
  public ResponseEntity<Doctor> createNewDoctor(@Valid @RequestBody Doctor Doctor) {
    Doctor result = doctorService.save(Doctor);
    
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Doctor> updateDoctor(@Valid @RequestBody Doctor doctor, @PathVariable String id) {
      doctor.setId(id);
      Doctor result = doctorService.update(doctor);
      return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDoctor(@PathVariable String id) {
      doctorService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
