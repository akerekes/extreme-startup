package net.batkin;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class TomcatConfigurator implements EmbeddedServletContainerCustomizer {

    public static final Logger logger = LoggerFactory.getLogger(TomcatConfigurator.class);

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        logger.info("Customizing");
        LogbackValve valve = new LogbackValve();
        ((TomcatEmbeddedServletContainerFactory)container).addContextValves(valve);
    }
}
