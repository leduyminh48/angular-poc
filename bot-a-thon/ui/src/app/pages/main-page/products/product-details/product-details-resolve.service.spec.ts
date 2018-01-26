import { TestBed, inject } from '@angular/core/testing';

import { ProductDetailsResolveService } from './product-details-resolve.service';

describe('ProductDetailsResolveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProductDetailsResolveService],
    });
  });

  it(
    'should be created',
    inject(
      [ProductDetailsResolveService],
      (service: ProductDetailsResolveService) => {
        expect(service).toBeTruthy();
      }
    )
  );
});
