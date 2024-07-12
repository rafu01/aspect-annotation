package com.aspectannotation.service;

import com.aspectannotation.annotations.Write;
import com.aspectannotation.dto.Product;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Write
    public void save(Product product) {
        // some transformation function
        product.setQuantity(product.getQuantity()-1);
    }

}
