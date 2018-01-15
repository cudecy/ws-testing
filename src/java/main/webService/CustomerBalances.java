package main.webService;
import main.CustomerBalancesInquiryResponse;
import main.fi.FI;
import main.request.CustomerBalancesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.ws.WebServiceContext;
import java.util.Set;

@WebService()
public class CustomerBalances {
  WebServiceContext webServiceContext;
  private Logger logger = LoggerFactory.getLogger(CustomerBalances.class);

    public CustomerBalancesInquiryResponse customerBalanceResponse(@WebParam(
            name = "EnquiryDetails"
    )CustomerBalancesRequest customerBalancesRequest){
        this.logger.info("Customer balances request details - {}", customerBalancesRequest.toString());
        CustomerBalancesInquiryResponse customerBalanceResponse = null;
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//        Set constraintViolations = validator.validate(customerBalancesRequest);
//
//        String status = "FAILED";

        customerBalanceResponse = new FI().fiCustomerBalancesInquiry(customerBalancesRequest);
        if(customerBalanceResponse.getRespcode().equals("00")){
//            status = "SUCCESS";
//            String accountBalances = new FI().customerBalancesFIResp(customerBalancesRequest.getCust_id());
//            customerBalanceResponse.setCustomerBalances(accountBalances);
            return customerBalanceResponse;
        }else {
            customerBalanceResponse.setErrorMessage("Fatal Error Occurred: "+customerBalanceResponse.getErrorMessage());
            return customerBalanceResponse;
        }
    }


}
