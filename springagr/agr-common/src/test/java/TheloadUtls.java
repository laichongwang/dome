public class TheloadUtls extends Thread {

    public void run(){

        try{
            for(int i=0;i<100;i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
