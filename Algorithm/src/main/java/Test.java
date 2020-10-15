import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author kxj
 * @date 2020/8/11 18:52
 * @desc
 */
public class Test {

    public static void main(String[] args) {

        int i=0;
        aow(i++);
        String a = "123";
        aow1(a);
        System.out.println(a);
        System.out.println(i);

        if(null instanceof Object){
            System.out.println(111);
        }

        List list = new ArrayList();
        list.add(1);
        row3(list);
        System.out.println(list.get(1));


    }

    private static void row3(List list) {
        list.add(2);
        list = new ArrayList();
        list.add(3);
        list.add(4);
    }

    private static void aow(int i) {
        i+=2;
    }
    private static void aow1(String a) {
        a = a + "456";
    }

}
