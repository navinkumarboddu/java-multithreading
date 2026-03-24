package com.study.service;



import com.study.domain.DeliveryDetails;
import com.study.domain.DeliveryOptionEnum;
import com.study.domain.ProductInfo;
import com.study.util.CommonUtil;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static com.study.util.CommonUtil.objectMapper;
import static com.study.util.CommonUtil.requestBuilder;
import static com.study.util.LoggerUtil.log;


public class DeliveryService {

    public  static String DELIVERY_DETAILS_URL = "http://127.0.0.1:8000/virtual-threads/src/main/resources/deliveryDetails.json";
    public DeliveryDetails retrieveDeliveryInfo(ProductInfo productInfo){
        log("retrieving dleivery details for productInfo : " + productInfo);
        CommonUtil.sleep(1000);
        log("retrieveDeliveryInfo after Delay");
        return new DeliveryDetails(List.of(DeliveryOptionEnum.NEXT_DAY, DeliveryOptionEnum.TWO_DAY));

    }

    public DeliveryDetails retrieveDeliveryInfoHttp(ProductInfo productInfo) throws IOException, InterruptedException {
        var httpClient = CommonUtil.httpClient;
        var httpRequest = requestBuilder(DELIVERY_DETAILS_URL);
        HttpResponse<String> response =
                httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + response.statusCode());
        return objectMapper.readValue(response.body(), DeliveryDetails.class);

    }
}
