package main.fi;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by LB-PRJ-020 on 10/2/2017.
 */
public class TestCase implements Runnable {

    private int numOfThread;
    private String oprtnType;
    private String eodType;
    private int fetchRange;
    private int threadID;

    public TestCase(int numOfThread,String eodType, String oprtnType, int fetchRange) {
        this.numOfThread = numOfThread;
        this.oprtnType = oprtnType;
        this.fetchRange = fetchRange;
        this.eodType = eodType;
    }

    public TestCase(int numOfThread,String eodType, String oprtnType,int fetchRange,int threadID) {
        this.numOfThread = numOfThread;
        this.oprtnType = oprtnType;
        this.fetchRange = fetchRange;
        this.eodType = eodType;
        this.threadID = threadID;
    }

    public void run() {
        System.out.println("Batch Process stats at: " + new Timestamp(new Date().getTime()));
        Threader mt;
        Thread t;
        int counetr = 0;
        if(oprtnType.equals("MULTI")){
            while(counetr<= numOfThread){//+1 (i.e <=) was allowed to handle any cases of extra recordse.g instead of 50 threads would have 51
                mt = new Threader(counetr++, numOfThread,eodType,fetchRange);
                t = new Thread(mt);
                t.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(oprtnType.equals("SINGLE")){
                mt = new Threader(threadID, numOfThread,eodType,fetchRange);
                t = new Thread(mt);
                t.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Batch Process ends at: " + new Timestamp(new Date().getTime()));
    }
}
