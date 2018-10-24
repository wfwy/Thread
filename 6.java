/*
            *线程之间的通信
            *wait(),
            * notify(),
            * notifyAll(),
 */

class tickets {
    protected int size;         //总票数
    int number = 0;                //票号
    boolean available = false;   //判断当前是否有票可售

    public tickets(int size) {    //传参
        this.size = size;
    }
    public synchronized void put() {    //同步方法，实现存票功能
        if (available) {
            try {
                wait();                    //如果还有存票代售，则存票线程等待
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        System.out.println("存入第【" + (++number) + "】号票！");
        available = true;
        notify();                           //存票后唤醒售票线程

    }

    public synchronized void sell() {   //同步方法，实现售票
        if (!available) {
            try {
                wait();                     //如果没有存票，则售票线程等待
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        System.out.println("售出第【" + (number) + "】号票！");
        available = false;
        notify();                           //售票后唤醒存票线程
        if (number == size) number = size + 1;  //在售完最后一张票后，设置一个结束标志
    }
}
class producer extends Thread{              //存票类线程
    tickets t=null;
    public producer(tickets t){             //构造方法，是两个线程共享票类对象
        this.t=t;
    }
    public void run(){
        while (t.number<t.size)
            t.put();
    }
}
class Consumer extends Thread{               //售票类线程
    tickets t=null;
    public Consumer(tickets t){
        this.t=t;
    }
    public void run(){
        while (t.number<=t.size)
            t.sell();
    }
}


public class Test{
    public static void main(String[] args){
        tickets t=new tickets(10);         //新建票类对象，总票数为参数
        new producer(t).start();                //以t为参数，创建存票类线程对象，并启动
        new Consumer(t).start();                //创建取票类对象，并启动
    }
}
