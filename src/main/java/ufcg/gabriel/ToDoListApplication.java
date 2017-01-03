package ufcg.gabriel;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ufcg.gabriel.tasks.CompletedTasksRepository;
import ufcg.gabriel.tasks.Task;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(CompletedTasksRepository repo){
		return args -> {
			Arrays.asList("Eat, Sleep, Smoke Wees, Scream".split(", ")).forEach(
						n -> repo.save(new Task(n, "Sample Description"))
					);
			repo.findAll().forEach(t -> System.out.println(t));
			
			repo.findBytaskName("Sleep").forEach(System.out::println);
			
		};
	}
	
}
