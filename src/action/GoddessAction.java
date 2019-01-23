package action;

import dao.GoddessDao;
import model.Goddess;

import java.util.Date;

/**
 * @ClassName: GoddessAction.java
 * @Description:
 * @Version: v1.0.0
 * @author: shihy
 * @date 2019年01月23日
 */
public class GoddessAction {
    public static void main(String[] args) throws Exception{
        GoddessDao g = new GoddessDao();
      /*  List<Goddess> gs = g.query();
        for (Goddess goddess : gs) {
            System.out.println(goddess.getUser_name()+goddess.getAge());
        }*/
        Goddess g1 = new Goddess();
        g1.setUser_name("小美");
        g1.setAge(21);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@imooc.com");
        g1.setMobile("14752256731");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);
        Goddess g2=g.get(5);
        System.out.println(g2.toString());
//        g1.setId(3);

//        g.delGoddess(3);
//        g.updateGoddess(g1);
//        g.addGoddess(g1);
    }
}
