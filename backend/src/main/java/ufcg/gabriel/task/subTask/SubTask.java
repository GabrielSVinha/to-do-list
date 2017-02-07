package ufcg.gabriel.task.subTask;

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

    public SubTask(){

    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }
}
