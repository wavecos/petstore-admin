/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { PetstoreTestModule } from '../../../test.module';
import { PetDetailComponent } from '../../../../../../main/webapp/app/entities/pet/pet-detail.component';
import { PetService } from '../../../../../../main/webapp/app/entities/pet/pet.service';
import { Pet } from '../../../../../../main/webapp/app/entities/pet/pet.model';

describe('Component Tests', () => {

    describe('Pet Management Detail Component', () => {
        let comp: PetDetailComponent;
        let fixture: ComponentFixture<PetDetailComponent>;
        let service: PetService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PetstoreTestModule],
                declarations: [PetDetailComponent],
                providers: [
                    PetService
                ]
            })
            .overrideTemplate(PetDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PetDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PetService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new Pet(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.pet).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
