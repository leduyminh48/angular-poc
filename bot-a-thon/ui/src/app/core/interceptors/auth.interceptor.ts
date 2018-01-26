import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import { CredentialService } from '../../shared/services/credential.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: CredentialService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const authorization = `${this.authService.userId}`;

    const authReq = req.clone({
      setHeaders: { authorization },
    });

    return next.handle(authReq);
  }
}
