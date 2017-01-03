package ufcg.gabriel.tasks;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.*;


@Entity
public class Task {

	
	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "timestamps")
	private LocalDate timestamps;
	
	public Task(String name, String description){
		this.taskName = name;
		this.taskDescription = description;
		this.timestamps = LocalDate.now();
	}
	
	Task(){}

	public Long getId() {
		return taskId;
	}

	public void setId(Long id) {
		this.taskId = id;
	}

	public String getName() {
		return taskName;
	}

	public void setName(String name) {
		this.taskName = name;
	}

	public String getDescription() {
		return taskDescription;
	}

	public void setDescription(String description) {
		this.taskDescription = description;
	}

	public LocalDate getTimestamps() {
		return timestamps;
	}

	@Override
	public String toString() {
		return "Task {id=" + taskId + ", name=" + taskName + ", description=" + taskDescription + ", timestamps=" + timestamps
				+ "}";
	}
	
}
