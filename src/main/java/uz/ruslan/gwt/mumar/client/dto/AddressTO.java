package uz.ruslan.gwt.mumar.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * User: User
 * Date: 08.12.2017 15:41
 */
public class AddressTO implements IsSerializable {
    private String houseNumber;
    private String streetName;
    private String county;
    private String postCode;
    private String country;

    public AddressTO() {
    }

    public AddressTO(String houseNumber, String streetName, String county, String postCode, String country) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.county = county;
        this.postCode = postCode;
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
