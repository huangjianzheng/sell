package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productService;


    @Test
    public void findOne() {
        ProductInfo productInfo =productService.findOne("123456");
        System.out.println(productInfo.toString());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo>list =productService.findUpAll();
        System.out.println(list.toString());
    }

    @Test
    public void findAll() {
        PageRequest request =new PageRequest(0,2);
        Page<ProductInfo>page =productService.findAll(request);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("奶茶");
        productInfo.setProductPrice(new BigDecimal(10.2));
        productInfo.setProductStock(80);
        productInfo.setProductDescription("奶盖绿茶");
        productInfo.setProductIcon("hhtp://xxx.com");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductType(10);
        ProductInfo productInfo1=productService.save(productInfo);
        System.out.println(productInfo.toString());
    }
}