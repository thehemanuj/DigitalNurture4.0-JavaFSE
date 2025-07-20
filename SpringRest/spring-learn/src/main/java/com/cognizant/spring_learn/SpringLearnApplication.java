package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
    LOGGER.info("Starting Spring Learn Application");
    SpringApplication.run(SpringLearnApplication.class, args);
    
    SpringLearnApplication app = new SpringLearnApplication();
    app.displayDate();
    app.displayCountry();
    app.displayCountries();
    
    LOGGER.info("Spring Learn Application Started Successfully");
}
    
    public static void displayDate() {
    LOGGER.info("START");
    
    ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
    SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
    
    try {
        Date date = format.parse("31/12/2018");
        LOGGER.debug("Parsed date: {}", date);
    } catch (Exception e) {
        LOGGER.error("Error parsing date", e);
    }
    
    LOGGER.info("END");
}

public void displayCountry() {
    LOGGER.info("START");
    
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    Country country = context.getBean("country", Country.class);
    Country anotherCountry = context.getBean("country", Country.class);
    
    LOGGER.debug("Country: {}", country.toString());
    LOGGER.debug("Another Country: {}", anotherCountry.toString());
    LOGGER.debug("Are they same object? {}", country == anotherCountry);
    
    LOGGER.info("END");
}

@SuppressWarnings("unchecked")
public void displayCountries() {
    LOGGER.info("START");
    
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    List<Country> countryList = (List<Country>) context.getBean("countryList");
    
    LOGGER.debug("Total countries: {}", countryList.size());
    for (Country country : countryList) {
        LOGGER.debug("Country: {}", country.toString());
    }
    
    LOGGER.info("END");
}

}