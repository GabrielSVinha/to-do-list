package ufcg.gabriel.models.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import ufcg.gabriel.models.task.subTask.SubTask;
import ufcg.gabriel.models.task.subTask.SubTaskRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name="tasks")
public class Task{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="status")
    private boolean completed;
    
    @Column(name="percentage")
    private double percentage;
    
    @Column(name="name")
    private String name;
    
    private ArrayList<SubTask> subTasks;
    
    @Column(name="timestamps")
    private String timestamp;
    
    public Task(String name){
        this.name = name;
        this.timestamp = LocalDate.now().toString();
        this.completed = false;
    }
    
    Task(){}
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }
    
    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}