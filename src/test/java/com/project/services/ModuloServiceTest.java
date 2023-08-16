package com.project.services;

import com.project.domain.Modulo;
import com.project.exception.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * En este caso voy a realizar el test usando Junit5
 * aqui testearemos la clase ModuloService y sus dos metodos
 */
class ModuloServiceTest {

    //Declaro la instancia con la clase a testear
    private ModuloService moduloService = new ModuloService();

    //Aca probamos un caso exitoso de maxMod, donde parametros de entrada son:
    // x:7 y:5 n:12345
    //Salida correcta 12339
    @Test
    void maxMod() {
        assertEquals(12339, moduloService.maxMod(7, 5, 12345));
    }

    //Aca probamos si recibimos un parametro negativo, arroje excepción
    @Test
    void negativeParamInmaxMod() {
        assertThrows(InvalidParameterException.class, () -> moduloService.maxMod(-1, 2, 4));
    }

    //Aca probamos creando una lista con 3 registros, en expected gaurdamos la salida que esperamos de cada objeto
    @Test
    void findMaxMod() {
        List<Modulo> input = Arrays.asList(new Modulo(7, 5, 12345), new Modulo(5, 0, 4), new Modulo(10, 5, 15));
        List<Integer> expected = Arrays.asList(12339, 0, 15);

        assertEquals(expected, moduloService.findMaxMod(input));
    }
}