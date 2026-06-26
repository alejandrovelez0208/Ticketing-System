package com.ticketing_system.inventoryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ticketing_system.inventoryservice.dto.response.EventInventoryResponse;
import com.ticketing_system.inventoryservice.dto.response.VenueInventoryResponse;
import com.ticketing_system.inventoryservice.entity.Event;
import com.ticketing_system.inventoryservice.entity.Venue;
import com.ticketing_system.inventoryservice.repository.EventRepository;
import com.ticketing_system.inventoryservice.repository.VenueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final EventRepository eventRepository;

	private final VenueRepository venueRepository;

	public List<EventInventoryResponse> getAllEvents() {
		final List<Event> events = eventRepository.findAll();

		return events
				.stream().map(event -> EventInventoryResponse.builder().event(event.getName())
						.capacity(event.getLeftCapacity()).venue(event.getVenue()).build())
				.collect(Collectors.toList());
	}

	public VenueInventoryResponse getVenueInformation(Long venueId) {
		final Venue venue = venueRepository.findById(venueId).orElseThrow(null);

		return VenueInventoryResponse.builder().venueId(venue.getId()).venueName(venue.getName())
				.totalCapacity(venue.getTotal_capacity()).build();
	}
}
