package main.fi;

import main.AcctBalsByCIFResp.CustBalResponse;
import main.AcctInqResponse;
import main.AcctinqResp.BalInqResponse;
import main.request.ActiveAccountRequest;
import main.request.CustomerBalancesRequest;
import main.CustomerBalancesInquiryResponse;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;


public class FI {
    private final Logger logger = LoggerFactory.getLogger(FI.class);
    private final String FI_SERVICE_URL = this.getPropertyFromFile("FI.URL");
    private VelocityEngine ve;
    private Template t;
    private VelocityContext context;

//    public ActiveAccountResponse activeAccountResp(ActiveAccountRequest activeAccountRequest){
//        Logger Logger = this.logger;
//        VelocityContext vcontext = this.context;
//        Template template = this.t;
//        VelocityEngine velovityEngine = this.ve;
//        StringWriter stringWriter = new StringWriter();
//        Logger.info("Initiating Active Account Inquiry");
////        Logger.info("com.mycompany.mainpkage.request{}", );
//
//        template = velovityEngine.getTemplate("FI-XML/accountInquiry.vm");
//        String requestId = "Req_" + RandomStringUtils.randomNumeric(13);
//        vcontext.put("RequestUUID", requestId);
//        vcontext.put("MessageDateTime", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date())));
//        vcontext.put("foracid", activeAccountRequest.getForacid());
//        template.merge(vcontext,stringWriter);
//        String payload = stringWriter.toString();
//        String responseMsg = this.callService(payload);
//        String charSequence = "<Status>SUCCESS</Status>";
//        boolean isSuccessful = responseMsg.contains(charSequence);
//        ActiveAccountResponse activeAccountResponse = new ActiveAccountResponse();
//        if(isSuccessful){
//            responseMsg =  StringUtils.substringBetween(responseMsg, "<Body>", "</Body>");
//            System.out.println("I got : "+responseMsg);
//            InputStream inputStream = new ByteArrayInputStream(getBytes(responseMsg));
//            JAXBContext jaxbContext = null;
//            try {
//                jaxbContext = JAXBContext.newInstance(ActiveAccountResponse.class);
//                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//                activeAccountResponse = (ActiveAccountResponse) jaxbUnmarshaller.unmarshal(inputStream);
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }
//            if(activeAccountResponse != null){
//                return  activeAccountResponse;
//            }
//        }else {
//            String errorCode = StringUtils.substringBetween(responseMsg, "<ErrorCode>", "</ErrorCode>");
//            String errorDesc = StringUtils.substringBetween(responseMsg, "<ErrorDesc>", "</ErrorDesc>");
//            String errorSource = StringUtils.substringBetween(responseMsg, "<ErrorSource>", "</ErrorSource>");
//            String errorType = StringUtils.substringBetween(responseMsg, "<ErrorType>", "</ErrorType>");
//            String errorMessage = StringUtils.replaceEach("RequestUUID: " + requestId + " | ErrorCode: " + errorCode + " | ErrorDesc: " + errorDesc + " | ErrorSource: " + errorSource + " | ErrorType: " + errorType, new String[]{"\n", "\t", "\r"}, new String[]{" ", " ", " "});
//            Logger.error("******************** FI encountered error. Error Description {} ********************", errorMessage);
//            activeAccountResponse.setErrorMessage(errorMessage);
//            activeAccountResponse.setRespCode("96");
//            activeAccountResponse.setRequestUUID(activeAccountRequest.getRequestUUID());
//        }
//        Logger.info("Active Account Inquiry Procedure Complete");
//        return activeAccountResponse;
//    }


    public FI() {
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("runtime.log.logsystem.class","org.apache.velocity.runtime.log.NullLogSystem");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        this.ve = new VelocityEngine();
        this.ve.init(props);
        this.context = new VelocityContext();
    }


    public CustomerBalancesInquiryResponse fiCustomerBalancesInquiry(CustomerBalancesRequest customerBalancesRequest){
        this.logger.info("**************************************** BEGIN PAYMENT PROCESS ****************************************");
        System.out.println("**************************************** BEGIN PAYMENT PROCESS ****************************************");
        CustomerBalancesInquiryResponse response = new CustomerBalancesInquiryResponse();
        CustBalResponse respBody = new CustBalResponse();
        CustBalResponse.Accountbalance respAcctBal = new CustBalResponse.Accountbalance();
        CustBalResponse custBalInqResponse = new CustBalResponse();
        StringWriter writer = new StringWriter();
//        Date startDate = new Date();
        FIResponse fiResponse = new FIResponse();
        String requestId = "Req_" + RandomStringUtils.randomNumeric(13);
        System.out.println("Request UIID is: "+requestId);
        this.context.put("RequestUUID", requestId);
        this.context.put("MessageDateTime", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date())));
        this.t = this.ve.getTemplate("/FI_XML/custAcctBal.vm");

        this.context.put("cifId", customerBalancesRequest.getCust_id());

        this.t.merge(this.context, writer);
        String payload11 = writer.toString();
        System.out.println("request is: "+payload11);
        String responseMessage = this.callService(payload11);
        String charSequence1 = "<Status>SUCCESS</Status>";
        boolean isSuccessful = responseMessage.contains(charSequence1);

        if (isSuccessful) {
            responseMessage = StringUtils.substringBetween(responseMessage, "<Body>", "</Body>");
            System.out.println("response is: "+responseMessage);
            InputStream inputStream = new ByteArrayInputStream(getBytes(responseMessage));
            JAXBContext jaxbContext = null;
            try {
                System.out.println("Gotten to context and trying to perform operation now");
                jaxbContext = JAXBContext.newInstance(CustBalResponse.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                custBalInqResponse = (CustBalResponse) jaxbUnmarshaller.unmarshal(inputStream);
                System.out.println("Successfully un-masrshalled");
                List<CustBalResponse.Accountbalance> allAccountBalances = respBody.getAccountbalance();
                if(allAccountBalances.size() > 0){
                    if(allAccountBalances.size() == 1){
                        respAcctBal.setBalance(allAccountBalances.get(0).toString());
                    }else{
                        for(CustBalResponse.Accountbalance a : allAccountBalances){
                            respAcctBal.setBalance(a.toString());
                        }
                    }
                }else{
                    System.out.println("An error has occurred. Maybe no balance was fetched...");
                }
//                respBody.setAccountbalance(custBalInqResponse.getAccountbalance());
                System.out.println("Response body is: "+respBody);
                response.setCustomerBalancesInquiryResponse(respBody);
                response.setRespcode("00");
                System.out.println("Successfully set response");
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            fiResponse.setIsSuccessful(true);
            this.logger.info("**************************************** success ****************************************");
            System.out.println("**************************************** success ****************************************");
        } else {
            String errorCode = StringUtils.substringBetween(responseMessage, "<ErrorCode>", "</ErrorCode>");
            String errorDesc = StringUtils.substringBetween(responseMessage, "<ErrorDesc>", "</ErrorDesc>");
            String errorSource = StringUtils.substringBetween(responseMessage, "<ErrorSource>", "</ErrorSource>");
            String errorType = StringUtils.substringBetween(responseMessage, "<ErrorType>", "</ErrorType>");
            String errorMessage = StringUtils.replaceEach("RequestUUID: " + requestId + " | ErrorCode: " + errorCode + " | ErrorDesc: " + errorDesc + " | ErrorSource: " + errorSource + " | ErrorType: " + errorType, new String[]{"\n", "\t", "\r"}, new String[]{" ", " ", " "});
            this.logger.error("****** FI encountered error. Error Description {} *****", errorMessage);
            System.out.println("****** FI encountered error. Error Description {} *****"+ errorMessage);
            response.setRespcode("96");
            response.setErrorMessage(errorMessage);
        }
        this.logger.info("**************************************** PAYMENT PROCESS  ENDED****************************************");
        System.out.println("**************************************** PAYMENT PROCESS  ENDED****************************************");
        System.out.println("At the end, response is: "+response);
        return response;
    }


    public AcctInqResponse fiAccountInquiry(ActiveAccountRequest activeAccountRequest){
        this.logger.info("**************************************** BEGIN PAYMENT PROCESS ****************************************");
        System.out.println("**************************************** BEGIN PAYMENT PROCESS ****************************************");
        AcctInqResponse response = new AcctInqResponse();
        BalInqResponse respBody = new BalInqResponse();
        BalInqResponse balInqResponse = new BalInqResponse();
        StringWriter writer = new StringWriter();
        Date startDate = new Date();
        FIResponse fiResponse = new FIResponse();
        String requestId = "Req_" + RandomStringUtils.randomNumeric(13);
        System.out.println("Request UIID is: "+requestId);
        this.context.put("RequestUUID", requestId);
        this.context.put("MessageDateTime", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date())));
        this.t = this.ve.getTemplate("/FI_XML/acctInqProd.vm");

        this.context.put("foracid", activeAccountRequest.getForacid());

        this.t.merge(this.context, writer);
        String payload11 = writer.toString();
        System.out.println("request is: "+payload11);
        String responseMessage = this.callService(payload11);
        String charSequence1 = "<Status>SUCCESS</Status>";
        boolean isSuccessful = responseMessage.contains(charSequence1);

        if (isSuccessful) {
            responseMessage = StringUtils.substringBetween(responseMessage, "<Body>", "</Body>");
            System.out.println("response is: "+responseMessage);
            InputStream inputStream = new ByteArrayInputStream(getBytes(responseMessage));
            JAXBContext jaxbContext = null;
            try {
                System.out.println("Gotten to context and trying to perform operation now");
                jaxbContext = JAXBContext.newInstance(BalInqResponse.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                balInqResponse = (BalInqResponse) jaxbUnmarshaller.unmarshal(inputStream);
                System.out.println("Successfully un-masrshalled");
                respBody.setBalInqRs(balInqResponse.getBalInqRs());
                System.out.println("Response body is: "+respBody);
                response.setAcctinqRespProd(respBody);
                response.setRespcode("00");
                System.out.println("Successfully set response");
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            fiResponse.setIsSuccessful(true);
            this.logger.info("**************************************** success ****************************************");
            System.out.println("**************************************** success ****************************************");
        } else {
            String errorCode = StringUtils.substringBetween(responseMessage, "<ErrorCode>", "</ErrorCode>");
            String errorDesc = StringUtils.substringBetween(responseMessage, "<ErrorDesc>", "</ErrorDesc>");
            String errorSource = StringUtils.substringBetween(responseMessage, "<ErrorSource>", "</ErrorSource>");
            String errorType = StringUtils.substringBetween(responseMessage, "<ErrorType>", "</ErrorType>");
            String errorMessage = StringUtils.replaceEach("RequestUUID: " + requestId + " | ErrorCode: " + errorCode + " | ErrorDesc: " + errorDesc + " | ErrorSource: " + errorSource + " | ErrorType: " + errorType, new String[]{"\n", "\t", "\r"}, new String[]{" ", " ", " "});
            this.logger.error("****** FI encountered error. Error Description {} *****", errorMessage);
            System.out.println("****** FI encountered error. Error Description {} *****"+ errorMessage);
            response.setRespcode("96");
            response.setErrorMessage(errorMessage);
        }
        this.logger.info("**************************************** PAYMENT PROCESS  ENDED****************************************");
        System.out.println("**************************************** PAYMENT PROCESS  ENDED****************************************");
        System.out.println("At the end, response is: "+response);
        return response;
    }


    public String customerBalancesFIResp(String custId){
        this.logger.info("**************************************** BEGIN PAYMENT PROCESS ****************************************");
        BalInqResponse response = new BalInqResponse();
        StringWriter writer = new StringWriter();
        Date startDate = new Date();
        String respSring=null;
        FIResponse fiResponse = new FIResponse();
        String requestId = "Req_" + RandomStringUtils.randomNumeric(13);
        this.context.put("RequestUUID", requestId);
        this.context.put("MessageDateTime", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date())));
        this.t = this.ve.getTemplate("/FI_XML/accountInquiry.vm");

        this.context.put("custId", custId);

        this.t.merge(this.context, writer);
        String payload11 = writer.toString();
        String responseMessage = this.callService(payload11);
        String charSequence1 = "<Status>SUCCESS</Status>";
        boolean isSuccessful = responseMessage.contains(charSequence1);

        if (isSuccessful) {
            String resultMssg = StringUtils.substringBetween(responseMessage, "<activeCustomer>", "</activeCustomer>");
            respSring = resultMssg;
            this.logger.info("**************************************** success ****************************************");
        } else {
            String errorCode = StringUtils.substringBetween(responseMessage, "<ErrorCode>", "</ErrorCode>");
            String errorDesc = StringUtils.substringBetween(responseMessage, "<ErrorDesc>", "</ErrorDesc>");
            String errorSource = StringUtils.substringBetween(responseMessage, "<ErrorSource>", "</ErrorSource>");
            String errorType = StringUtils.substringBetween(responseMessage, "<ErrorType>", "</ErrorType>");
            String errorMessage = StringUtils.replaceEach("RequestUUID: " + requestId + " | ErrorCode: " + errorCode + " | ErrorDesc: " + errorDesc + " | ErrorSource: " + errorSource + " | ErrorType: " + errorType, new String[]{"\n", "\t", "\r"}, new String[]{" ", " ", " "});
            this.logger.error("****** FI encountered    error. Error Description {} *****", errorMessage);
            respSring = errorMessage;
        }
        this.logger.info("**************************************** PAYMENT PROCESS  ENDED****************************************");
        return respSring;
    }

    public String activeAccountFIResp(String foracid){
        this.logger.info("**************************************** BEGIN PAYMENT PROCESS ****************************************");
        BalInqResponse response = new BalInqResponse();
        StringWriter writer = new StringWriter();
        Date startDate = new Date();
        String respSring=null;
        FIResponse fiResponse = new FIResponse();
        String requestId = "Req_" + RandomStringUtils.randomNumeric(13);
        this.context.put("RequestUUID", requestId);
        this.context.put("MessageDateTime", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date())));
        this.t = this.ve.getTemplate("/FI_XML/accountInquiry.vm");

        this.context.put("foracid", foracid);

        this.t.merge(this.context, writer);
        String payload11 = writer.toString();
        String responseMessage = this.callService(payload11);
        String charSequence1 = "<Status>SUCCESS</Status>";
        boolean isSuccessful = responseMessage.contains(charSequence1);

        if (isSuccessful) {
            String resultMssg = StringUtils.substringBetween(responseMessage, "<activeCustomer>", "</activeCustomer>");
            respSring = resultMssg;
            this.logger.info("**************************************** success ****************************************");
        } else {
            String errorCode = StringUtils.substringBetween(responseMessage, "<ErrorCode>", "</ErrorCode>");
            String errorDesc = StringUtils.substringBetween(responseMessage, "<ErrorDesc>", "</ErrorDesc>");
            String errorSource = StringUtils.substringBetween(responseMessage, "<ErrorSource>", "</ErrorSource>");
            String errorType = StringUtils.substringBetween(responseMessage, "<ErrorType>", "</ErrorType>");
            String errorMessage = StringUtils.replaceEach("RequestUUID: " + requestId + " | ErrorCode: " + errorCode + " | ErrorDesc: " + errorDesc + " | ErrorSource: " + errorSource + " | ErrorType: " + errorType, new String[]{"\n", "\t", "\r"}, new String[]{" ", " ", " "});
            this.logger.error("****** FI encountered    error. Error Description {} *****", errorMessage);
            respSring = errorMessage;
        }
        this.logger.info("**************************************** PAYMENT PROCESS  ENDED****************************************");
        return respSring;
    }


    public String getPropertyFromFile(String property) {
        Properties prop = new Properties();
        InputStream input = null;
        String value = "";

        try {
            input = this.getClass().getResourceAsStream("/FiUrl.properties");
            prop.load(input);
            value = prop.getProperty(property);
            this.logger.info("Property : {} \t Value : {}", property, value);
        } catch (IOException var14) {
            this.logger.error("Error in reading props file {}", var14.getLocalizedMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException var13) {
                    this.logger.error("error in closing input stream {}", var13.toString());
                }
            }

        }

        return value;
    }

    private String callService(String payload) {
        try {
            this.logger.info("****************************************FI REQUEST**************************************** {}", payload);
            KeyStore var12 = KeyStore.getInstance(KeyStore.getDefaultType());
            var12.load( null,  null);
            MySSLSocketFactory sf = new MySSLSocketFactory(var12);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams params = new BasicHttpParams();
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));
            ThreadSafeClientConnManager ccm = new ThreadSafeClientConnManager(params, registry);
            DefaultHttpClient httpClient = new DefaultHttpClient(ccm, params);
            ByteArrayEntity httpEntity = new ByteArrayEntity(payload.getBytes("UTF-8"));
            HttpPost httpPost = new HttpPost(this.FI_SERVICE_URL);
            httpPost.addHeader("SOAPAction", "");
            httpPost.setEntity(httpEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String responseMessage = EntityUtils.toString(response.getEntity());
            if (responseMessage != null && responseMessage.length() > 0) {
                responseMessage = responseMessage.replace("&lt;", "<").replace("&gt;", ">");
            }

            this.logger.info("****************************************FI RESPONSE**************************************** {}", responseMessage);
            return responseMessage;
        } catch (Exception exception) {
            this.logger.error("Problem occurred in reaching java.com.mycompany.mainpkage.fi {}", exception);
            return "";
        }
    }
}
