package com.example.demo.repository;

import com.example.demo.entity.Event;
import com.example.demo.entity.EventStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

public interface EventRepository extends JpaRepository<Event, Long>{
}