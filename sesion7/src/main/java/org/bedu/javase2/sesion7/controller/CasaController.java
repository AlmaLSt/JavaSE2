package org.bedu.javase2.sesion7.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.javase2.sesion7.entity.Auto;
import org.bedu.javase2.sesion7.entity.Casa;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casas")
@Slf4j
public class CasaController {

    @PostMapping("/casa")
    public void recibe(@RequestBody Casa casa){
        log.info(casa.toString());
    }
}
