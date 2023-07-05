import { TestBed } from '@angular/core/testing';

import { OptuzniceServiceService } from './optuznice-service.service';

describe('OptuzniceServiceService', () => {
  let service: OptuzniceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OptuzniceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
