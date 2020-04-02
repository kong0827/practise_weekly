package com.kxj;

/**
 * @ClassName GroupingDemo
 * @Description TODO
 * @Author kongxiangjin
 * @Date 2019/10/15 16:13
 * @Version 1.0
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupingDemo {
    /**
     * 选手集合
     */
    private static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        // 初始化选手
        Player player1 = new Player("a", 22);
        Player player2 = new Player("b", -9);
        Player player3 = new Player("c", 13);
        Player player4 = new Player("d", 17);
        Player player5 = new Player("e", 0);
        Player player6 = new Player("f", -11);
        Player player7 = new Player("g", -2);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);

        //选手总人数
        int count = players.size();
        //总分数
        double sum = sumMethod(players);
        //分组数
        int groupNum = 2;
        //平均数
        double average = sum / groupNum;
        //每组人数
        int num = count / groupNum;        
        //double diff = sum;
        boolean flag = false;
        //倒叙
        Collections.sort(players);

        List<Player> groupList1 = new ArrayList<>();   
        List<Player> groupList2 = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            groupList1.add(players.get(i));
        }
        for (int i = num; i < count; i++) {
            groupList2.add(players.get(i));
        }

        for (int i = 0; i < groupList2.size(); ) {
            // 先取出第二组中最大的选手
            Player p2 = groupList2.get(i);
            for (int j = groupList1.size() - 1; j >= 0; j--) {
                // 集合中的对象进行交换
                Player p1 = groupList1.get(j);
                groupList1.remove(p1);
                groupList1.add(p2);
                groupList2.remove(p2);
                groupList2.add(p1);
                double sum1 = sumMethod(groupList1);
//              double sum2 = sumMethod(groupList2);

                // 如果交换后的数据不满足条件，说明上一个值即为临界值，则进行回退
                if (sum1 > average && j != 0) {
                    groupList1.remove(p2);
                    groupList1.add(p1);
                    groupList2.remove(p1);
                    groupList2.add(p2);
                } else if (sum1 > average && j == 0) {
                    break;
                } else {
                    // 找到临界值后跳出循环
                    flag = true;
                    break;
                }

            }
            if (flag == true) {
                System.out.println(groupList1);
                System.out.println(groupList2);
                break;
            }
            // 每次循环需要对组一进行重新排序，再交换的过程中，原先的倒叙会被打乱。
            Collections.sort(groupList1);
        }
    }

    /**
     * 求总分数
     * @param players
     * @return
     */
    private static double sumMethod(List<Player> players) {
        double sum = 0;
        for (Player player : players) {
            sum += player.getScore();
        }
        return sum;
    }
}
