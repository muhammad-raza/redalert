package uk.org.redalert.configuration;

public class ApplicationStarter {

    public static void main(String args[]) throws Exception{
        new JettyServer(Integer.valueOf(System.getenv("PORT")), getContextPath()).startJetty();

    }

    private static String getContextPath(){
        return "src/main/webapp";
    }
}
