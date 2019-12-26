package tn.imed.jaberi.hospitalmanagement.bed;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BedService {

	@Autowired
    private BedRepository bedRepository;
	
  
  public List<Bed> findAll() {
    return bedRepository.findAll();
  }
    
  
  public Bed findById(String id) {
    try {
         return bedRepository.findById(id).get();
	  } catch (NoSuchElementException  ex) {
		  // should handle all ex .. 
		  return null;
	  }
  }
    

  public Bed save(Bed bed) {
    return bedRepository.insert(bed);
  }
  
  
  public Bed update(Bed bed) {
	return bedRepository.save(bed);
	  
  }
    
  public void delete(String id) {
    bedRepository.deleteById(id);
  }
  
}