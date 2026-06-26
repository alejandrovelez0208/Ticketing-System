package com.ticketing_system.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing_system.inventoryservice.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
