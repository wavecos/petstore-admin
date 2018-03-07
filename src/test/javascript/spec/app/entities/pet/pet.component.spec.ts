/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { PetstoreTestModule } from '../../../test.module';
import { PetComponent } from '../../../../../../main/webapp/app/entities/pet/pet.component';
import { PetService } from '../../../../../../main/webapp/app/entities/pet/pet.service';
import { Pet } from '../../../../../../main/webapp/app/entities/pet/pet.model';

describe('Component Tests', () => {

    describe('Pet Management Component', () => {
        let comp: PetComponent;
        let fixture: ComponentFixture<PetComponent>;
        let service: PetService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PetstoreTestModule],
                declarations: [PetComponent],
                providers: [
                    PetService
                ]
            })
            .overrideTemplate(PetComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PetComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PetService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new Pet(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.pets[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
