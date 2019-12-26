package tn.imed.jaberi.hospitalmanagement.patient;

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
