//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package main.fi;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.InputStream;
import java.io.StringWriter;
import java.security.KeyStore;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

public class Threader implements Runnable {
//    private int numOfThread;
    private int numOfThread;
    private int threadId;
    private int fetchRange;
    private String eodType;
    private boolean running = false;
    private String resultMsg;
    private VelocityEngine ve;
    private Template t;
    private VelocityContext context;
    private String fiUrl;

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Threader(int threadID,int numOfThread,String eodType,int fetchRange ) {
        this.running = true;
        this.numOfThread = numOfThread;
        this.fetchRange = fetchRange;
        this.eodType = eodType;
        threadId = threadID;
        Properties props = new Properties();
        fiUrl = new FI().getPropertyFromFile("FI.URL");
        props.put("resource.loader", "class");
        props.put("runtime.log.logsystem.class","org.apache.velocity.runtime.log.NullLogSystem");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        this.ve = new VelocityEngine();
        this.ve.init(props);
        this.context = new VelocityContext();
    }

    public void run() {
        int cnt = threadId ;
        int threadController = 0;
        System.out.println("threadid is : "+threadId+" whiile cnt is "+cnt);
        System.out.println("number of thread  is : "+ numOfThread);

       System.out.println("*******************INITIATING LIEN UPDATE FOR  Thread  {} ****Starts at {}******************");
        //this.context.put("numOfThread", this.numOfThread);
        String requestId = "Req_" + RandomStringUtils.randomNumeric(13);
        this.context.put("RequestUUID", requestId);
        this.context.put("threadId",threadId);
        this.context.put("numOfThread", numOfThread);
        this.context.put("fetchRange",fetchRange);
        StringWriter writer = new StringWriter();
        if(eodType.toUpperCase().equals("ACCRUAL")){
            this.t = this.ve.getTemplate("FI-XML/accrualEOD.vm");
        }else if(eodType.toUpperCase().equals("REPAYMENT")){
            this.t = this.ve.getTemplate("FI-XML/repaymentEOD.vm");
        }

        if(this.t != null) {
            this.t.merge(this.context, writer);
        }
        System.out.println("Request is "+writer.toString());
        String responseMsg;
        try {
            while(threadController<=5){
                System.out.println("in while loop for the "+threadController+" time for thraed "+threadId);
                responseMsg = this.callService(writer.toString());
                this.resultMsg = StringUtils.substringBetween(responseMsg, "<RESULT_MSG>", "</RESULT_MSG>");
                boolean isSuccessful = responseMsg.contains("<Status>SUCCESS</Status>");
                String status;
                String resp;
                String err;
                if(isSuccessful) {
                    break;
                } else {
                    String errorCode = StringUtils.substringBetween(responseMsg, "<ErrorCode>", "</ErrorCode>");
                    String errorDesc = StringUtils.substringBetween(responseMsg, "<ErrorDesc>", "</ErrorDesc>");
                    String errorSource = StringUtils.substringBetween(responseMsg, "<ErrorSource>", "</ErrorSource>");
                    String errorType = StringUtils.substringBetween(responseMsg, "<ErrorType>", "</ErrorType>");
                    String errorMessage = StringUtils.replaceEach("RequestUUID: " + responseMsg + " | ErrorCode: " + errorCode + " | ErrorDesc: " + errorDesc + " | ErrorSource: " + errorSource + " | ErrorType: " + errorType, new String[]{"\n", "\t", "\r"}, new String[]{" ", " ", " "});
                    if(!errorDesc.contains("Finacle System Error Occoured")&&
                            !errorDesc.contains("Service Not Available")){
                        break;
                    }
                    System.out.println("Retrying for thread  "+threadId);
                    Thread.sleep(5000);
                }
                threadController++;
            }

        } catch (Exception var12x) {
            var12x.printStackTrace();
            this.running = false;
            return;
        }

        this.running = false;

    }

    private String callService(String payload) {
       System.out.println("**************************Initiating FI Call for Thread {} starts at {} with Request{}********************"+new Timestamp(new Date().getTime()));
        String respMessage = "";

        try {
            KeyStore var12 = KeyStore.getInstance(KeyStore.getDefaultType());
            var12.load((InputStream) null, (char[]) null);
            MySSLSocketFactory sf = new MySSLSocketFactory(var12);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams params = new BasicHttpParams();
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));
            ThreadSafeClientConnManager ccm = new ThreadSafeClientConnManager(params, registry);
            DefaultHttpClient httpClient = new DefaultHttpClient(ccm, params);
            ByteArrayEntity httpEntity = new ByteArrayEntity(payload.getBytes("UTF-8"));
            HttpPost httpPost = new HttpPost(this.fiUrl);
            httpPost.addHeader("SOAPAction", "");
            httpPost.setEntity(httpEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            respMessage = EntityUtils.toString(response.getEntity());
            if (respMessage != null && respMessage.length() > 0) {
                respMessage = respMessage.replace("&lt;", "<").replace("&gt;", ">");
            }
            System.out.println(respMessage);
            System.out.println("Succesfully went");
        } catch (Exception exception) {
            System.out.println("Problem occurred in reaching java.com.mycompany.mainpkage.fi {"+exception+"}");
            respMessage =  exception.toString();
        }

       System.out.println("**************************Initiating FI Call for Thread {} ends at {} with Response {} ********************"+new Timestamp(new Date().getTime()));
    return respMessage;
    }
}
