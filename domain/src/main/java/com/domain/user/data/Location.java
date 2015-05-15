
package com.domain.user.data;

import com.google.gson.annotations.Expose;

public class Location {

    @Expose
    private String street;
    @Expose
    private String city;
    @Expose
    private String state;
    @Expose
    private String zip;

    /**
     * 
     * @return
     *     The street
     */
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street
     *     The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    public Location withStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    public Location withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    public Location withState(String state) {
        this.state = state;
        return this;
    }

    /**
     * 
     * @return
     *     The zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * 
     * @param zip
     *     The zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    public Location withZip(String zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(street);
        builder.append(", ");
        builder.append(city);
        builder.append(", ");
        builder.append(state);
        builder.append(", ");
        builder.append(zip);
        return builder.toString();
    }
}
