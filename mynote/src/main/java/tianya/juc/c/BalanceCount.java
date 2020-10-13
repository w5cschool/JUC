package main.java.tianya.juc.c;

/**
 * @author tianyaliaowang
 * @date 2020/10/13 - 11:48
 *
 * 模拟两个方法，一个加锁一个不加锁
 * 加锁的方法和不加锁的方法是可以同时运行的
 */
public class BalanceCount{

    private int count;
    private String name;

    public synchronized void set(String name,int count) throws InterruptedException {
        System.out.println("set获得了锁");
        Thread.sleep(10);
        this.name = name;
        this.count = count;
    }

    public /*synchronized*/ int getCount() throws InterruptedException {
        //System.out.println("get获得了锁");
        return this.count;
    }

    public static void main(String[] args) throws InterruptedException {
        BalanceCount balanceCount = new BalanceCount();

        new Thread(()-> {
            try {
                balanceCount.set("xiao",100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1);//让set先抢到锁


        System.out.println(balanceCount.getCount());//


        Thread.sleep(2000);
        System.out.println(balanceCount.getCount());


    }
}
