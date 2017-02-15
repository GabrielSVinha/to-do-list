import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TasksComponent } from './task-component/tasks.component';
import { routing } from './config/app.routing';
import { TaskService } from './services/task.service';
import { TaskComponent } from './task/task.component';


@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})

export class AppModule { }
