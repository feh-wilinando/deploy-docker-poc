package br.com.fws.docker.app.repositories;

import br.com.fws.docker.app.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by nando on 06/05/17.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    Optional<Product> findProductByName(String name);

}
