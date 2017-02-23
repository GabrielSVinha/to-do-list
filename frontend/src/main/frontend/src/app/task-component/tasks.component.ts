import { Component, OnInit } from '@angular/core';
import { Task } from '../models/task/task';
import { SubTask } from '../models/subtask/subtask';
import { TaskService } from '../services/task.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  private tasks = [];

  private errorMessage;

  view = false;
  opts = false;

  options = [];
  selected = [];

  constructor(private tService: TaskService, private router: Router) { 
    this.ngOnInit;
  }

  ngOnInit() {
  	this.tService.getAll().then(res =>{
	  		if(res){
          let task$ = res;
          task$.map(t => this.tasks.push(new Task(t.id, t.name, t.completed, t.timestamp, t.subTasks)));
          console.log('Response: ', this.tasks);
	  		}
	  	}
  	);
  }

  selectOptions(id: number){
    if(this.selected.indexOf(id) === -1) {
      this.selected.push(id);
    }else{
      let tmp = this.selected;
      this.selected = tmp.slice(0, this.selected.indexOf(id)).concat(tmp.slice(this.selected.indexOf(id)+1, this.selected.length))
    }
  }

  completeTasks(){
    this.tasks.map(t => {
      if(this.selected.indexOf(t.id) !== -1 && !t.completed) {
        this.tService.updateStatus(t.id, true);
        t.completed = true;
      }
    });
  }

  deleteTasks(){

  }

  viewTasks(){

  }

  submission(){

  }

  addTasks(){

  }

  getOptions(){
    if(this.opts === true) {
      this.opts = false;
    }else{
      this.opts = true;
    }
    console.log("Opts= ", this.opts);
  }
}