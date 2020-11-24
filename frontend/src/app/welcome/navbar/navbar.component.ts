import {Component, HostListener, OnInit} from '@angular/core';
import {$} from 'protractor';

@Component({
  selector: 'welcome-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  sidebarHidden = true;
  constructor() { }

  ngOnInit(): void {

  }

  @HostListener('window:scroll', [])
  // tslint:disable-next-line:typedef
  onWindowScroll(e: any) {
    const element = document.querySelector('.nav');
    if (element != null) {
      if (window.pageYOffset > element.clientHeight) {
        element.classList.add('black');
      } else {
        element.classList.remove('black');
      }
    }
  }

  // tslint:disable-next-line:typedef
  sidenav() {
    this.sidebarHidden = !this.sidebarHidden;
  }
}
