package cl.ahian.interside.repository;

import cl.ahian.interside.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
}