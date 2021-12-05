package org.example.jersey.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.scan.Constants;
import org.example.jersey.configuration.jersey.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.lang.NonNull;

import java.io.File;
import java.util.TimeZone;

public class Application {

    private static final Logger LOGGER = LogManager.getLogger();

    public Application() {
        System.setProperty(Constants.SKIP_JARS_PROPERTY, "*.jar");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        LOGGER.info("Starting at port: " + webPort);
        tomcat.getConnector().setPort(Integer.parseInt(webPort));
        Context rootContext = tomcat.addWebapp("/jersey-test", new File("").getAbsolutePath());

        createServlets(rootContext);

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            LOGGER.error("Unable to start application", e);
        }
    }

    @NonNull
    private void createServlets(Context rootContext) {
        final JerseyConfig jerseyConfig = new JerseyConfig();
        final ServletContainer servletContainer = new ServletContainer(jerseyConfig);
        Tomcat.addServlet(rootContext, "Jersey", servletContainer);
        rootContext.addServletMappingDecoded("/api/*", "Jersey");
    }

    public static void main(String[] args) {
        new Application();
    }

}
