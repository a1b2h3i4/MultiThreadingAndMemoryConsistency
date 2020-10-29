public class BasicImpl extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        BasicImpl basicImpl1=new BasicImpl();
        BasicImpl basicImpl2=new BasicImpl();
        basicImpl1.start();
        try{basicImpl1.join();}catch(Exception ex){}
        basicImpl2.start();
}   
}