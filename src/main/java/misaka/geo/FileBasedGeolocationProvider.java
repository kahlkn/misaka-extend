package misaka.geo;

import artoria.exception.ExceptionUtils;
import artoria.file.Csv;
import artoria.file.FileUtils;
import artoria.util.CollectionUtils;
import artoria.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static artoria.common.Constants.UTF_8;

public class FileBasedGeolocationProvider implements GeolocationProvider {
    private static final String DEFAULT_FILE_NAME = "geolocation.data";
    private List<Geolocation> dataList = new ArrayList<Geolocation>();
    private Map<String, List<Geolocation>> dataMap = new HashMap<String, List<Geolocation>>();
    private List<Geolocation> countryList = new ArrayList<Geolocation>();
    private Map<String, List<Geolocation>> regionMap = new HashMap<String, List<Geolocation>>();
    private Map<String, List<Geolocation>> cityMap = new HashMap<String, List<Geolocation>>();
    private Map<String, List<Geolocation>> districtMap = new HashMap<String, List<Geolocation>>();
    private Map<String, List<Geolocation>> streetMap = new HashMap<String, List<Geolocation>>();

    public FileBasedGeolocationProvider() {

        this(null, null);
    }

    public FileBasedGeolocationProvider(String filePath, String charset) {
        charset = StringUtils.isNotBlank(charset) ? charset : UTF_8;
        Csv csv = new Csv();
        csv.setCharset(charset);
        try {
            if (StringUtils.isNotBlank(filePath)) {
                File file = new File(filePath);
                if (!file.exists()) {
                    FileUtils.createNewFile(file);
                }
                csv.readFromFile(new File(filePath));
            }
            else {
                csv.readFromClasspath(DEFAULT_FILE_NAME);
            }
        }
        catch (IOException e) {
            throw ExceptionUtils.wrap(e);
        }
        initialize(csv);
    }

    public FileBasedGeolocationProvider(Csv csv) {

        initialize(csv);
    }

    private void initialize(Csv csv) {
        if (csv == null) { return; }
        dataList.addAll(csv.toBeanList(Geolocation.class));
        for (Geolocation area : dataList) {
            String country = area.getCountry();
            String countryCode = area.getCountryCode();
            String region = area.getRegion();
            String regionCode = area.getRegionCode();
            String city = area.getCity();
            String cityCode = area.getCityCode();
            String district = area.getDistrict();
            String districtCode = area.getDistrictCode();
            String street = area.getStreet();
            String streetCode = area.getStreetCode();
            if (StringUtils.isBlank(region)) {
                addArea(area, countryCode, country, dataMap);
                countryList.add(area);
            }
            else if (StringUtils.isBlank(city)) {
                addArea(area, regionCode, region, dataMap);
                addArea(area, countryCode, country, regionMap);
            }
            else if (StringUtils.isBlank(district)) {
                addArea(area, cityCode, city, dataMap);
                addArea(area, regionCode, region, cityMap);
            }
            else if (StringUtils.isBlank(street)) {
                addArea(area, districtCode, district, dataMap);
                addArea(area, cityCode, city, districtMap);
            }
            else {
                addArea(area, streetCode, street, dataMap);
                addArea(area, districtCode, district, streetMap);
            }
        }
    }

    private void addArea(Geolocation area, String code, String name, Map<String, List<Geolocation>> map) {
        List<Geolocation> list = map.get(code);
        if (list == null) {
            list = new ArrayList<Geolocation>();
            if (code != null) { map.put(code, list); }
            if (name != null) { map.put(name, list); }
        }
        list.add(area);
    }

    @Override
    public Geolocation findFirst(String nameOrCode) {
        List<Geolocation> locationList = findLocations(nameOrCode);
        if (CollectionUtils.isEmpty(locationList)) {
            return null;
        }
        return locationList.get(locationList.size() - 1);
    }

    @Override
    public List<Geolocation> findLocations(String nameOrCode) {

        return dataMap.get(nameOrCode);
    }

    @Override
    public List<Geolocation> findCountries() {

        return Collections.unmodifiableList(countryList);
    }

    @Override
    public List<Geolocation> findRegions(String country) {

        return regionMap.get(country);
    }

    @Override
    public List<Geolocation> findCities(String subdivision) {

        return cityMap.get(subdivision);
    }

    @Override
    public List<Geolocation> findDistricts(String city) {

        return districtMap.get(city);
    }

    @Override
    public List<Geolocation> findStreets(String county) {

        return streetMap.get(county);
    }

}
