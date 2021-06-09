package com.utn.ParcialFutbol.service;

import com.utn.ParcialFutbol.model.Currency;
import com.utn.ParcialFutbol.model.Persona;
import com.utn.ParcialFutbol.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public void add(Currency c) {
        currencyRepository.save(c);
    }

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Integer id) {
        return currencyRepository.findById(id)
                .orElseThrow( ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deleteCurrencyById(Integer id) {
        currencyRepository.delete( getCurrencyById(id) );
    }
}
