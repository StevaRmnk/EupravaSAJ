import { TestBed } from '@angular/core/testing';

import { ZapisnikServiceService } from './zapisnik-service.service';

describe('ZapisnikServiceService', () => {
  let service: ZapisnikServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZapisnikServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
