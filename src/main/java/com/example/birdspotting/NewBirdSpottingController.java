package com.example.birdspotting;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.birdspotting.domain.BirdSpecie;
import com.example.birdspotting.domain.BirdSpotLocation;
import com.example.birdspotting.domain.SpottedBird;
import com.example.birdspotting.service.SpottedBirdService;
import com.example.birdspotting.validator.NewBirdSpottingValidation;

@Controller
public class NewBirdSpottingController {

private SpottedBirdService birdSpottingService;
	
	@Autowired
	public void SpottedBirdbirdSpottingController(SpottedBirdService spottedBirdService) {
		this.birdSpottingService = spottedBirdService;
	}
	@Autowired
	private NewBirdSpottingValidation newBirdSpottingValidation;
	
	@GetMapping("/birdspotting/{spotLocation}/newbirdspotting")
	public String newBirdSpotting(@PathVariable("spotLocation") String locationName, Model model) {		
		model.addAttribute("spotLocation", locationName);
		model.addAttribute("birdSpecie", new BirdSpecie(new String(), 0, new String()));
		return "newBirdSpotting";
	}
	
	@PostMapping("/birdspotting/{spotLocation}/newbirdspotting")
	public String onSubmit(@PathVariable("spotLocation") String locationName, @Valid BirdSpecie birdSpecie, BindingResult result) {				
		newBirdSpottingValidation.validate(birdSpecie, result);
		if(result.hasErrors()) {
			return "newBirdSpotting";
		}		
		BirdSpotLocation location = birdSpottingService.findByName(locationName).get();
		location.increaseBirdSpot(birdSpecie);
		String url = "/birdspotting/" + locationName;
		return "redirect:" + url;
	}
	
}
