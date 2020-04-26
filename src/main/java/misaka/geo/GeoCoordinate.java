package misaka.geo;

/**
 * Geographic coordinate object.
 * @see <a href="https://en.wikipedia.org/wiki/Geographic_coordinate_system">Geographic coordinate system</a>
 * @author Kahle
 */
public interface GeoCoordinate {

    Double getLatitude();

    void setLatitude(Double latitude);

    Double getLongitude();

    void setLongitude(Double longitude);

    Double getElevation();

    void setElevation(Double elevation);

}
