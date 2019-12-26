package tn.imed.jaberi.hospitalmanagement.bed;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends MongoRepository<Bed, String> {

}
