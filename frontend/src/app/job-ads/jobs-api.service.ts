import { Injectable } from '@angular/core';
import { IJob } from '../contracts/job';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class JobApiService {
  urlRoot = 'http://localhost:3400/jobs';

  constructor(private httpClient: HttpClient) {}

  getJob(id: number): Promise<IJob> {
    const url = `${this.urlRoot}/${id}`;
    return this.httpClient.get<IJob>(url).toPromise();
  }

  loadJobs(): Promise<IJob[]> {
    return this.httpClient.get<IJob[]>(this.urlRoot).toPromise();
  }

  patchJob(job: IJob): Promise<IJob>{
    return this.httpClient.patch<IJob>(`${this.urlRoot}/${job.id}`, job).toPromise();
  }

  insertJob(job: IJob): Promise<IJob>{
    return this.httpClient.post<IJob>(`${this.urlRoot}`, job).toPromise();
  }

  deleteJob(id: number){
    return this.httpClient.delete<IJob>(`${this.urlRoot}/${id}`).subscribe();
  }
}
