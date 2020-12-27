package com.example.birdspotting;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.birdspotting.domain.BirdSpotLocation;
import com.example.birdspotting.service.SpottedBirdService;

@Controller
public class BirdSpottingController {

	private SpottedBirdService birdSpottingService;
	
	@Autowired
	public void SpottedBirdbirdSpottingController(SpottedBirdService spottedBirdService) {
		this.birdSpottingService = spottedBirdService;
	}
	
	@GetMapping("/birdspotting")
	public String getHome(Model model) {
		model.addAttribute("spottingLocations", birdSpottingService.findAll());
		return "birdspotting";
	}
		
	
	@GetMapping("/birdspotting/{spotLocation}")
	public String show(@PathVariable("spotLocation") String locationName, Model model) {
		Optional<BirdSpotLocation> optLocation = birdSpottingService.findByName(locationName);		
		if(optLocation == null) {
			return "redirect:/birdspotting";
		}
		BirdSpotLocation location = optLocation.get();
		model.addAttribute("spotLocation", location);
		return "locationdetails";
	}
}
