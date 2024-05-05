/**
 * @author RoseDao
 * @email huongtk35@gmail.com
 * @create date 2024-05-05 22:14:45
 * @modify date 2024-05-05 22:14:45
 * @desc [description]
 */

package com.udacity.vehicles.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
