package cn.itcast.service;

import cn.itcast.domain.Product;

public interface ProductService {
    void addProduct(Product product);

    Product findByCid(String cid);
}
