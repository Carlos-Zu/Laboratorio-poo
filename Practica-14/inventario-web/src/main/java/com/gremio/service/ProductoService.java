package com.gremio.service;

import com.gremio.model.Producto;
import com.gremio.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public void guardar(Producto producto) {
        repo.save(producto);
    }

    public Producto buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
