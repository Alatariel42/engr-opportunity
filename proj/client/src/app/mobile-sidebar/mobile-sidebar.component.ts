import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mobile-sidebar',
  templateUrl: './mobile-sidebar.component.html',
  styleUrls: ['./mobile-sidebar.component.scss']
})
export class MobileSidebarComponent implements OnInit {
  @Output() toggleSidebar = new EventEmitter<void>();
  navLinks = [
    {
      path: 'about',
      label: 'About'
    },
    {
      path: 'curriculum',
      label: 'Curriculum'
    },
    {
      path: 'home',
      src: '/assets/logo.png',
      alt: 'home',
      isLogo: true
    },
    {
      path: 'events',
      label: 'Events'
    },
    // {
    //   path: 'news',
    //   label: 'News'
    // },
    {
      path: 'get-involved',
      label: 'Get Involved'
    }
  ];

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigate(link) {
    this.toggleSidebar.emit();
    this.router.navigate([link.path]);
  }

}
