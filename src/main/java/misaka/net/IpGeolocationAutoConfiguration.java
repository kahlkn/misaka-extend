package misaka.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * Network physical address auto configuration.
 * @author Kahle
 */
@Configuration
public class IpGeolocationAutoConfiguration implements InitializingBean, DisposableBean {
    private static Logger log = LoggerFactory.getLogger(IpGeolocationAutoConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        IpGeolocationProvider provider = new IpApiIpGeolocationProvider();
        log.info("Set ip geolocation provider \"{}\" success", provider);
        IpGeolocationUtils.setIpGeolocationProvider(provider);
    }

    @Override
    public void destroy() throws Exception {
    }

}
