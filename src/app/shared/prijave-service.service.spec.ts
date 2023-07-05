import { TestBed } from '@angular/core/testing';

import { PrijaveServiceService } from './prijave-service.service';

describe('PrijaveServiceService', () => {
  let service: PrijaveServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrijaveServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
