package com.example.guitarApi.modules.entities.productEntities.products;

import com.example.guitarApi.modules.entities.productEntities.Enums.ProductType;

public interface IProduct {
    public Long getID();
    public String getName();
    public ProductType getProductType();

}
