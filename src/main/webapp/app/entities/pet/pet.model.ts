import { BaseEntity } from './../../shared';

export const enum PetType {
    'DOG',
    'CAT',
    'CANARY',
    'HORSE'
}

export const enum Gender {
    'FEMALE',
    'MALE'
}

export class Pet implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public type?: PetType,
        public breed?: string,
        public weight?: number,
        public age?: number,
        public gender?: Gender,
        public notes?: string,
    ) {
    }
}
