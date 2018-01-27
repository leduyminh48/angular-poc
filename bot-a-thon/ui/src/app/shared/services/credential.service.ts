import { Injectable } from '@angular/core';

@Injectable()
export class CredentialService {
  private _userId: number;

  constructor() { }

  set userId(val) {
    this._userId = val;
  }

  get userId() {
    return this._userId;
  }
}
