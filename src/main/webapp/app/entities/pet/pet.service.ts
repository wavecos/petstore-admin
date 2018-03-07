import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Pet } from './pet.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<Pet>;

@Injectable()
export class PetService {

    private resourceUrl =  SERVER_API_URL + 'api/pets';

    constructor(private http: HttpClient) { }

    create(pet: Pet): Observable<EntityResponseType> {
        const copy = this.convert(pet);
        return this.http.post<Pet>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(pet: Pet): Observable<EntityResponseType> {
        const copy = this.convert(pet);
        return this.http.put<Pet>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<Pet>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<Pet[]>> {
        const options = createRequestOption(req);
        return this.http.get<Pet[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<Pet[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Pet = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Pet[]>): HttpResponse<Pet[]> {
        const jsonResponse: Pet[] = res.body;
        const body: Pet[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Pet.
     */
    private convertItemFromServer(pet: Pet): Pet {
        const copy: Pet = Object.assign({}, pet);
        return copy;
    }

    /**
     * Convert a Pet to a JSON which can be sent to the server.
     */
    private convert(pet: Pet): Pet {
        const copy: Pet = Object.assign({}, pet);
        return copy;
    }
}
