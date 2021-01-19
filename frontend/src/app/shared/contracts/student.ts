import {ISkill} from './skill';

export interface IStudent{
    id: number;
    birthDate: string;
    email: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    school: string;
    skills: ISkill[];
    description: string;
}
