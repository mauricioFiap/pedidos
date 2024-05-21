package br.com.fiap.mscatalogoprodutos.repository;

import br.com.fiap.mscatalogoprodutos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
