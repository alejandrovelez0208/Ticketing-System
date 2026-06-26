package com.ticketing_system.inventoryservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketing_system.inventoryservice.dto.response.EventInventoryResponse;
import com.ticketing_system.inventoryservice.dto.response.VenueInventoryResponse;
import com.ticketing_system.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping("/inventory/events")
	public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents() {
		return inventoryService.getAllEvents();
	}

	@GetMapping("/inventory/venue/{venueId}")
	public @ResponseBody VenueInventoryResponse inventoryByVenueId(@PathVariable("venueId") Long venueId) {
		return inventoryService.getVenueInformation(venueId);
	}
}
