export class SubTask  {
	
	id: number;
	name: String;
	completed: boolean;

	constructor(id: number,
				name: String,
				completed: boolean) {
		this.id = id;
		this.name = name;
		this.completed = completed;
	}
}