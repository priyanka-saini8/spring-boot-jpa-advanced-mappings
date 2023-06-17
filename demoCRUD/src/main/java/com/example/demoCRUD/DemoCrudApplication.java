package com.example.demoCRUD;

import com.example.demoCRUD.dao.AppDao;
import com.example.demoCRUD.entity.Instructor;
import com.example.demoCRUD.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
//			System.out.println("hello world!!");
			
//			createInstructor(appDao);
//			findInstructor(appDao);
			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {

		int theId = 1;
		System.out.println("Deleting instructor with id " + theId);
		appDao.deleteById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDao appDao) {

		int theId = 1;
		System.out.println("Fining instructor id " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor " + tempInstructor);
		System.out.println("the associate instructor details only " + tempInstructor.getInstructorDetails());

	}

	private void createInstructor(AppDao appDao) {

		Instructor tempInstructor = new Instructor("Priyanka", "Saini", "saini@abc.com");

		InstructorDetails tempInstructorDetail = new InstructorDetails("youtube.com", "coding");

		tempInstructor.setInstructorDetails(tempInstructorDetail);

		System.out.println("Saving instructor which also saves details as well " + tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done!");
	}

}
