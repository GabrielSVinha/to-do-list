import { SubTask } from '../subtask/subtask';

export class Task {
	
	id: number;
	name: String;
	subTasks: Array<SubTask>;
	timestamp: String;
	completed: boolean;

	constructor(id: number,
				name: String,
				completed: boolean,
				timestamp: String,
				subTasks: Array<SubTask>){
		this.id = id;
		this.name = name;
		this.completed = completed;
		this.timestamp = timestamp;
		this.subTasks = subTasks;
	}
}