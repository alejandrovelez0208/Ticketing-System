package com.ticketing_system.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing_system.inventoryservice.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
