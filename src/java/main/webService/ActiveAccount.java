package main.webService;

import main.AcctInqResponse;
import main.fi.FI;
import main.fi.FIResponse;
import main.fi.Helper;
import main.request.ActiveAccountRequest;
import org.slf4j.*;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Longbridge PC on 1/10/2018.
 */
@WebService
public class ActiveAccount {
    @Resource
    WebServiceContext webServiceContext;

    private Logger logger = LoggerFactory.getLogger(ActiveAccount.class);

    @WebMethod
    public AcctInqResponse activeAccountResponse(@WebParam(
            name = "EnquiryDetails"
    ) ActiveAccountRequest activeAccountRequest){
//        MessageContext mc = this.webServiceContext.getMessageContext();
//        HttpServletRequest req = (HttpServletRequest) mc.get("javax.xml.ws.servlet.");
//        String ipAddress = req.getRemoteAddr();
        this.logger.info("Account com.mycompany.mainpkage.request details is {}", activeAccountRequest.toString());
        AcctInqResponse activeAccountResponse = null;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set constraintViolations = validator.validate(activeAccountRequest);
        Iterator constraintViolationIterator = constraintViolations.iterator();

//        if (constraintViolationIterator.hasNext()){
//            ConstraintViolation Process = (ConstraintViolation) constraintViolationIterator.next();
//            this.logger.info("Const Violation on  {}", Process.getPropertyPath());
//            String errorMessage = Process.getPropertyPath() + " " + Process.getMessage();
//            activeAccountResponse = new ActiveAccountResponse(errorMessage,"96");
//            return activeAccountResponse;
//        }
        String status ="FAILED";

//        String isSysApproved = Helper.isSystemApproved(ipAddress);
//        if(isSysApproved.equals("Y"))
//        {
            activeAccountResponse = new FI().fiAccountInquiry(activeAccountRequest);
                if(activeAccountResponse.getRespcode().equals("00")){
                    status = "SUCCESS";
                    String activeAcctStatus = new FI().activeAccountFIResp(activeAccountRequest.getForacid());
                    activeAccountResponse.setActiveCustomer(activeAcctStatus);
                    return activeAccountResponse;
                }else{
                    activeAccountResponse.setErrorMessage("Fatal Error Occurred: "+activeAccountResponse.getErrorMessage());
                    return activeAccountResponse;
                }
//        }
//        else if(isSysApproved.equals("N")){
//            activeAccountResponse.setErrorMessage("Error Occurred");
//            return activeAccountResponse;
//        }else{
//            activeAccountResponse.setErrorMessage("An Error Occurred");
//            return activeAccountResponse;
//        }
    }
}
