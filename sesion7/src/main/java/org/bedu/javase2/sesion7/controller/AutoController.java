package org.bedu.javase2.sesion7.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.javase2.sesion7.entity.Auto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autos")
@Slf4j
public class AutoController {
    @GetMapping("/saludo")
    public String saluda(){
        return "Hola Autos";
    }

    @PostMapping("/auto")
    public void recibe(@RequestBody Auto auto){
        log.info(auto.toString());
    }
}
