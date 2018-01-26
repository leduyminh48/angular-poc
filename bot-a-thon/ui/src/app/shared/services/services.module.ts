import { NgModule } from '@angular/core';
import { CredentialService } from './credential.service';
import { AuthApiService } from './auth-api.service';
import { CartManagerService } from './cart-manager.service';
import { CartComponent } from '../../pages/main-page/products/cart/cart.component';
import { AngularMaterialModule } from '../components/angular-material/angular-material.module';

@NgModule({
  imports: [AngularMaterialModule],
  declarations: [CartComponent],
  providers: [CredentialService, AuthApiService, CartManagerService],
  entryComponents: [CartComponent]
})
export class ServicesModule {}
