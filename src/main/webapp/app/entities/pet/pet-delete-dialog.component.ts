import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Pet } from './pet.model';
import { PetPopupService } from './pet-popup.service';
import { PetService } from './pet.service';

@Component({
    selector: 'jhi-pet-delete-dialog',
    templateUrl: './pet-delete-dialog.component.html'
})
export class PetDeleteDialogComponent {

    pet: Pet;

    constructor(
        private petService: PetService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.petService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'petListModification',
                content: 'Deleted an pet'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-pet-delete-popup',
    template: ''
})
export class PetDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private petPopupService: PetPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.petPopupService
                .open(PetDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
