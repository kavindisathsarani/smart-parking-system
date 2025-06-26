package com.spms.parkingspace.controller;

import com.spms.parkingspace.dto.ParkingSpaceRequest;
import com.spms.parkingspace.dto.ReservationRequest;
import com.spms.parkingspace.model.ParkingSpace;
import com.spms.parkingspace.model.ParkingSpace.SpaceStatus;
import com.spms.parkingspace.service.ParkingSpaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing parking spaces.
 * Provides endpoints for CRUD operations on parking spaces, reservations, and status updates.
 */
@RestController
@RequestMapping("/api/v1/parking-spaces")
@CrossOrigin(origins = "*")
public class ParkingSpaceController {
    
    @Autowired
    private ParkingSpaceService parkingSpaceService;  // Service layer for parking space operations
    
    /**
     * Retrieves all parking spaces.
     *
     * @return List of all parking spaces with HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<ParkingSpace>> getAllParkingSpaces() {
        List<ParkingSpace> spaces = parkingSpaceService.getAllParkingSpaces();
        return ResponseEntity.ok(spaces);
    }
    
    /**
     * Retrieves a specific parking space by its ID.
     *
     * @param id The ID of the parking space to retrieve
     * @return The requested parking space with HTTP 200 OK if found, 404 Not Found otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpaceById(@PathVariable("id") Long id) {
        try {
            ParkingSpace space = parkingSpaceService.getParkingSpaceById(id);
            return ResponseEntity.ok(space);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Creates a new parking space.
     *
     * @param request DTO containing parking space details
     * @return The created parking space with HTTP 201 Created if successful, 400 Bad Request otherwise
     */
    @PostMapping
    public ResponseEntity<ParkingSpace> createParkingSpace(@Valid @RequestBody ParkingSpaceRequest request) {
        try {
            ParkingSpace createdSpace = parkingSpaceService.createParkingSpace(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Updates an existing parking space.
     *
     * @param id The ID of the parking space to update
     * @param request DTO containing updated parking space details
     * @return The updated parking space with HTTP 200 OK if found, 404 Not Found otherwise
     */
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(@PathVariable("id") Long id,
                                                         @Valid @RequestBody ParkingSpaceRequest request) {
        try {
            ParkingSpace updatedSpace = parkingSpaceService.updateParkingSpace(id, request);
            return ResponseEntity.ok(updatedSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Deletes a parking space by its ID.
     *
     * @param id The ID of the parking space to delete
     * @return HTTP 204 No Content if successful, 404 Not Found otherwise
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpace(@PathVariable("id") Long id) {
        try {
            parkingSpaceService.deleteParkingSpace(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Retrieves all available parking spaces.
     *
     * @return List of available parking spaces with HTTP 200 OK
     */
    @GetMapping("/available")
    public ResponseEntity<List<ParkingSpace>> getAvailableParkingSpaces() {
        List<ParkingSpace> availableSpaces = parkingSpaceService.getAvailableParkingSpaces();
        return ResponseEntity.ok(availableSpaces);
    }
    
    /**
     * Retrieves parking spaces by city.
     *
     * @param city The city to filter parking spaces by
     * @return List of parking spaces in the specified city with HTTP 200 OK
     */
    @GetMapping("/city/{city}")
    public ResponseEntity<List<ParkingSpace>> getParkingSpacesByCity(@PathVariable("city") String city) {
        List<ParkingSpace> spaces = parkingSpaceService.getParkingSpacesByCity(city);
        return ResponseEntity.ok(spaces);
    }
    
    /**
     * Retrieves parking spaces by zone.
     *
     * @param zone The zone to filter parking spaces by
     * @return List of parking spaces in the specified zone with HTTP 200 OK
     */
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<ParkingSpace>> getParkingSpacesByZone(@PathVariable("zone") String zone) {
        List<ParkingSpace> spaces = parkingSpaceService.getParkingSpacesByZone(zone);
        return ResponseEntity.ok(spaces);
    }
    
    /**
     * Retrieves parking spaces by owner ID.
     *
     * @param ownerId The ID of the owner
     * @return List of parking spaces owned by the specified owner with HTTP 200 OK
     */
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<ParkingSpace>> getParkingSpacesByOwner(@PathVariable("ownerId") String ownerId) {
        List<ParkingSpace> spaces = parkingSpaceService.getParkingSpacesByOwner(ownerId);
        return ResponseEntity.ok(spaces);
    }
    
    /**
     * Retrieves available parking spaces in a specific city.
     *
     * @param city The city to filter available parking spaces by
     * @return List of available parking spaces in the specified city with HTTP 200 OK
     */
    @GetMapping("/available/city/{city}")
    public ResponseEntity<List<ParkingSpace>> getAvailableParkingSpacesByCity(@PathVariable("city") String city) {
        List<ParkingSpace> spaces = parkingSpaceService.getAvailableParkingSpacesByCity(city);
        return ResponseEntity.ok(spaces);
    }
    
    /**
     * Retrieves available parking spaces in a specific zone.
     *
     * @param zone The zone to filter available parking spaces by
     * @return List of available parking spaces in the specified zone with HTTP 200 OK
     */
    @GetMapping("/available/zone/{zone}")
    public ResponseEntity<List<ParkingSpace>> getAvailableParkingSpacesByZone(@PathVariable("zone") String zone) {
        List<ParkingSpace> spaces = parkingSpaceService.getAvailableParkingSpacesByZone(zone);
        return ResponseEntity.ok(spaces);
    }
    
    /**
     * Reserves a parking space.
     *
     * @param request DTO containing reservation details
     * @return The reserved parking space with HTTP 200 OK if successful, 400 Bad Request otherwise
     */
    @PostMapping("/reserve")
    public ResponseEntity<ParkingSpace> reserveParkingSpace(@Valid @RequestBody ReservationRequest request) {
        try {
            ParkingSpace reservedSpace = parkingSpaceService.reserveParkingSpace(request);
            return ResponseEntity.ok(reservedSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Releases a reserved parking space.
     *
     * @param id The ID of the parking space to release
     * @return The released parking space with HTTP 200 OK if found, 404 Not Found otherwise
     */
    @PutMapping("/{id}/release")
    public ResponseEntity<ParkingSpace> releaseParkingSpace(@PathVariable("id") Long id) {
        try {
            ParkingSpace releasedSpace = parkingSpaceService.releaseParkingSpace(id);
            return ResponseEntity.ok(releasedSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Marks a parking space as occupied.
     *
     * @param id The ID of the parking space to mark as occupied
     * @return The occupied parking space with HTTP 200 OK if successful, 400 Bad Request otherwise
     */
    @PutMapping("/{id}/occupy")
    public ResponseEntity<ParkingSpace> occupyParkingSpace(@PathVariable("id") Long id) {
        try {
            ParkingSpace occupiedSpace = parkingSpaceService.occupyParkingSpace(id);
            return ResponseEntity.ok(occupiedSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Updates the status of a parking space.
     *
     * @param id The ID of the parking space to update
     * @param status The new status to set
     * @return The updated parking space with HTTP 200 OK if found, 404 Not Found otherwise
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<ParkingSpace> updateSpaceStatus(@PathVariable("id") Long id,
                                                        @RequestParam SpaceStatus status) {
        try {
            ParkingSpace updatedSpace = parkingSpaceService.updateSpaceStatus(id, status);
            return ResponseEntity.ok(updatedSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Retrieves parking statistics.
     *
     * @return Map containing parking statistics with HTTP 200 OK
     */
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getParkingStatistics() {
        Map<String, Object> stats = parkingSpaceService.getParkingStatistics();
        return ResponseEntity.ok(stats);
    }
    
    /**
     * Retrieves parking statistics for a specific city.
     *
     * @param city The city to get statistics for
     * @return Map containing parking statistics for the specified city with HTTP 200 OK
     */
    @GetMapping("/statistics/city/{city}")
    public ResponseEntity<Map<String, Object>> getParkingStatisticsByCity(@PathVariable("city") String city) {
        Map<String, Object> stats = parkingSpaceService.getParkingStatisticsByCity(city);
        return ResponseEntity.ok(stats);
    }
}