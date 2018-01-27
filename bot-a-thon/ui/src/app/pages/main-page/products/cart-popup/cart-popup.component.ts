import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'ee-cart',
  templateUrl: './cart-popup.component.html',
  styleUrls: ['./cart-popup.component.scss']
})
export class CartPopupComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private dialog: MatDialog,
    private router: Router,
  ) { }


  ngOnInit() {
  }

  close() {
    this.dialog.closeAll();
  }

  continueToCart() {
    this.close();
    this.router.navigate(['/app/cart']);
  }

}
