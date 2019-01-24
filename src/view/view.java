package view;

import action.GoddessAction;
import model.Goddess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: view.java
 * @Description:
 * @Version: v1.0.0
 * @author: shihy
 * @date 2019��01��24��
 */
public class view {
    private static final String CONTEXT = "��ӭ����Ů�������\n" +
            "������Ů������Ĺ����б�\n" +
            "[MAIN/M]:���˵�\n" +
            "[QUERY/Q]:�鿴ȫ��Ů�����Ϣ\n" +
            "[GET/G]:�鿴ĳλŮ�����ϸ��Ϣ\n" +
            "[ADD/A]:���Ů����Ϣ\n" +
            "[UPDATE/U]:����Ů����Ϣ\n" +
            "[DELETE/D]:ɾ��Ů����Ϣ\n" +
            "[SEARCH/S]:��ѯŮ����Ϣ(�����������ֻ�������ѯ)\n" +
            "[EXIT/E]:�˳�Ů�����\n" +
            "[BREAK/B]:�˳���ǰ���ܣ��������˵�";

    private static final String OPERATION_MAIN = "MAIN";
    private static final String OPERATION_QUERY = "QUERY";
    private static final String OPERATION_GET = "GET";
    private static final String OPERATION_ADD = "ADD";
    private static final String OPERATION_UPDATE = "UPDATE";
    private static final String OPERATION_DELETE = "DELETE";
    private static final String OPERATION_SEARCH = "SEARCH";
    private static final String OPERATION_EXIT = "EXIT";
    private static final String OPERATION_BREAK = "BREAK";

    public static void main(String[] args) {
        System.out.println(CONTEXT);
        Scanner scanner = new Scanner(System.in);
        Goddess goddess = new Goddess();
        String previous = null;
        GoddessAction action = new GoddessAction();
        Integer step = 1;
        while (scanner.hasNext()) {
            String in = scanner.next().toString();
            if (OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("���ѳɹ��˳�Ů�������");
                break;
            } else if (OPERATION_QUERY.equals(in.toUpperCase()) || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())) {
                try {
                    List<Goddess> list = action.query();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getId() + ",������" + list.get(i).getUser_name());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (OPERATION_ADD.equals(in.toUpperCase()) || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase()) || OPERATION_ADD.equals(previous)) {
                previous = OPERATION_ADD;
                if (1 == step) {
                    System.out.println("������Ů��ġ�������");
                } else if (2 == step) {
                    goddess.setUser_name(in);
                    System.out.println("������Ů��ġ����䡿");
                } else if (3 == step) {
                    goddess.setAge(Integer.valueOf(in));
                    System.out.println("������Ů��ġ����ա�����ʽ�磺yyyy-MM-dd");
                } else if (4 == step) {
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        birthday = sf.parse(in);
                        goddess.setBirthday(birthday);
                        System.out.println("������Ů��ġ����䡿");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("������ĸ�ʽ��������������");
                    }
                } else if (5 == step) {
                    goddess.setEmail(in);
                    System.out.println("������Ů��ģ��ֻ��ţ�");
                } else if (6 == step) {
                    goddess.setMobile(in);
                    try {
                        action.add(goddess);
                        System.out.println("����Ů��ɹ�");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("����Ů��ʧ��");
                    }finally {
                        step = 1;
                        previous = null;
                    }
                }
                if (OPERATION_ADD.equals(previous)) {
                    step++;
                }
            } else {
                System.out.println("�������ֵΪ��" + in);
            }
        }
    }

}
