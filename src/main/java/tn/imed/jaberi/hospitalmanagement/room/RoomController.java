package tn.imed.jaberi.hospitalmanagement.room;

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
@RequestMapping("/api/rooms")
public class RoomController {
  
	@Autowired
	private RoomService roomService;
	
  @GetMapping(value = {"", "/"})
  public ResponseEntity<List<Room>> getAllRooms() {

    List<Room> result =  roomService.findAll();

      return new ResponseEntity<>(result, HttpStatus.OK);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Room> getRoomById(@PathVariable String id) {
    
    Room result = roomService.findById(id);
      return new ResponseEntity<>(result, HttpStatus.OK);

  }
  
  @PostMapping(value = {"", "/"})
  public ResponseEntity<Room> createNewRoom(@Valid @RequestBody Room Room) {
    Room result = roomService.save(Room);
    
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Room> updateRoom(@Valid @RequestBody Room room, @PathVariable String id) {
      room.setId(id);
      Room result = roomService.update(room);
      return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRoom(@PathVariable String id) {
      roomService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
