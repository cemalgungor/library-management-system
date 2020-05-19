import { Injectable } from '@angular/core';


import { Observable } from 'rxjs/Rx';
import { map } from 'rxjs/internal/operators';
import { ApiService } from '../api.service';

@Injectable({

	providedIn: 'root'
})
export class BookService {

	private BOOK_PATH = '/book';

	constructor(private apiService: ApiService) {
	}


	getAll(page): Observable<any> {
		return this.apiService.get(this.BOOK_PATH).pipe(map(
			res => {
				if (res) {
					return res;
				}
				else {
					return {};
				}
			}
		));
	}




}


