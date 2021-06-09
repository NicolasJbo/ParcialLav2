package com.utn.ParcialFutbol.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.AccessType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, property="typePerson", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Jugador.class, name = "JUGADOR"),
        @JsonSubTypes.Type(value = Representante.class, name = "REPRESENTANTE"),
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El campo nombre es obligatorio")
    private String name;

    @NotNull(message = "El campo apellido es obligatorio")
    private String lastName;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePerson typePerson();

    @OneToOne
    private Cumpleanito cumpleanito;

    @ManyToMany(mappedBy = "invitados",cascade = CascadeType.ALL)
    private Set<Cumpleanito> cumpleanitos;

}
