class Mythread extends Thread{
    private String who;
    public Mythread(String str){
        who=str;
    }
    public void run(){
        for (int i=0;i<5;i++){
            try {
                Thread.sleep((int)(1000*Math.random()));  //睡眠时间0-1秒，Math.random()产生0-1的浮点随机数。
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
        you.start();
        she.start();
        System.out.println("13213");
    }
}