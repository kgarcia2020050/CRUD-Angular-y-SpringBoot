import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PersonaService } from 'src/app/services/persona.service';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/persona';

@Component({
  selector: 'app-ver-persona',
  templateUrl: './ver-persona.component.html',
  styleUrls: ['./ver-persona.component.css'],
  providers: [PersonaService],
})
export class VerPersonaComponent implements OnInit {
  public getIdPersona: Persona;

  constructor(
    private _activatedRoute: ActivatedRoute,
    private _personaService: PersonaService,
    private _router: Router
  ) {
    this.getIdPersona = new Persona(0, '', '', '', '', 0);
  }

  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe((idUsuario) => {
      this.obtenerPersona(idUsuario.get('id'));
    });
  }

  obtenerPersona(id) {
    this._personaService.personaId(id).subscribe({
      next: (response: any) => {
        this.getIdPersona = response;
        console.log(response);
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  modificarPersona(idUsuario) {
    this._personaService
      .actualizarPersona(idUsuario, this.getIdPersona)
      .subscribe({
        next: (response: any) => {
          this._router.navigate(['']);
        },
        error: (error: any) => {
          console.log(error);
        },
      });
  }
}
