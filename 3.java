class Threads extends Thread{
    private int tickets=6;
    public void run(){
        while (true){
            if (tickets>0)
                System.out.println(getName()+"售票机第"+tickets--+"号");
            else
                System.exit(0);
        }
    }
}
public class Test{
    public static void main(String[] args){
        Threads t1=new Threads();
        Threads t2=new Threads();
        Threads t3=new Threads();
        t1.start();
        t2.start();
        t3.start();
    }
}