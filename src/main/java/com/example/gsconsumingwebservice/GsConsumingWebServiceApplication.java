package com.example.gsconsumingwebservice;

import com.example.gsconsumingwebservice.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GsConsumingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsConsumingWebServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner lookup(CountryClient countryClient) {
        return args -> {
            String country = "Poland";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = countryClient.getCountry(country);
            System.err.println(response.getCountry().getCurrency());
        };
    }
}
