package br.com.fiap.mscatalogoprodutos.controller;

import br.com.fiap.mscatalogoprodutos.config.BatchConfig;
import br.com.fiap.mscatalogoprodutos.entity.Product;
import br.com.fiap.mscatalogoprodutos.service.ProductService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final Job importProductJob;
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    public ProductController(ProductService productService, Job importProductJob) {
        this.productService = productService;
        this.importProductJob = importProductJob;
    }


    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());

    }


    @PostMapping("/runJob")
    public ResponseEntity<String> runJob() throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
        jobLauncher.run(importProductJob, jobParameters);
        return ResponseEntity.ok("Job iniciado com sucesso!");
    }

}
