package cl.ahian.interside.repository;

import cl.ahian.interside.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {



}