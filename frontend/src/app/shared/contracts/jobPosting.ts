import {ICompany} from './company';

export interface IJobPosting{
    id: number;
    jobDescription: string;
    jobTitle: string;
    postingDate: Date;
    timespan: string;
    // companyId: ICompany;
    companyId: number;
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
