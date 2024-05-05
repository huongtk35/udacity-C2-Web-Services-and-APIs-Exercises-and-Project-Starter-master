/**
 * @author RoseDao
 * @email huongtk35@gmail.com
 * @create date 2024-05-05 22:10:02
 * @modify date 2024-05-05 22:10:02
 * @desc [description]
 */

package com.udacity.boogle.maps;

/**
 * Declares a class to store an address, city, state and zip code.`
 */
public class Address {

    private String address;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(String address, String city, String state, String zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
