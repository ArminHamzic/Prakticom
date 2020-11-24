import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IJob} from '../contracts/job';

@Injectable({
  providedIn: 'root'
})
export class JobAdsService {
  urlRoot = 'http://localhost:8080/job';

  constructor(private httpClient: HttpClient) { }

  loadJobs(): Promise<IJob[]> {
    return this.httpClient.get<IJob[]>(this.urlRoot).toPromise();
  }

  loadJob(id: number): Promise<IJob> {
    return this.httpClient.get<IJob>(`${this.urlRoot}/${id}`).toPromise();
  }

  patchJob(job: IJob): Promise<IJob>{
    return this.httpClient.patch<IJob>(`${this.urlRoot}/${job.id}`, job).toPromise();
  }

  insertJob(job: IJob): Promise<IJob>{
    return this.httpClient.post<IJob>(`${this.urlRoot}`, job).toPromise();
  }

  deleteJob(id: number) {
    return this.httpClient.delete<IJob>(`${this.urlRoot}/${id}`).subscribe();
  }

}
