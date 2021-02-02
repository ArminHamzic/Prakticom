import {ICompany} from './company';

export interface IJobPosting{
    id: number;
    jobDescription: string;
    jobTitle: string;
    postingDate: Date;
    timespan: string;
    companyId: number;
    fieldOfWork: FieldOfWork;
}

export enum FieldOfWork {
  Consulting,
  Coaching,
  Logistic,
  Finances,
  Management,
  Tourism,
  Design,
  IT,
  Marketing,
  HumanResources,
  Production,
  Research
}
