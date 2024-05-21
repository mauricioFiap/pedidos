package br.com.fiap.mscatalogoprodutos.config;

import br.com.fiap.mscatalogoprodutos.entity.Product;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product item) throws Exception {
        item.setPrice(item.getPrice() * 1.1);
        return item;
    }
}
