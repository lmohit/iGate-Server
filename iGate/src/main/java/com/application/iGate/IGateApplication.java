package com.application.iGate;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.application.iGate.model.Visitor;

@EnableJpaRepositories
@SpringBootApplication
public class IGateApplication extends SpringBootServletInitializer {

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
	
	public IGateApplication() {}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(IGateApplication.class);
	}
}
