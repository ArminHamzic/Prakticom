import {ILocation} from './location';

export interface ICompany{
    id: number;
    contactEmail: string;
    contactName: string;
    contactPhoneNumber: string;
    description: string;
    name: string;
    jobPostings: string[];
    locations: ILocation[];
    url: string;
}
