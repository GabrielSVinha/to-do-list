package ufcg.gabriel.models.task.subTask;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SubTask {

    @Column(name="task_id")
    private long task_id;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private boolean completed;

    public SubTask(String name, Long task){
        this.name = name;
        this.completed = false;
        this.task_id = task;
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
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
