package cn.itcast.dao;

import cn.itcast.domain.Product;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void addProduct(Product product) {
        String sql="insert into product(pid,pname,shop_price,pdesc) values(?,?,?,?);";


        int flag =  template.update(sql ,product.getPid(),product.getPname(),product.getShop_price(),product.getPdesc());

    }

    public Product findByCid(String cid) {
        try{
            String sql="select * from product where pid= ?";
            Product user = template.queryForObject(sql,new BeanPropertyRowMapper<Product>(Product.class),cid);

             return user;
        }
        catch (EmptyResultDataAccessException e ) {
            return null;
        }

    }
}
