import { NgModule } from '@angular/core';
import { CredentialService } from './credential.service';
import { AuthApiService } from './auth-api.service';
import { CartManagerService } from './cart-manager.service';
import { CartPopupComponent } from '../../pages/main-page/products/cart-popup/cart-popup.component';
import { AngularMaterialModule } from '../components/angular-material/angular-material.module';
import { PopularProductsModule } from '../components/popular-products';

@NgModule({
  imports: [AngularMaterialModule, PopularProductsModule],
  declarations: [CartPopupComponent],
  providers: [CredentialService, AuthApiService, CartManagerService],
  entryComponents: [CartPopupComponent]
})
export class ServicesModule {}
