import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import { Observable} from 'rxjs/Observable';

import { Task } from '../models/task/task';


@Injectable()
export class TaskService  {
	
	private baseUrl = 'http://localhost:8080/api';

	private headers;

	constructor(private http: Http) {
	  this.headers = new Headers();
      this.headers.append('Content-Type', 'application/json');
      this.headers.append('Access-Control-Allow-Origin', '*');
	}

	getAll(): Promise<Task[]>{
		return this.http.get(this.baseUrl + '/tasks').map(res => {
          if(res.status == 200) {
            return <Task[]> res.json();
          } else {
            this.handleError(res);
          }
        }).toPromise();

	}

	getTask(id: number): Promise<Task>{
		return this.http.get(this.baseUrl + '/tasks/' + id).map(res => {
			if(res.status == 200){
				return <Task> res.json();
			}else{
				this.handleError(res);
			}
		}).toPromise();
	}

	updateStatus(id: number, status: boolean){
		this.http.post(
				this.baseUrl + "/tasks/status",
				{
					"id": id,
					"status": status
				},
				this.headers
			).subscribe(
				data => { alert("Completed request: POST") },
				error => { this.handleError }
			);
	}

	private handleError (error: Response | any) {
	  	let errMsg: string;
	  	if (error instanceof Response) {	
		    const body = error.json() || '';
		    const err = body.error || JSON.stringify(body);
		    errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
	  	} else {
		    errMsg = error.message ? error.message : error.toString();
		}
	  	console.error(errMsg);
	  	throw new Error(errMsg);
	}
}

