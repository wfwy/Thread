class Mythread implements Runnable{
    private String who;
    public Mythread(String str){
        who=str;
    }
    public void run(){
        for (int i=0;i<5;i++){
            try {
                Thread.sleep((int)(1000*Math.random()));
            }catch(InterruptedException e){
                System.out.println(e.toString());
            }
            System.out.println(who+"正在运行！！！！");
        }
    }
}
public class Test {
    public static void main(String[] args){
        Mythread you=new Mythread("1111");
        Mythread she=new Mythread("2222");
        Thread t1=new Thread(you);
        Thread t2=new Thread(she);
        t1.start();
        try {
            t1.join();
        }
        catch (InterruptedException e){}
        t2.start();
        try {
            t2.join();
        }
        catch (InterruptedException e){}
        System.out.println("13213");
    }
}