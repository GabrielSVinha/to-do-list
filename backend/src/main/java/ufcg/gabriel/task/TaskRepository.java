package ufcg.gabriel.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by user on 07/02/17.
 */
public interface TaskRepository extends JpaRepository<Task, long> {

    public Task findByid(@Param("id") long id);

}
