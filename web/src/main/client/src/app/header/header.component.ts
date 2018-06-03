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
      label: 'About Us'
    },
    {
      path: 'curriculum',
      label: 'Our Curriculum'
    },
    {
      path: 'news',
      label: 'News and Events'
    },
    {
      path: 'get-involved',
      label: 'Get Involved'
    }
  ];
  constructor() { }

  ngOnInit() {
  }

}
