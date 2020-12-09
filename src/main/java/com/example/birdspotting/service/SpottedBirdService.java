package com.example.birdspotting.service;

import java.util.List;
import java.util.Optional;

import com.example.birdspotting.domain.BirdSpotLocation;

public interface SpottedBirdService {

    public List<BirdSpotLocation> findAll();

    public Optional<BirdSpotLocation> findByName(String name);
}