import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ContentComponent } from './components/content/content.component';
import { CreateComponent } from './components/content/create/create/create.component';
import { ProposeTripComponent } from './components/content/proposeTrip/propose-trip/propose-trip.component';
import { LookajourneyComponent } from './components/lookajourney/lookajourney.component';


const routes: Routes = [
  { path: '', component: ContentComponent },
  { path: 'create', component: CreateComponent },
  { path: 'proposeTrip', component: ProposeTripComponent },
  { path: 'carousel', component: CarouselComponent },
  { path: 'lookajourney', component: LookajourneyComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
