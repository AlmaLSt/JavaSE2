package org.bedu.javase2.sesion7.controller;

import org.bedu.javase2.sesion7.entity.Empleado;
import org.bedu.javase2.sesion7.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    private Flux<Empleado> getAllEmpleadps(){
        return empleadoRepository.findAllEmpleados();
    }

    @GetMapping("/{id}")
    private Mono<Empleado> getEmpleadoById(@PathVariable String id){
        return empleadoRepository.findEmpleadoById(id);
    }

    @PostMapping("/update")
    private Mono<Empleado> updateEmpleado(@RequestBody Empleado empleado){
        return empleadoRepository.updateEmpleado(empleado);
    }

}
