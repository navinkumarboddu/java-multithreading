package com.study.service;


import com.study.domain.ProductInfo;
import com.study.domain.ProductOption;
import com.study.util.CommonUtil;
import com.study.util.LoggerUtil;

import java.io.IOException;
import java.util.List;

public class ProductInfoService {

    //virtual-threads/src/main/resources/deliveryDetails.json
    public  static String PRODUCT_INFO_URL = "http://127.0.0.1:8000/virtual-threads/src/main/resources/productInfo.json";


    public ProductInfo retrieveProductInfoHttp(String productId) throws IOException, InterruptedException {
      return null;

    }

    public ProductInfo retrieveProductInfo(String productId) {
        CommonUtil.sleep(1000);
//        throw new RuntimeException("retrieveProductInfo");
        List<ProductOption> productOptions = List.of(new ProductOption("64GB", "Black", 699.99),
                new ProductOption("128GB", "Black", 749.99));
        LoggerUtil.log("retrieveProductInfo after Delay");
        return new ProductInfo(productId, productOptions);
    }



    public ProductInfo retrieveProductInfoV2(String productId) {
        CommonUtil.sleep(2000);
        List<ProductOption> productOptions = List.of(new ProductOption("64GB", "Black", 699.99),
                new ProductOption("128GB", "Black", 749.99));
        LoggerUtil.log("retrieveProductInfo after Delay v2 ");
        return new ProductInfo(productId, productOptions);
    }

    public ProductInfo retrieveProductInfoV3(String productId) {
        CommonUtil.sleep(8000);
        List<ProductOption> productOptions = List.of(new ProductOption("64GB", "Black", 699.99),
                new ProductOption("128GB", "Black", 749.99));
        LoggerUtil.log("retrieveProductInfo after Delay v3 ");
        return new ProductInfo(productId, productOptions);
    }

}
