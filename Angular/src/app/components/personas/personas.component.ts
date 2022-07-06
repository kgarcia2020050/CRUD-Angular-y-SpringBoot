import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/persona';
import { PersonaService } from 'src/app/services/persona.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css'],
  providers: [PersonaService],
})
export class PersonasComponent implements OnInit {
  public getPersonas: Persona;

  public postPersona: Persona;

  constructor(
    private _personaService: PersonaService,
    private _router: Router
  ) {
    this.postPersona = new Persona(0, '', '', '', '', 0);
  }

  ngOnInit(): void {
    this.obtenerPersonas();
  }

  obtenerPersonas() {
    this._personaService.obtenerPersonas().subscribe({
      next: (response: any) => {
        this.getPersonas = response;
        console.log(response);
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  nuevaPersona(agregar) {
    this._personaService.agregarPersona(this.postPersona).subscribe({
      next: (response: any) => {
        agregar.reset();
        this.obtenerPersonas();
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  verPersona(idPersona) {
    this._router.navigate(['verPersona/' + idPersona]);
  }

  obtenerPersona(id) {
    this._personaService.personaId(id).subscribe({
      next: (response: any) => {
        console.log(response);
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  borrarPersona(id) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Estás a punto de eliminar al usuario ' + id,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonText: 'Cancelar',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminarlo',
    }).then((result) => {
      if (result.isConfirmed) {
        this._personaService.eliminarEmpleado(id).subscribe({
          next: (response: any) => {
            Swal.fire('Eliminado', 'Borraste al usuario ' + id, 'success');
            this.obtenerPersonas();
          },
          error: (error: any) => {
            console.log(error);
          },
        });
      }
    });
  }
}
