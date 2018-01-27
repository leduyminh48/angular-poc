import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { AuthApiService } from '../../services/auth-api.service';
import { MatMenuTrigger, MatSnackBar } from '@angular/material';
import { CartManagerService } from '../../services/cart-manager.service';

@Component({
  selector: 'ee-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  @Output() public toggleSidenav: EventEmitter<void> = new EventEmitter();

  @ViewChild('usernameInput') usernameInput: ElementRef;
  @ViewChild('passwordInput') passwordInput: ElementRef;
  @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

  constructor(
    private authApiService: AuthApiService,
    private snackbar: MatSnackBar,
    private cartManager: CartManagerService,
  ) {}

  public ngOnInit() {}

  get cartLength() {
    return this.cartManager.getLength();
  }


  login($event) {
    $event.stopPropagation();

    const username  = this.usernameInput.nativeElement.value;
    const password  = this.passwordInput.nativeElement.value;
    return this.authApiService.login({ username, password })
      .subscribe(() => {
        this.snackbar.open('Logged in successfully', null, {
          duration: 2000
        });
        this.trigger.closeMenu();
      })
  }
}
