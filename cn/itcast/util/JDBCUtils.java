package cn.itcast.util;

//import com.alibaba.druid.pool.DruidDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {

    public static DataSource ds;

    static {
        try {
            Properties pro = new Properties();

            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            ds= DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
    	
        return ds.getConnection();
    }

    public static DataSource getDataSource() {
    	
    	System.out.println("ds===="+ds);
        return ds;
    }
}
