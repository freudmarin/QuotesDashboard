package marin.dulja.quotesdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QuotesDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuotesDashboardApplication.class, args);
    }

}
