package com.boaglio.casadocodigo.mongodb.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	private String host;
	private int port;
	private String db;
	private final String user;
	private final String password;

	public SpringMongoConfig() {

		host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
		if (host == null) {
			host = "127.0.0.1";
		}
		String sport = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
		db = System.getenv("OPENSHIFT_APP_NAME");
		if (db == null) {
			db = "test";
		}
		user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
		password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
		if (sport != null) {
			port = Integer.decode(sport);
		} else {
			port = 27017;
		}

	}

	@Override
	public String getDatabaseName() {
		return db;
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {

		MongoCredential credential = null;
		MongoClient mongoClient = null;

		if (user != null) {
			credential = MongoCredential.createMongoCRCredential(user,db,password.toCharArray());
			mongoClient = new MongoClient(new ServerAddress(host,port),Arrays.asList(credential));
		} else {
			mongoClient = new MongoClient(new ServerAddress(host,port));
		}

		return mongoClient;
	}
}
