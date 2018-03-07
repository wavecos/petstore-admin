import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { PetComponent } from './pet.component';
import { PetDetailComponent } from './pet-detail.component';
import { PetPopupComponent } from './pet-dialog.component';
import { PetDeletePopupComponent } from './pet-delete-dialog.component';

@Injectable()
export class PetResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const petRoute: Routes = [
    {
        path: 'pet',
        component: PetComponent,
        resolve: {
            'pagingParams': PetResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Pets'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'pet/:id',
        component: PetDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Pets'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const petPopupRoute: Routes = [
    {
        path: 'pet-new',
        component: PetPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Pets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'pet/:id/edit',
        component: PetPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Pets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'pet/:id/delete',
        component: PetDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Pets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
