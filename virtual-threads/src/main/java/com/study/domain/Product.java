package com.study.domain;

public record Product(String productId,
                      ProductInfo productInfo,
                      Reviews reviews) {
}
