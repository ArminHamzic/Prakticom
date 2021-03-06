import {ISkill} from './skill';

export interface IStudent{
    id: number;
    birthDate: Date;
    email: string;
    userName: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    school: string;
    skills: any[];
    description: string;
    password: string;
}
