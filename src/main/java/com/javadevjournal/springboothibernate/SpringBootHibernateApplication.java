package com.javadevjournal.springboothibernate;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringBootHibernateApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootHibernateApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

}
