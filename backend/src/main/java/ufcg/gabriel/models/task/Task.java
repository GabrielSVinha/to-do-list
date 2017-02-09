package ufcg.gabriel.models.task;

import org.springframework.beans.factory.annotation.Autowired;
import ufcg.gabriel.models.task.subTask.SubTask;
import ufcg.gabriel.models.task.subTask.SubTaskRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Task {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="status")
    private boolean completed;

    @Column(name="percentage")
    private double percentage;

    @Column(name="name")
    private String name;

    @Column(name="subtasks")
    private ArrayList<SubTask> subTasks;

    @Column(name="timestamps")
    private LocalDate timestamp;

    @Autowired
    private SubTaskRepository repository;

    public Task(String name){
        this.subTasks = this.repository.findBytask_id(this.id);
        this.percentage = getPercentage();
        this.name = name;
        this.timestamp = LocalDate.now();
        this.completed = false;
    }

    private double getPercentage(){
        int total = subTasks.size();
        int cp = 0;
        for(SubTask st: subTasks){
            if(st.isCompleted()){
                cp++;
            }
        }
        return (cp*100)/total;
    }

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

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
