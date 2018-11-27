package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory =categoryService.findOne(1);
        //System.out.println(productCategory.toString());
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List <ProductCategory> list =categoryService.findAll();
        System.out.println(list.toString());
    }

    @Test
    public void findByCategoryTypeIn() {
        List <ProductCategory> list=categoryService.findByCategoryTypeIn(Arrays.asList(8,9,11));
        System.out.println(list.toString());
    }

    @Test
    public void sava() {
         ProductCategory productCategory =new ProductCategory();
//        productCategory.setCategoryType(11);
//        productCategory.setCategoryName("男生专享");
//        categoryService.sava(productCategory);

        productCategory.setCategoryId(10);
        productCategory.setCategoryName("女生专享");
        productCategory.setCategoryType(11);
        categoryService.sava(productCategory);


    }


}