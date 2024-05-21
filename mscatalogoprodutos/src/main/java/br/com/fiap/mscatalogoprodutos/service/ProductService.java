package br.com.fiap.mscatalogoprodutos.service;

import br.com.fiap.mscatalogoprodutos.config.BatchConfig;
import br.com.fiap.mscatalogoprodutos.entity.Product;
import br.com.fiap.mscatalogoprodutos.repository.ProductRepository;
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    BatchConfig batchConfig;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
       return productRepository.findAll();
    }


    // business methods
}
