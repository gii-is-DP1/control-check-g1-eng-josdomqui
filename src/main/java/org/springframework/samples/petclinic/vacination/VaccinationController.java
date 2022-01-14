package org.springframework.samples.petclinic.vacination;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import antlr.collections.List;

@Controller
public class VaccinationController {
	
	private final VaccinationService vaccinationService;

	public VaccinationController(VaccinationService vaccinationService) {
		super();
		this.vaccinationService = vaccinationService;
	}
	
	@GetMapping(value = "/vaccination/create")
	public String initCreationForm(Map<String, Object> model) {
		Vaccination vacunacion = new Vaccination();
//		List<Vaccine> tipos = this.vaccinationService.getAllVaccines();
		model.put("vacunacion", vacunacion);
//		model.put("tipos", tipos);
		return "products/createOrVaccinationForm";
	}
	
 
}
