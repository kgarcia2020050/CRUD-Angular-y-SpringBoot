import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../models/persona';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  public url = 'http://localhost:8080/api/control/';

  constructor(private _http: HttpClient) {}

  obtenerPersonas(): Observable<any> {
    return this._http.get(this.url + 'empleados');
  }

  agregarPersona(modeloPersona: Persona): Observable<any> {
    return this._http.post(this.url + 'nuevaPersona', modeloPersona);
  }

  personaId(id: Number): Observable<any> {
    return this._http.get(this.url + 'persona/' + id);
  }

  actualizarPersona(id: any, personaEditada: Persona): Observable<any> {
    return this._http.put(this.url + 'actualizar/' + id, personaEditada);
  }

  eliminarEmpleado(id: any): Observable<any> {
    return this._http.delete(this.url + 'borrar/' + id);
  }
}
