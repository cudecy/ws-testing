package main;

import main.AcctBalsByCIFResp.CustBalResponse;

public class CustomerBalancesInquiryResponse {
    private String responseMessage;
    private String respcode;
    private String customerBalances;
    private CustBalResponse customerBalancesInquiryResponse;
    private String errorMessage;

    public CustomerBalancesInquiryResponse() {
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode;
    }

    public String getCustomerBalances() {
        return customerBalances;
    }

    public void setCustomerBalances(String customerBalances) {
        this.customerBalances = customerBalances;
    }

    public CustBalResponse getCustomerBalancesInquiryResponse() {
        return customerBalancesInquiryResponse;
    }

    public void setCustomerBalancesInquiryResponse(CustBalResponse customerBalancesInquiryResponse) {
        this.customerBalancesInquiryResponse = customerBalancesInquiryResponse;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
