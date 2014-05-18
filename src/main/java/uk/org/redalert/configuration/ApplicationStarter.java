package uk.org.redalert.configuration;

import org.apache.commons.lang.StringUtils;
import uk.org.redalert.application.ApplicationProperties;

public class ApplicationStarter {

    public static void main(String args[]) throws Exception{
        String port = ApplicationProperties.PORT.getValue();
        new JettyServer(Integer.valueOf(port), getContextPath()).startJetty();

    }

    private static String getContextPath(){
        return "src/main/webapp";
    }
}
