import { TestBed } from '@angular/core/testing';

import { JobApiService } from './jobs-api.service';

describe('JobsApiService', () => {
  let service: JobApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
