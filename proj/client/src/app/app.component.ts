import { Component, OnInit } from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  isDesktop = false;
  sidebarOpen = false;

  constructor(private breakpointObserver: BreakpointObserver) {}

  ngOnInit(): void {
    this.breakpointObserver.observe([
      '(min-width: 900px)'
    ]).subscribe(result => {
      this.isDesktop = result.matches;
    });
  }

  toggleSidebar() {
    this.sidebarOpen = !this.sidebarOpen;
  }
}
