package cn.itcast.dao;

import cn.itcast.domain.Indent;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.resource.cci.ResultSet;

public class IndentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    
    
                  
    public void addIndent(Indent indent) {

        String sql="insert into indent values(?,?,?,'',?);";


      template.update(sql ,indent.getId(),indent.getIdate(),indent.getIdesc(),indent.getCid());

    }

    public List<Indent> findAll(String username) {
        String sql="select * from indent where cid = '"+username+"'";
        List<Indent> users= template.query(sql,new BeanPropertyRowMapper<Indent>(Indent.class));
        return users;
    }

    public List<Indent> findAll() {
        String sql="select * from indent  ";
        List<Indent> users= template.query(sql,new BeanPropertyRowMapper<Indent>(Indent.class));
        return users;
    }


    public void deleteIndent(String valueAt) {
        String sql="delete from indent where id=?";
        template.update(sql,valueAt);
    }

    public void updateIndent(Indent indent) {

        String sql=null;
        if("true".equals(indent.getStatus())){
          sql ="update indent set idesc = ? , status='已受理'  where id =?";

        }else{
          sql="update indent set idesc = ?  , status='受理中' where id =?";

        }



        template.update(sql,indent.getIdesc(),indent.getId());
    }

    public Indent findById(String valueAt) {
        try{
            String sql="select * from indent where id= ?";
            Indent user =  template.queryForObject(sql,new BeanPropertyRowMapper<Indent>(Indent.class),valueAt);


            return user;
        }
        catch (EmptyResultDataAccessException e ) {
            return null;
        }
    }
    
     
}
