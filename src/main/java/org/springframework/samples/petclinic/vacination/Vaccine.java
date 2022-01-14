package org.springframework.samples.petclinic.vacination;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="vaccines")
@Getter
@Setter
public class Vaccine extends BaseEntity{
	@Size(min=3, max=50)
	@Column(name="name", unique=true)
	@NotNull
    String name;
	
	@PositiveOrZero
    Double price;
	
    @ManyToOne
    @JoinColumn(name="pet_type_id")
    PetType petType;
}
