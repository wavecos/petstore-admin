import { browser, element, by } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';

describe('Pet e2e test', () => {

    let navBarPage: NavBarPage;
    let petDialogPage: PetDialogPage;
    let petComponentsPage: PetComponentsPage;

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Pets', () => {
        navBarPage.goToEntity('pet');
        petComponentsPage = new PetComponentsPage();
        expect(petComponentsPage.getTitle())
            .toMatch(/Pets/);

    });

    it('should load create Pet dialog', () => {
        petComponentsPage.clickOnCreateButton();
        petDialogPage = new PetDialogPage();
        expect(petDialogPage.getModalTitle())
            .toMatch(/Create or edit a Pet/);
        petDialogPage.close();
    });

    it('should create and createPet Pets', () => {
        petComponentsPage.clickOnCreateButton();
        petDialogPage.setNameInput('name');
        expect(petDialogPage.getNameInput()).toMatch('name');
        petDialogPage.typeSelectLastOption();
        petDialogPage.setBreedInput('breed');
        expect(petDialogPage.getBreedInput()).toMatch('breed');
        petDialogPage.setWeightInput('5');
        expect(petDialogPage.getWeightInput()).toMatch('5');
        petDialogPage.setAgeInput('5');
        expect(petDialogPage.getAgeInput()).toMatch('5');
        petDialogPage.genderSelectLastOption();
        petDialogPage.setNotesInput('notes');
        expect(petDialogPage.getNotesInput()).toMatch('notes');
        petDialogPage.save();
        expect(petDialogPage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class PetComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-pet div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getText();
    }
}

export class PetDialogPage {
    modalTitle = element(by.css('h4#myPetLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    typeSelect = element(by.css('select#field_type'));
    breedInput = element(by.css('input#field_breed'));
    weightInput = element(by.css('input#field_weight'));
    ageInput = element(by.css('input#field_age'));
    genderSelect = element(by.css('select#field_gender'));
    notesInput = element(by.css('input#field_notes'));

    getModalTitle() {
        return this.modalTitle.getText();
    }

    setNameInput = function(name) {
        this.nameInput.sendKeys(name);
    };

    getNameInput = function() {
        return this.nameInput.getAttribute('value');
    };

    setTypeSelect = function(type) {
        this.typeSelect.sendKeys(type);
    };

    getTypeSelect = function() {
        return this.typeSelect.element(by.css('option:checked')).getText();
    };

    typeSelectLastOption = function() {
        this.typeSelect.all(by.tagName('option')).last().click();
    };
    setBreedInput = function(breed) {
        this.breedInput.sendKeys(breed);
    };

    getBreedInput = function() {
        return this.breedInput.getAttribute('value');
    };

    setWeightInput = function(weight) {
        this.weightInput.sendKeys(weight);
    };

    getWeightInput = function() {
        return this.weightInput.getAttribute('value');
    };

    setAgeInput = function(age) {
        this.ageInput.sendKeys(age);
    };

    getAgeInput = function() {
        return this.ageInput.getAttribute('value');
    };

    setGenderSelect = function(gender) {
        this.genderSelect.sendKeys(gender);
    };

    getGenderSelect = function() {
        return this.genderSelect.element(by.css('option:checked')).getText();
    };

    genderSelectLastOption = function() {
        this.genderSelect.all(by.tagName('option')).last().click();
    };
    setNotesInput = function(notes) {
        this.notesInput.sendKeys(notes);
    };

    getNotesInput = function() {
        return this.notesInput.getAttribute('value');
    };

    save() {
        this.saveButton.click();
    }

    close() {
        this.closeButton.click();
    }

    getSaveButton() {
        return this.saveButton;
    }
}
