package com.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * En este caso podria devolver directamente una lista de enteros en el controller
 * pero me resulta mejor practica devolver una entidad, la cual le da mas sentido a la respuesta
 * y tambien llegado el caso de agregar campos de respuesta, esta serviria
 */
@Getter
@Setter
@NoArgsConstructor
public class ModuloResponse {
    private List<Integer> list;
}
