package uk.org.redalert.configuration;

import uk.org.redalert.application.ApplicationProperties;

public class ApplicationStarter {

    public static void main(String args[]) throws Exception{
        String port = ApplicationProperties.PORT.getValue();
        new JettyServer(Integer.valueOf(port), getPathToApp()).startJetty();

    }

    private static String getPathToApp(){
        return "src/main/webapp";
    }
}
