package com.personas.demo.controller;

import com.personas.demo.exceptions.ResourceNotFoundException;
import com.personas.demo.models.Persona;
import com.personas.demo.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/control/")//url para acceder a las acciones del controlador
@CrossOrigin(origins = "http://localhost:4200")
public class Controlador {
    @Autowired
    private Repositorio repositorio;


    //metodo para listar a todos los empleados
    @GetMapping("/empleados")
    public List<Persona> listarEmpleados(){
        return repositorio.findAll();
    }

    //metodo para guardar a una persona
    @PostMapping("/nuevaPersona")
    public Persona agregarPersona(@RequestBody Persona persona){
        return repositorio.save(persona);
    }

    @GetMapping("/persona/{id}")
    public Persona empleadoId(@PathVariable Long id){
        Persona persona=repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encuentra al empleado con el ID " + id));
        return persona;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> modificarPersona(@PathVariable Long id,@RequestBody Persona personaEditada){
        Persona persona=repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encuentra al empleado con el ID " + id));
        persona.setNombre(personaEditada.getNombre());
        persona.setApellido(personaEditada.getApellido());
        persona.setEmail(personaEditada.getEmail());
        persona.setTelefono(personaEditada.getTelefono());
        persona.setEdad(personaEditada.getEdad());
        Persona personaActualizada=repositorio.save(persona);
        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarPersona(@PathVariable Long id){
        Persona persona = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra al empleado con el ID " + id));

        repositorio.delete(persona);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
