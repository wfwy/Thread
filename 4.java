/*
        *Runnable接口
        *输出结果
               *窗口2售票机第6号     窗口1售票机第5号       窗口2售票机第4号
                窗口1售票机第3号     窗口3售票机第2号       窗口2售票机第1号
        *多线程访问统一资源，避免Java单继承性的局限
 */
class Threads implements Runnable{
    private int tickets=6;
    public void run(){
        while (true){
            if (tickets>0)
                System.out.println(Thread.currentThread().getName()+"售票机第"+tickets--+"号");//Thread.currentThread()
                                                                                               //返回当前正在运行的线程对象
            else
                System.exit(0);
        }
    }
}

public class Test{
    public static void main(String[] args){
        Threads t=new Threads();
        Thread t1=new Thread(t,"窗口1");
        Thread t2=new Thread(t,"窗口2");
        Thread t3=new Thread(t,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

