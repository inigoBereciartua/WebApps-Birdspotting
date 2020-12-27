package com.example.birdspotting.validator;

import java.time.Year;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.birdspotting.domain.BirdSpecie;

public class NewBirdSpottingValidation implements Validator{

		@Override
		public boolean supports(Class<?> clazz) {
			return BirdSpecie.class.isAssignableFrom(clazz);		
		}

		@Override
		public void validate(Object target, Errors errors) {
			BirdSpecie birdSpecie = (BirdSpecie) target;		
			System.out.println(birdSpecie);
			if(birdSpecie == null) {
				System.out.println("HERE");
				return;
			}
			else if(birdSpecie.getYearOfDiscovery() == null) {
				errors.rejectValue(
						"yearOfDiscovery",
						"birdSpecie.yearOfDiscovery.digits",
						"Can contain only digits.");				
			}
			
			else if(birdSpecie.getYearOfDiscovery() > Year.now().getValue()) {
				errors.rejectValue(
						"yearOfDiscovery",
						"birdSpecie.yearOfDiscovery.future",
						"Can't discover birds in the future." );
			}
		}	
}
