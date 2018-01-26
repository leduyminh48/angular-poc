import { TestBed, inject } from '@angular/core/testing';

import { CartManagerService } from './cart-manager.service';

describe('CartManagerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CartManagerService]
    });
  });

  it('should be created', inject([CartManagerService], (service: CartManagerService) => {
    expect(service).toBeTruthy();
  }));
});
