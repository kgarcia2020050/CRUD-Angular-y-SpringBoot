import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonasComponent } from './components/personas/personas.component';
import { VerPersonaComponent } from './components/ver-persona/ver-persona.component';

const routes: Routes = [
  { path: 'personas', component: PersonasComponent },
  { path: '', redirectTo: 'personas', pathMatch: 'full' },
  { path: 'verPersona/:id', component: VerPersonaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
