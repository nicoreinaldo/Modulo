package com.project.controllers;

import com.project.domain.ModuloParam;
import com.project.domain.ModuloResponse;
import com.project.exception.InvalidParameterException;
import com.project.services.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * By Nicolas Reinaldo
 *
 * Aclaraciones : Voy a comentar codigo por demas, ya que en el dia a dia comento solo los metodos complejos para facilitar la lectura
 * al proximo desarrollador que vea el codigo. En este caso al ser un challenge, voy a explicar el porque de algunas cosas...
 *
 * La estructura la divido principalmente en servicios - dominio y controllador.
 * Si el proyecto creciera se podria dividir igual pero para cada area trabajada, por ejemplo : BusinessControllers - BusinessDomain ,etc..
 *
 * @RequestMapping("/api/v1") lo armo con /v1 ya que es buena practica usar versionado, por razones de compatibilidad hacia atras,
 * para una transicion controlado a migrar de versiones y probar, como tambien para documentar, etc..
 */

@RestController
@RequestMapping("/api/v1")
public class ModuloController {

    //Injeccion de dependencias
    @Autowired
    ModuloService moduloService;

    /**lo plante al Get distinto al ejercicio ya que me parece que el get tiene que usarse para obtener datos especificos
     * y no tener parametro muy complejos, para eso usamos el Post
     * En los dos uso de respuesta ResposeEntity ya que es la respuesta mas limpia y comoda que suelo usar en las empresas,
     * aunque en este caso no este devolviendo una entidad.
     * Tambien con ResponseEntity puedo devolver info extra como el estado de la respuesta Http, sea OK status 200 o sea una respuesta erronea
     *
     * Uso RequestParam para que sea requerido el parametro
     *
     * @param x
     * @param y
     * @param n
     * @return
     */
    @GetMapping("/modulo")
    public ResponseEntity<String> getModulo(@RequestParam int x, @RequestParam int y, @RequestParam int n) {
        try {
            return new ResponseEntity(moduloService.maxMod(x, y, n), HttpStatus.OK);
        } catch (InvalidParameterException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    /**
     * En este caso no seria la mejor forma en que yo lo implementaria, ya que no recibiera un parametro "t" (test cases)
     * ya que tengo el tamaño de los casos a probar en la lista, pero trate de respetar el enunciado
     *
     * @param param
     * @return
     */
    @PostMapping("/modulo")
    public ResponseEntity<ModuloResponse> postModulo(@RequestBody ModuloParam param) {
        if(param.getT() != param.getList().size()) {
            return new ResponseEntity("La cantidad de test cases (t) no puede ser distinto al tamaño de la lista", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(moduloService.findMaxMod(param.getList()), HttpStatus.OK);
    }

}
