package misaka.net;

import artoria.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpGeolocationUtils {
    private static Logger log = LoggerFactory.getLogger(IpGeolocationUtils.class);
    private static IpGeolocationProvider ipGeolocationProvider;

    public static IpGeolocationProvider getIpGeolocationProvider() {

        return ipGeolocationProvider;
    }

    public static void setIpGeolocationProvider(IpGeolocationProvider ipGeolocationProvider) {
        Assert.notNull(ipGeolocationProvider, "Parameter \"ipGeolocationProvider\" must not null. ");
        log.info("Set ip geolocation provider: {}", ipGeolocationProvider.getClass().getName());
        IpGeolocationUtils.ipGeolocationProvider = ipGeolocationProvider;
    }

    public static IpGeolocation findIpGeolocation(String ipAddress) {

        return getIpGeolocationProvider().findIpGeolocation(ipAddress);
    }

}
