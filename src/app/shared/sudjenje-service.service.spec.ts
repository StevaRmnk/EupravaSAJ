import { TestBed } from '@angular/core/testing';

import { SudjenjeServiceService } from './sudjenje-service.service';

describe('SudjenjeServiceService', () => {
  let service: SudjenjeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SudjenjeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
