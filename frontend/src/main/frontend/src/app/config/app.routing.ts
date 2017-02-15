import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TasksComponent } from '../task-component/tasks.component';

const appRoutes: Routes = [
	{
		path: 'tasks',
		component: TasksComponent
	},
	{
		path: 'home',
		redirectTo: '/tasks',
		pathMatch: 'full'
	},
	{
		path: '',
		redirectTo: '/tasks',
		pathMatch: 'full'
	},
]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);