package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao=new ProductDao();
    @Override
    public void addProduct(Product product) {

        productDao.addProduct(product);
    }

    @Override
    public Product findByCid(String cid) {
        return productDao.findByCid(cid);
    }
}
