package action;

import dao.GoddessDao;
import model.Goddess;

import java.util.List;

/**
 * @ClassName: GoddessAction.java
 * @Description:
 * @Version: v1.0.0
 * @author: shihy
 * @date 2019Äê01ÔÂ23ÈÕ
 */
public class GoddessAction {
    public static void main(String[] args) throws Exception{
        GoddessDao g = new GoddessDao();
        List<Goddess> gs = g.query();
        for (Goddess goddess : gs) {
            System.out.println(goddess.getUser_name()+goddess.getAge());
        }
    }
}
