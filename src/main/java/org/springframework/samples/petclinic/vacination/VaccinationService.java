package org.springframework.samples.petclinic.vacination;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VaccinationService {
	
	private final VaccinationRepository vaccinationRepository;
	
	@Autowired
    public VaccinationService(VaccinationRepository vaccinationRepository) {
		this.vaccinationRepository = vaccinationRepository;
	}

	public List<Vaccination> getAll(){
        return this.vaccinationRepository.findAll();
    }

    public List<Vaccine> getAllVaccines(){
        return null;
    }

    public Vaccine getVaccine(String typeName) {
        return this.vaccinationRepository.findVaccineByName(typeName);
    }

    public Vaccination save(Vaccination p) throws UnfeasibleVaccinationException {        
        Optional<Vaccination> rest1 = this.vaccinationRepository.findById(p.getId());
        List<Vaccine> rest2 = this.vaccinationRepository.findAllVaccines();
//        if (rest1!=rest2) {            	
//        	throw new DuplicatedPetNameException();
//        }else
        	return vaccinationRepository.save(p);            
    }
    
}
