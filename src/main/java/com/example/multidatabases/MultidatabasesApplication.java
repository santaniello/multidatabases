package com.example.multidatabases;

import com.example.multidatabases.repositories.database1.Database1Model;
import com.example.multidatabases.repositories.database1.Database1Repository;
import com.example.multidatabases.repositories.database2.Database2Model;
import com.example.multidatabases.repositories.database2.Database2Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MultidatabasesApplication  implements CommandLineRunner {


	@Autowired
	private Database1Repository database1Repository;

	@Autowired
	private Database2Repository database2Repository;

	public static void main(String[] args) {
		SpringApplication.run(MultidatabasesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("************************************************************");
		log.info("Start printing mongo objects");
		log.info("************************************************************");
		this.database1Repository.save(new Database1Model(null, "Primary database plain object"));

		this.database2Repository.save(new Database2Model(null, "Secondary database plain object"));

		List<Database1Model> primaries = this.database1Repository.findAll();
		for (Database1Model primary : primaries) {
			log.info(primary.toString());
		}

		List<Database2Model> secondaries = this.database2Repository.findAll();

		for (Database2Model secondary : secondaries) {
			log.info(secondary.toString());
		}

		log.info("************************************************************");
		log.info("Ended printing mongo objects");
		log.info("************************************************************");

	}
}
