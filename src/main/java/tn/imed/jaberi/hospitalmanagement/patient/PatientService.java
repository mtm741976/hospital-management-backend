package tn.imed.jaberi.hospitalmanagement.patient;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

  @Autowired
  private PatientRepository patientRepository;
	
  
  public List<Patient> findAll() {
    return patientRepository.findAll();
  }
    
  
  public Patient findById(String id) {
    try {
         return patientRepository.findById(id).get();
	  } catch (NoSuchElementException  ex) {
		  // should handle all ex .. 
		  return null;
	  }
  }
    

  public Patient save(Patient Patient) {
    return patientRepository.insert(Patient);
  }
  
  
  public Patient update(Patient Patient) {
	  return patientRepository.save(Patient);
  }
    
  public void delete(String id) {
    patientRepository.deleteById(id);
  }

}
