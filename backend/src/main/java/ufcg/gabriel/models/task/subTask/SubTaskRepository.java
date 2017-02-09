package ufcg.gabriel.models.task.subTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

    public ArrayList<SubTask> findBytask_id(@Param("task_id") long task_id);

}
