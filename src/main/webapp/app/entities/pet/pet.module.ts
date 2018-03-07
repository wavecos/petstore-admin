import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PetstoreSharedModule } from '../../shared';
import {
    PetService,
    PetPopupService,
    PetComponent,
    PetDetailComponent,
    PetDialogComponent,
    PetPopupComponent,
    PetDeletePopupComponent,
    PetDeleteDialogComponent,
    petRoute,
    petPopupRoute,
    PetResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...petRoute,
    ...petPopupRoute,
];

@NgModule({
    imports: [
        PetstoreSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        PetComponent,
        PetDetailComponent,
        PetDialogComponent,
        PetDeleteDialogComponent,
        PetPopupComponent,
        PetDeletePopupComponent,
    ],
    entryComponents: [
        PetComponent,
        PetDialogComponent,
        PetPopupComponent,
        PetDeleteDialogComponent,
        PetDeletePopupComponent,
    ],
    providers: [
        PetService,
        PetPopupService,
        PetResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PetstorePetModule {}
