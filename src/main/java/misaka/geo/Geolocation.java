package misaka.geo;

import artoria.util.StringUtils;

import java.io.Serializable;

import static artoria.common.Constants.EMPTY_STRING;

/**
 * Geographical location object.
 * @see <a href="https://en.wikipedia.org/wiki/Geolocation">Geolocation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Geocode">Geocode</a>
 * @author Kahle
 */
public class Geolocation implements GeoCoordinate, Serializable {
    /**
     * Country.
     */
    private String country;
    /**
     * Country code.
     */
    private String countryCode;
    /**
     * Province or state.
     */
    private String region;
    /**
     * Region code.
     */
    private String regionCode;
    /**
     * City.
     */
    private String city;
    /**
     * City code.
     */
    private String cityCode;
    /**
     * County, town or district.
     */
    private String district;
    /**
     * District code.
     */
    private String districtCode;
    /**
     * Street.
     */
    private String street;
    /**
     * Street code.
     */
    private String streetCode;
    /**
     * Latitude.
     */
    private Double latitude;
    /**
     * Longitude.
     */
    private Double longitude;
    /**
     * Elevation.
     */
    private Double elevation;

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getCountryCode() {

        return countryCode;
    }

    public void setCountryCode(String countryCode) {

        this.countryCode = countryCode;
    }

    public String getRegion() {

        return region;
    }

    public void setRegion(String region) {

        this.region = region;
    }

    public String getRegionCode() {

        return regionCode;
    }

    public void setRegionCode(String regionCode) {

        this.regionCode = regionCode;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getCityCode() {

        return cityCode;
    }

    public void setCityCode(String cityCode) {

        this.cityCode = cityCode;
    }

    public String getDistrict() {

        return district;
    }

    public void setDistrict(String district) {

        this.district = district;
    }

    public String getDistrictCode() {

        return districtCode;
    }

    public void setDistrictCode(String districtCode) {

        this.districtCode = districtCode;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public String getStreetCode() {

        return streetCode;
    }

    public void setStreetCode(String streetCode) {

        this.streetCode = streetCode;
    }

    @Override
    public Double getLatitude() {

        return latitude;
    }

    @Override
    public void setLatitude(Double latitude) {

        this.latitude = latitude;
    }

    @Override
    public Double getLongitude() {

        return longitude;
    }

    @Override
    public void setLongitude(Double longitude) {

        this.longitude = longitude;
    }

    @Override
    public Double getElevation() {

        return elevation;
    }

    @Override
    public void setElevation(Double elevation) {

        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return (StringUtils.isNotBlank(country) ? country : EMPTY_STRING)
                + (StringUtils.isNotBlank(region) ? region : EMPTY_STRING)
                + (StringUtils.isNotBlank(city) ? city : EMPTY_STRING)
                + (StringUtils.isNotBlank(district) ? district : EMPTY_STRING)
                + (StringUtils.isNotBlank(street) ? street : EMPTY_STRING);
    }

}
