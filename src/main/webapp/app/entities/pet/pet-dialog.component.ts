import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Pet } from './pet.model';
import { PetPopupService } from './pet-popup.service';
import { PetService } from './pet.service';

@Component({
    selector: 'jhi-pet-dialog',
    templateUrl: './pet-dialog.component.html'
})
export class PetDialogComponent implements OnInit {

    pet: Pet;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private petService: PetService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.pet.id !== undefined) {
            this.subscribeToSaveResponse(
                this.petService.update(this.pet));
        } else {
            this.subscribeToSaveResponse(
                this.petService.create(this.pet));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Pet>>) {
        result.subscribe((res: HttpResponse<Pet>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Pet) {
        this.eventManager.broadcast({ name: 'petListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-pet-popup',
    template: ''
})
export class PetPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private petPopupService: PetPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.petPopupService
                    .open(PetDialogComponent as Component, params['id']);
            } else {
                this.petPopupService
                    .open(PetDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
