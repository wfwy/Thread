/*
        *多线程同步控制
        *synchronized 限定同步方法
        
 */

class Customer extends Thread{
    private static int sum=2000;
    public synchronized static void take(int k){    //synchronized 限定take()为同步方法
        int temp=sum;
        temp-=k;
        sum=temp;
        System.out.println("余额："+sum);
    }
    public void  run() {
        for (int i = 1; i <= 4; i++) {
            try {
                Thread.sleep((int) (1000 * Math.random()));
            } catch (InterruptedException e) {
            }
            Customer.take(100);
        }
    }

}
public class Test{
    public static void main(String[] args) {
        Customer c1=new Customer();
        Customer c2=new Customer();
        c1.start();
        c2.start();
    }
}