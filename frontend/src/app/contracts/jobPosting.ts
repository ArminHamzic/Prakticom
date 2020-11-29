import {ICompany} from './company';

export interface JobPosting{
    id: number;
    jobDescription: string;
    jobTitle: string;
    postingDate: Date;
    timespan: string;
    // companyId: ICompany;
    companyId: number;
}
