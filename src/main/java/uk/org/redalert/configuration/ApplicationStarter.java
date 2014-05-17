package uk.org.redalert.configuration;

public class ApplicationStarter {

    private static final int PORT = 8080;
    public static void main(String args[]) throws Exception{
        new JettyServer(PORT, getContextPath()).startJetty();

    }

    private static String getContextPath(){
        return "src/main/webapp";
    }
}
