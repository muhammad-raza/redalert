package uk.org.redalert.configuration;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
    private final Server server;

    public JettyServer(int port, String contextPath) {
        this.server = new Server(port);
        setContext(contextPath);

    }

    public void startJetty() throws Exception {
        server.start();
        server.join();
    }

    public void stopJetty() throws Exception {
        server.stop();
    }

    public void setContext(String contextPath){
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setResourceBase(contextPath);
        server.setHandler(webAppContext);
    }
}
