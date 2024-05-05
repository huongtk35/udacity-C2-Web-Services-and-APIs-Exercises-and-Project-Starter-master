/**
 * @author RoseDao
 * @email huongtk35@gmail.com
 * @create date 2024-05-05 22:15:45
 * @modify date 2024-05-05 22:15:45
 * @desc [description]
 */

package com.udacity.vehicles.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car not found")
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
