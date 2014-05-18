package uk.org.redalert.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;

import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import uk.org.redalert.application.ApplicationProperties;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration //Specifies the class as configuration
@ComponentScan("uk.org.redalert") //Specifies which package to scan
@EnableWebMvc //Enables to use Spring's annotations in the code

public class ApplicationConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getVelocityViewResolver() {
        InternalResourceViewResolver velocityViewResolver = new InternalResourceViewResolver();
        velocityViewResolver.setPrefix("/view/");
        velocityViewResolver.setSuffix(".jsp");
        return velocityViewResolver;
    }

    @Bean
    public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource(){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return  reloadableResourceBundleMessageSource;
    }

    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        try {
            String url = ApplicationProperties.DATABASE_URL.getValue();
            URI dbUri = new URI(url);
            String[] UserInfo = dbUri.getUserInfo().split(":");
            String username = UserInfo[0];
            String password = UserInfo[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();

            ds.setDriverClassName(ApplicationProperties.PSQL_DRIVER.getValue());
            ds.setUrl(dbUrl);
            ds.setUsername(username);
            ds.setPassword(password);

        }catch (URISyntaxException e){
            System.out.println("wrong DATABASE_URL in environment variable");
        }

        return ds;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setDataSource(getDataSource());
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
        asfb.setDataSource(getDataSource());
        asfb.setHibernateProperties(getHibernateProperties());
        String path = getClass().getClassLoader().getResource("hibernate.cfg.xml").getFile();
        asfb.setConfigLocation(new FileSystemResource(path));
        asfb.setPackagesToScan(getClass().getPackage().toString());
        return asfb;
    }

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(ApplicationProperties.HIBERNATE_DIALECT.getName(), ApplicationProperties.HIBERNATE_DIALECT.getValue());
        properties.put(ApplicationProperties.HIBERNATE_SHOW_SQL.getName(), ApplicationProperties.HIBERNATE_SHOW_SQL.getValue());
        properties.put(ApplicationProperties.HIBERNATE_HM2DLL_AUTO.getName(), ApplicationProperties.HIBERNATE_HM2DLL_AUTO.getValue());
        return properties;
    }
}
