package com.project.services;

import com.project.domain.Modulo;
import com.project.domain.ModuloResponse;
import com.project.exception.InvalidParameterException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloService {

    /**
     * Recorro la lista de x ,y ,n donde busco encontrar el maximo entero k dado que (0 ≤ 𝑘 ≤ 𝑛) y  (𝑘 mod 𝑥 = 𝑦)
     * uso stream en vez de for ya que me parece mas legible.
     * Podria usar parallel stream que es mas rapido
     * pero en esta funcion quieros ir agregado a la lista en orden de como fueron insertados.
     *
     * La complejidad de este algoritmo es : O(n)
     * Luego a esto hay qeu sumarle la de maxMod.
     *
     * Esta fucion no se podria optimizar mas ya que tengo que recorrer todos los campos
     *
     * @param list
     * @return
     */
    public List<Integer> findMaxMod(List<Modulo> list) {
        return list.stream()
                .map(mod -> maxMod(mod.getX(), mod.getY(), mod.getN()))
                .collect(Collectors.toList());

    }

    /**
     *
     * @param n
     * @param x
     * @param y
     * @return int
     *
     * Recorro de atras para adelante para que la busqueda sea mas rapida
     * La peor complejidad que puede tener este algoritmo es : O(n)
     *
     * Tal vez la complejidad de este algoritmo se podria achicar buscando otra opcion matematica
     * ya que si el numero es grandicimos y tiene que chequear todos los casos, no es lo mas optimo,
     * pero en fin de cuentas me pareceme muy bien implementado.
     */
    public int maxMod(int x, int y, int n) {
        if(n < 0 || x < 0 || y < 0) throw new InvalidParameterException("no se permiten negativos");

        for(int k = n; k >0; k--) {
            if (k % x == y) return k;
        }
        return 0;
    }

}
