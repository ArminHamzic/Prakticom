import {ILocation} from './location';
import {IJobPosting} from './jobPosting';

export interface ICompany{
    id: number;
    contactEmail: string;
    contactName: string;
    contactPhoneNumber: string;
    description: string;
    name: string;
    jobPostings: IJobPosting[];
    locations: ILocation[];
    sectors: string[];
    url: string;
    userName: string;
    password: string;
}
