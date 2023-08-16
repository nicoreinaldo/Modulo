package com.project.domain;

import lombok.*;

import java.util.List;

/**
 * Uso lombok, ya que es una libreria que me permite mantener el codigo mas limpio
 * y sabe manejar de manera muy efectiva los constructores
 */
@Getter @Setter @AllArgsConstructor
public class ModuloParam {

    private int t;
    private List<Modulo> list;

}
