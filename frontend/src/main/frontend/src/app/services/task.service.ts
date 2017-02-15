import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import { Observable} from 'rxjs/Observable';

import { Task } from '../models/task/task';


@Injectable()
export class TaskService  {
	
	private baseUrl = 'http://localhost:8080/api';

	constructor(private http: Http) {}

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

