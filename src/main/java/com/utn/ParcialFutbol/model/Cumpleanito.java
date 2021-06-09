package com.utn.ParcialFutbol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cumpleanito {

    @Id
    @GeneratedValue
    private Integer id;

    private  LocalDate fecha;

    @OneToOne
    @JoinColumn(name="cumple_id")
    private Persona cumpleaniero;

    @JsonIgnore
    @ManyToMany
    private  Set<Persona> invitados;


}
