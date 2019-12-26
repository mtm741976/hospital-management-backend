package tn.imed.jaberi.hospitalmanagement.patient;

import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

}
