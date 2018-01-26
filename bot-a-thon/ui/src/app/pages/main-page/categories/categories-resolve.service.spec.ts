import { TestBed, inject } from '@angular/core/testing';

import { CategoriesResolveService } from './categories-resolve.service';

describe('CategoriesResolveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CategoriesResolveService]
    });
  });

  it('should be created', inject([CategoriesResolveService], (service: CategoriesResolveService) => {
    expect(service).toBeTruthy();
  }));
});
