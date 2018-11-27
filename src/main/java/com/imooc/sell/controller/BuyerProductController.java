package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.ProductCategoryService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.utils.ResultVOUtil;
import com.imooc.sell.vo.ProductInfoVO;
import com.imooc.sell.vo.ProductVO;
import com.imooc.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("list")
    public ResultVO List(){
        // 查询所有上架的商品
        List<ProductInfo> list =productInfoService.findUpAll();
        // 查询类目
        //传统方法
//        List<Integer> categoryTypeList =new ArrayList<>();
//        for (ProductInfo productInfo : list){
//             categoryTypeList.add(productInfo.getProductType()) ;
//        }

        //（java8 ，lambda）
        List<Integer> categoryTypeList =list.stream().map(e -> e.getProductType()).collect(Collectors.toList());
        List<ProductCategory> productCategoriesList=productCategoryService.findByCategoryTypeIn(categoryTypeList);
        // 数据拼装
        List<ProductVO> productVOList =new ArrayList<>();
        for (ProductCategory productCategory : productCategoriesList){
            ProductVO productVO =new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for (ProductInfo productInfo : list){
                if (productInfo.getProductType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO =new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
