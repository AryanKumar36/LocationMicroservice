package com.ak.cabaggregator.rest;

import com.ak.cabaggregator.entity.Location;
import com.ak.cabaggregator.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationRestController {

    private final LocationService locationService;

    @Autowired
    public LocationRestController(LocationService theLocationService)
    {
        locationService = theLocationService;
    }


    @GetMapping("/all")
    public  List<Location> allDrivers()
    {
        return  locationService.getAllDrivers();
    }

    @PostMapping
    public Location saveLocation(@RequestBody Location location)
    {
        return locationService.saveLocation(location);
    }
    @GetMapping("/byDriver/{driverId}")
    public List<Location> getLocationByDriverId(@PathVariable String driverId)
    {
        return locationService.getLocationByDriverId(driverId);
    }

    @GetMapping("/drivers/near")
    public GeoResults<Location> getDriversInCircle(
            @RequestParam(required = false, defaultValue = "0.0") double lng,
            @RequestParam(required = false, defaultValue = "0.0") double lat,
            @RequestParam(required = false, defaultValue = "0.0") double radius,
            @RequestParam(required = false, defaultValue = "10") int limit)
    {
        System.out.println(lng + " " + lat+ " " +radius+ " " +limit );
        return locationService.getDriverInCircle(lng, lat, radius, limit);
    }

    @DeleteMapping("/byDriver/{driverId}")
    public void deleteDriverById(@PathVariable String driverId)
    {
        locationService.deleteByDriverId(driverId);
    }

}
