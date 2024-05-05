/**
 * @author RoseDao
 * @email huongtk35@gmail.com
 * @create date 2024-05-05 22:15:55
 * @modify date 2024-05-05 22:15:55
 * @desc [description]
 */

package com.udacity.vehicles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.vehicles.client.maps.MapsClient;
import com.udacity.vehicles.client.prices.PriceClient;
import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.car.CarRepository;

/**
 * Implements the car service create, read, update or delete
 * information about vehicles, as well as gather related
 * location and price data when desired.
 */
@Service
public class CarService {

    private final CarRepository carRepository;

    private final MapsClient mapsClient;

    private final PriceClient priceClient;

    public CarService(CarRepository repository, MapsClient mapsClient, PriceClient priceClient) {

        this.carRepository = repository;
        this.mapsClient = mapsClient;
        this.priceClient = priceClient;
    }

    /**
     * Gathers a list of all vehicles
     * @return a list of all vehicles in the CarRepository
     */
    public List<Car> list() {
        return carRepository.findAll();
    }

    /**
     * Gets car information by ID (or throws exception if non-existent)
     * @param id the ID number of the car to gather information on
     * @return the requested car's information, including location and price
     */
    public Car findById(Long id) {
        if(id == null) {
            return null;
        }

        Car car = this.carRepository.findById(id).orElseThrow(CarNotFoundException::new);
        car.setLocation(mapsClient.getAddress(car.getLocation()));
        car.setPrice(priceClient.getPrice(id));
        return car;
    }

    /**
     * Either creates or updates a vehicle, based on prior existence of car
     * @param car A car object, which can be either new or existing
     * @return the new/updated car is stored in the repository
     */
    public Car save(Car car) {
        if (car.getId() != null) {
            return carRepository.findById(car.getId())
                    .map(carToBeUpdated -> {
                        carToBeUpdated.setDetails(car.getDetails());
                        carToBeUpdated.setLocation(car.getLocation());
                        return carRepository.save(carToBeUpdated);
                    }).orElseThrow(CarNotFoundException::new);
        }

        return carRepository.save(car);
    }

    /**
     * Deletes a given car by ID
     * @param id the ID number of the car to delete
     */
    public void delete(Long id) {
        if(id != null) {
            Car car = this.carRepository.findById(id).orElseThrow(CarNotFoundException::new);
            this.carRepository.delete(car);
        }
    }
}
