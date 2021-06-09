package com.utn.ParcialFutbol.controller;

import com.utn.ParcialFutbol.model.Cumpleanito;
import com.utn.ParcialFutbol.model.Invitado;
import com.utn.ParcialFutbol.service.CumpleanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cumple")
public class CumpleaniosController {


    CumpleanioService cumpleanioService;
    @Autowired
    public CumpleaniosController(CumpleanioService cumpleanioService) {
        this.cumpleanioService = cumpleanioService;
    }

    @PostMapping
    public  void  addCumple(@RequestParam LocalDate date, @RequestParam Integer idPersona){
        cumpleanioService.add(date,idPersona);
    }
    @GetMapping
    public List<Cumpleanito> getAll(){
       return cumpleanioService.getAll();
    }
    @PutMapping("/{idCumple}/invitados/{idInvitado}")
    public void addInvitadosToCumple(@PathVariable Integer idCumple,@PathVariable Integer idInvitado){
        cumpleanioService.addInvitadosToCumple(idCumple,idInvitado);
    }

    @GetMapping("/{idCumple}")
    public List<Invitado> getInvitados(@PathVariable Integer idCumple) throws IOException, InterruptedException {
       return cumpleanioService.getInvitados(idCumple);
    }


}
