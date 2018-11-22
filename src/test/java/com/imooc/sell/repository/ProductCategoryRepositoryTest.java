package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        //Object  productCategory1 = repository.findById(1);
        ProductCategory productCategory2 = repository.findById(1).orElse(null);
        System.out.println(productCategory2.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory2 = repository.findById(2).orElse(null);
        productCategory2.setCategoryType(10);
        repository.save(productCategory2);
    }

    @Test
    public void getList(){
        List<ProductCategory> list =repository.findAll();
        System.out.println(list.toString());
    }

}