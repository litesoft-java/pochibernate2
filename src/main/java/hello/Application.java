package hello;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class Application {

	// private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode( Banner.Mode.OFF);

        app.run(args);
	}
}
