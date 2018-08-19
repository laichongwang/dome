
import java.util.concurrent.*;

public class ThreadPoolUtil  {

    public static void main(String[] agr) {
        createThreadFacatroy();
        //runThreadPoolExecutor();
    }

    public static void runThreadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        for(int i=0; i<20; i++) {
            ThreadRun threadRun = new ThreadRun(i);
            executor.submit(threadRun);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行完的任务数目："+executor.getCompletedTaskCount());
        }
        // executor.shutdownNow();
    }

    public static void createThreadFacatroy() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0; i<20; i++) {
            ThreadRun2 threadRun = new ThreadRun2(i);
            Future<String> result = executor.submit(threadRun);
            if(result.isDone()){
                System.out.println("======>已经完成<=======");
            }
        }
        // executor.shutdown();
    }

    static class ThreadRun2 implements Callable<String> {
        private int num;
        public ThreadRun2(int num){
            this.num = num;
        }
        public String call() {
            System.out.println("ThreadRun2这是第"+num + "个线程任务");
            return "ok";
        }
    }

    static class ThreadRun implements Runnable {
        private int nowNum = 0;
        public ThreadRun(int nowNum) {
            this.nowNum = nowNum;
        }
        public void run() {
            System.out.println("这是第"+nowNum + "个线程任务");
        }
    }



}
