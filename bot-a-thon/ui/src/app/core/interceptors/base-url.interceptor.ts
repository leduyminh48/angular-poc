import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const ASSETS_PREFIX_URL = '/assets';

@Injectable()
export class BaseUrlInterceptor implements HttpInterceptor {
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (req.url.startsWith(ASSETS_PREFIX_URL)) {
      return next.handle(req);
    }

    const cloneReq = req.clone({
      url: `http://ecsc00a00eec.epam.com:8080${req.url}`,
    });

    return next.handle(cloneReq);
  }
}
