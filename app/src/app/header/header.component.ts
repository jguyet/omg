import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
	selected = 0;

	constructor() {

	}

	ngOnInit() {
    }

	selectedmethod(id) {
		this.selected = id;
		console.log(id);
	};
}
