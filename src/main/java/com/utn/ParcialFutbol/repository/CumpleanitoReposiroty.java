package com.utn.ParcialFutbol.repository;

import com.utn.ParcialFutbol.model.Cumpleanito;
import com.utn.ParcialFutbol.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CumpleanitoReposiroty extends JpaRepository<Cumpleanito,Integer> {
}
