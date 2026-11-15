package com.gremio.repository;

import com.gremio.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Spring Data JPA genera save(), findAll(), findById(), deleteById() automáticamente
}
