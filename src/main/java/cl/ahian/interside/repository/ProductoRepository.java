package cl.ahian.interside.repository;

import cl.ahian.interside.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}