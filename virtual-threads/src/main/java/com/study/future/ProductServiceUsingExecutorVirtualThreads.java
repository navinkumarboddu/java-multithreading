package com.study.future;



import com.study.domain.Product;
import com.study.domain.ProductInfo;
import com.study.domain.Reviews;
import com.study.service.ProductInfoService;
import com.study.service.ReviewService;

import java.util.concurrent.*;

public class ProductServiceUsingExecutorVirtualThreads {

    static ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;

    public ProductServiceUsingExecutorVirtualThreads(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws ExecutionException, InterruptedException, TimeoutException {

        Future<ProductInfo> productInfoFuture = executorService.submit(() -> productInfoService.retrieveProductInfo(productId));
        Future<Reviews> reviewFuture = executorService.submit(() -> reviewService.retrieveReviews(productId));

        ProductInfo productInfo = productInfoFuture.get(); // This is a  blocking call.
        //ProductInfo productInfo = productInfoFuture.get(2, TimeUnit.SECONDS);
        Reviews reviews = reviewFuture.get(); // This is a  blocking call.
        //Review review = reviewFuture.get(2, TimeUnit.SECONDS);

        return new Product(productId, productInfo, reviews);
    }

}
