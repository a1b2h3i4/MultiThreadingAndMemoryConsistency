class EnhancedImpl {
    public static void main(String[] args) {
        Runnable runnable1=new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                    try{Thread.sleep(100);}catch(Exception ex){}
                    System.out.println(i+"----"+Thread.currentThread().getName());
                }
            }
        };
        Runnable runnable2=new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                    try{Thread.sleep(100);}catch(Exception ex){}
                    System.out.println(i+"----"+Thread.currentThread().getName());
                }
            }
        };
        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable2);
        thread1.start();
        try{thread1.join();}catch(Exception ex){}
        thread2.start();
    }
}