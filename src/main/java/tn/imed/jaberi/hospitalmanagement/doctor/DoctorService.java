package tn.imed.jaberi.hospitalmanagement.doctor;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;
	
  
  public List<Doctor> findAll() {
    return doctorRepository.findAll();
  }
    
  
  public Doctor findById(String id) {
    try {
         return doctorRepository.findById(id).get();
	  } catch (NoSuchElementException  ex) {
		  // should handle all ex .. 
		  return null;
	  }
  }
    

  public Doctor save(Doctor doctor) {
    return doctorRepository.insert(doctor);
  }
  
  
  public Doctor update(Doctor doctor) {
	  return doctorRepository.save(doctor);
  }
    
  public void delete(String id) {
    doctorRepository.deleteById(id);
  }
 
}
