import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { ICategory } from './categories-resolve.service';
import 'rxjs/add/operator/map';

@Component({
  selector: 'ee-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss'],
})
export class CategoriesComponent implements OnInit {
  categories: Observable<ICategory[]>;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.categories = this.route.data.map(data => data.categories);
  }
}
