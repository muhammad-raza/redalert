package uk.org.redalert.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;

@Import({ApplicationConfiguration.class})
@Configuration
public class ApplicationProperties {
    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new FileSystemResource(System.getProperty("user.dir")+"/src/main/webapp/WEB-INF/application.properties"));
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return  propertyPlaceholderConfigurer;
    }
}
