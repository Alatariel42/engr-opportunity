import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-mobile-header',
  templateUrl: './mobile-header.component.html',
  styleUrls: ['./mobile-header.component.scss']
})
export class MobileHeaderComponent implements OnInit {
  @Output() toggleSidebar = new EventEmitter<void>();
  showingSidebar = false;

  constructor() { }

  ngOnInit() {
  }

  toggle() {
    this.showingSidebar = !this.showingSidebar;
    this.toggleSidebar.emit();
  }

}
