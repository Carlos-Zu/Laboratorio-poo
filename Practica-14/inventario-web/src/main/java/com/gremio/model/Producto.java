package com.gremio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;
    private Double precio;
    private Integer stock;

    // Constructor vacío (requerido por JPA)
    public Producto() {}

    // Constructor con campos
    public Producto(String nombre, String categoria, Double precio, Integer stock) {
        this.nombre    = nombre;
        this.categoria = categoria;
        this.precio    = precio;
        this.stock     = stock;
    }

    // Getters y Setters
    public Long    getId()        { return id; }
    public String  getNombre()    { return nombre; }
    public String  getCategoria() { return categoria; }
    public Double  getPrecio()    { return precio; }
    public Integer getStock()     { return stock; }

    public void setId(Long id)               { this.id = id; }
    public void setNombre(String nombre)    { this.nombre = nombre; }
    public void setCategoria(String c)      { this.categoria = c; }
    public void setPrecio(Double precio)    { this.precio = precio; }
    public void setStock(Integer stock)     { this.stock = stock; }
}
