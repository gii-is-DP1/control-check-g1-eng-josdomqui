package org.springframework.samples.petclinic.vacination;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationRepository extends CrudRepository<Vaccination, Integer>{
    List<Vaccination> findAll();
    @Query("SELECT vaccines FROM Vaccine vaccines")
    List<Vaccine> findAllVaccines();
    Optional<Vaccination> findById(int id);
    @Query("SELECT vaccine FROM Vaccine vaccine WHERE vaccine.name=:name")
    Vaccine findVaccineByName(String name);
}
