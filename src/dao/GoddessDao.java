package dao;

import db.DBUtil;
import model.Goddess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GoddessDao.java
 * @Description:
 * @Version: v1.0.0
 * @author: shihy
 * @date 2019Äê01ÔÂ23ÈÕ
 */
public class GoddessDao {
    public void addGoddess() throws Exception{

    }
    public void delGoddess() {
    }
    public void updateGoddess() {

    }
    public List<Goddess> query() throws Exception{
        Connection conn = DBUtil.getConnection();
        Statement sta = conn.createStatement();
        ResultSet res = sta.executeQuery("select t.*  from imooc_goddess t");
        List<Goddess> gs = new ArrayList<>();
        Goddess g = null;
        while (res.next()) {
            g = new Goddess();
            g.setUser_name(res.getString("user_name"));
            g.setAge(res.getInt("age"));
            gs.add(g);
        }
        return gs;
    }
    public Goddess get() {
        return new Goddess();
    }
}
