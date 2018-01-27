import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { CredentialService } from './credential.service';

@Injectable()
export class AuthApiService {

  constructor(private http: HttpClient, private credentialService: CredentialService) { }

  login({ username, password }): Observable<number> {
    return this.http.post<number>('/user/login', { username, password })
      .do(id => {
        this.credentialService.userId = id;
      });
  }
}
