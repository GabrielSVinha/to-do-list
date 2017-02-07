package ufcg.gabriel.task;

import javassist.bytecode.Descriptor;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ufcg.gabriel.task.subTask.SubTask;
import ufcg.gabriel.task.subTask.SubTaskRepository;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

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

    public Task(){
        this.subTasks = this.repository.findBytask_id(this.id);
        this.percentage = getPercentage();
    }

    public void complete(@PathVariable){

    }

    public void delete(@PathVariable){

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

}
