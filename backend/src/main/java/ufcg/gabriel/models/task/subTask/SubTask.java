package ufcg.gabriel.models.task.subTask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subtasks")
public class SubTask {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @Column(name="task_id")
    private long taskId;
    
    @Column(name="name")
    private String name;
    
    @Column(name="status")
    private boolean completed;
    
    public SubTask(String name, Long task){
        this.name = name;
        this.completed = false;
        this.taskId = task;
    }
    
    public long getTask_id() {
        return taskId;
    }
    
    public void setTask_id(long task_id) {
        this.taskId = task_id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void complete(){
        this.completed = true;
    }
    
    public boolean isCompleted() {
        return completed;
    }
}