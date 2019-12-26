package tn.imed.jaberi.hospitalmanagement.room;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

  @Autowired
  private RoomRepository roomRepository;
	
  
  public List<Room> findAll() {
    return roomRepository.findAll();
  }
    
  
  public Room findById(String id) {
    try {
         return roomRepository.findById(id).get();
	  } catch (NoSuchElementException  ex) {
		  // should handle all ex .. 
		  return null;
	  }
  }
    

  public Room save(Room Room) {
    return roomRepository.insert(Room);
  }
  
  
  public Room update(Room Room) {
	  return roomRepository.save(Room);
  }
    
  public void delete(String id) {
    roomRepository.deleteById(id);
  }

}
