import java.util.ArrayList;
import java.util.List;

/**
 * Created by tongheshang on 2018/1/6.
 * https://twitter.com/heshengbang
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class Test {
    @org.junit.Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();
        int num = 1;
        while (num <= 100) {
            list.add(num);
            num++;
        }
        num = 1;
        while (list.size() > 1) {
            if (num % 3 == 0) {
                list.remove(0);
            } else {
                int temp = list.get(0);
                list.remove(0);
                list.add(list.size(), temp);
            }
            num++;
        }
        System.out.print(list.get(0));
    }

    @org.junit.Test
    public void overflow() {
        System.out.println(1147483647 * 2 +2);
    }
}
