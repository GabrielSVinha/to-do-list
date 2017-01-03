package ufcg.gabriel.tasks;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompletedTasksRepository extends JpaRepository<Task, Long>{

	//"SELECT * FROM completed_tasks WHERE task_id = :_id"
	Task findBytaskId(@Param("_id") Long _id);
	
	//"SELECT * FROM completed_tasks WHERE task_name = :tn"
	Collection<Task> findBytaskName(@Param("tn") String tn);
	
}
