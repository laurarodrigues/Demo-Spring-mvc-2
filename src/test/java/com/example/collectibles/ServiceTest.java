package com.example.collectibles;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.collectibles.beans.Product;
import com.example.collectibles.dao.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testSearchByName(){
        Mockito.doReturn(getMockProducts(1)).when(productRepository).searchByName("");
        List<Product> products = this.productRepository.searchByName("");
        assertEquals(1,products.size());
        

    }

    private Iterable<Product> getMockProducts(int size){
        List<Product> products = new ArrayList<>(size);
        for(int i=0;i<size; i++){
            Product product1 = new Product();
            product1.setId(1+i);
            product1.setName("Test_" + i);
            product1.setDescription("Beschreibung von " + product1.getName());
            product1.setRating(1);
            product1.setCategory_id(1);
            products.add(new Product());
            return products;
        }
        return products;
    }

}
