package com.utn.ParcialFutbol.controller;

import com.utn.ParcialFutbol.model.Currency;
import com.utn.ParcialFutbol.model.Persona;
import com.utn.ParcialFutbol.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public void addCurrency(@RequestBody Currency c){
        currencyService.add(c);
    }

    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency getCurrrencyById(@PathVariable Integer id){
        return currencyService.getCurrencyById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteCurrencyById(@PathVariable Integer id){
        currencyService.deleteCurrencyById(id);
    }

}
