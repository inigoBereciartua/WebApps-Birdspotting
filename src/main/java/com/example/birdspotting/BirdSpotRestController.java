package com.example.birdspotting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.birdspotting.domain.BirdSpotLocation;
import com.example.birdspotting.domain.SpottedBird;
import com.example.birdspotting.service.SpottedBirdService;

@RestController
@RequestMapping(value="/bird-spotted")
public class BirdSpotRestController {

	private SpottedBirdService birdSpottingService;
	
	@Autowired
	public void SpottedBirdbirdSpottingController(SpottedBirdService spottedBirdService) {
		this.birdSpottingService = spottedBirdService;
	}
	
	@GetMapping(value = "/{spotLocation}")
	public List<SpottedBird> show(@PathVariable("spotLocation") String locationName) {
		Optional<BirdSpotLocation> optLocation = birdSpottingService.findByName(locationName);
		if(optLocation.isPresent()) {
			return optLocation.get().getSpottedBirds();
		}
		return new ArrayList<SpottedBird>();
	}
}
