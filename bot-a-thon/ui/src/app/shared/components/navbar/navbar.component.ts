import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'ee-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  @Output() public toggleSidenav: EventEmitter<void> = new EventEmitter();

  constructor() {}

  public ngOnInit() {}
}
