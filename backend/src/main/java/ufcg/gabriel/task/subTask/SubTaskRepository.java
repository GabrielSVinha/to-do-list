package ufcg.gabriel.task.subTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by user on 07/02/17.
 */
public interface SubTaskRepository extends JpaRepository<SubTask, long> {

    public ArrayList<SubTask> findBytask_id(@Param("task_id") long task_id);

}
