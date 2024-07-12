package com.proyecto.tienda.controller;

import com.proyecto.tienda.entity.Producto;
import com.proyecto.tienda.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.findAll();
    }

    @GetMapping("/productos/{id}")
    public Optional<Producto> getProducto(@PathVariable long id) {
        return productoService.findById(id);
    }

    @PostMapping("/create")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PatchMapping("/update/{id}")
    public Producto updateProducto(@PathVariable long id,@RequestBody Producto producto) {
        producto.setId(id);
        return productoService.save(producto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProducto(@PathVariable long id) {
        productoService.delete(id);
    }
}
