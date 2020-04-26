package misaka.geo;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
public class FileBasedGeolocationProviderTest {
    private static Logger log = LoggerFactory.getLogger(FileBasedGeolocationProviderTest.class);
    private static FileBasedGeolocationProvider fileBasedAreaInfoProvider = new FileBasedGeolocationProvider();

    @Test
    public void test1() throws Exception {
        log.info("{}", fileBasedAreaInfoProvider.findFirst("230603"));
        log.info("{}", fileBasedAreaInfoProvider.findLocations("230000"));
        log.info("{}", fileBasedAreaInfoProvider.findLocations("230600"));
        log.info("{}", fileBasedAreaInfoProvider.findLocations("230603"));
        log.info("{}", fileBasedAreaInfoProvider.findCountries());
        log.info("{}", fileBasedAreaInfoProvider.findRegions("CN"));
        log.info("{}", fileBasedAreaInfoProvider.findCities("230000"));
        log.info("{}", fileBasedAreaInfoProvider.findDistricts("230600"));
        log.info("{}", fileBasedAreaInfoProvider.findStreets("230603"));
    }

}
