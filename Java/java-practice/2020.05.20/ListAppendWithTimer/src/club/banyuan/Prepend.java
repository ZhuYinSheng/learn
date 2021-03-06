package club.banyuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较在基于数组的列表和基于链表的列表的第一个元素前插入n个值所需的时间
 * <p>
 * 1.创建一个计时器。
 * <p>
 * 2.计算将n个值添加到空链表的时间：
 * a.创建一个空的链表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 * <p>
 * 3.计算将n个值添加到空数组列表的时间：
 * a.创建一个空的数组列表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 */
public class Prepend {
  private final static int n = 100000;

  public static void main(String args[]) {

      TimerForAppendAndPrepend aTimer = new TimerForAppendAndPrepend();

      System.out.println("*****链表计算时间******");
      List<Integer> linkList = new LinkedList<>();
      aTimer.start();
      for (int i = 0; i < n; i++) {
        linkList.add(0,i);
      }
      aTimer.stop();
      System.out.println(aTimer.getTimeMillisecond());
      aTimer.reset();

      System.out.println("*****数组计算时间******");
      List<Integer> arrayList = new ArrayList<>();
      aTimer.start();
      for (int i = 0; i < n; i++) {
        arrayList.add(0,i);
      }
      aTimer.stop();
      System.out.println(aTimer.getTimeMillisecond());
      aTimer.reset();
    }

  }
