package ar.com.ada.api.rrhh.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.rrhh.entities.Categoria;
import ar.com.ada.api.rrhh.services.CategoriaService;

@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {
        // cuand hagas un post o un put, pregunte al front que onda de esto
        // (responseentity<?>) e return
        // ingresas un request y retorna un response
        // crear: formato (requestbody e la clase y objeto que se va a quedar)
        categoriaService.crearCategoria(categoria);
        // categoria de tipo service que puede chamar a um metodo
        // que esta en intermedia entre controller y repo

        return ResponseEntity.ok(categoria); // ok es una respuesta de status 200 en postman

    }

    @GetMapping("/categorias") //entre parentesis está la url de postman
    public ResponseEntity<List<Categoria>> listarCategorias() {

        return ResponseEntity.ok(categoriaService.listarCategorias());
// traer de respuesta el status 200 y la lista
// no se necesita poner el parametro en un get sin filtro

//la misma url para lo mismo get no va a funcionar, asi si quieres traer
//todas de la lista, pones /categorias
//si quieres traer la lista de categoria por empleados, filtrar por ex por dni 
// (/categoria/{id}) y pones en parametro pathVariable de lo que quieres filtrar "@PathVariable int dni"
    }

}