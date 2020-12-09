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

@Controller
public class NewBirdSpottingController {

private SpottedBirdService birdSpottingService;
	
	@Autowired
	public void SpottedBirdbirdSpottingController(SpottedBirdService spottedBirdService) {
		this.birdSpottingService = spottedBirdService;
	}
	
	@GetMapping("/birdspotting/{name}/newbirdspotting")
	public String newBirdSpotting(@PathVariable("name") String locationName, Model model) {		
		model.addAttribute("spotLocation", locationName);
		model.addAttribute("birdSpecie", new BirdSpecie(new String(), 0, new String()));
		return "newBirdSpotting";
	}
	
	@PostMapping("/birdspotting/{name}/newbirdspotting")
	public String onSubmit(@PathVariable("name") String locationName, @Valid BirdSpecie birdSpecie, Model model, BindingResult result) {				
		if(result.hasErrors())return "newBirdSpotting";
		BirdSpotLocation location = birdSpottingService.findByName(locationName).get();
		location.newBirdSpot(birdSpecie);
		String url = "/birdspotting/" + locationName;
		return "redirect:" + url;
	}
	
}
