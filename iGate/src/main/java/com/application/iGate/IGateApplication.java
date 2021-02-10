package com.application.iGate;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.application.iGate.model.Visitor;

@SpringBootApplication
public class IGateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IGateApplication.class, args);
	}
	
	@Autowired
	@Bean(name = "entityManagerFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Visitor.class);
		return sessionBuilder.buildSessionFactory();
	}
}
