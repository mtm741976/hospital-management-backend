package tn.imed.jaberi.hospitalmanagement.patient;

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
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Patient>> getAllPatients() {

    List<Patient> result =  patientService.findAll();

      return new ResponseEntity<>(result, HttpStatus.OK);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
    
    Patient result = patientService.findById(id);
      return new ResponseEntity<>(result, HttpStatus.OK);

  }
  
  @PostMapping(value = {"", "/"})
  public ResponseEntity<Patient> createNewPatient(@Valid @RequestBody Patient Patient) {
    Patient result = patientService.save(Patient);
    
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePatient(@PathVariable String id) {
      patientService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
