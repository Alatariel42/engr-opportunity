import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
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
      path: '',
      src: '/assets/logo.png',
      alt: 'Engineering Opportunity Logo, navigate home',
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
  constructor() { }

  ngOnInit() {
  }

}
