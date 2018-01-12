package main;

import main.AcctinqResp.Body;

/**
 * Created by Longbridge PC on 1/10/2018.
 */
public class AcctInqResponse {
    private String responseMessage;
    private String respcode;
    private String activeCustomer;
    private Body acctinqRespProd;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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

    public String getActiveCustomer() {
        return activeCustomer;
    }

    public void setActiveCustomer(String activeCustomer) {
        this.activeCustomer = activeCustomer;
    }

    public Body getAcctinqRespProd() {
        return acctinqRespProd;
    }

    public void setAcctinqRespProd(Body acctinqRespProd) {
        this.acctinqRespProd = acctinqRespProd;
    }

    @Override
    public String toString() {
        return "AcctInqResponse{" +
                "responseMessage='" + responseMessage + '\'' +
                ", respcode='" + respcode + '\'' +
                ", activeCustomer='" + activeCustomer + '\'' +
                ", acctinqRespProd=" + acctinqRespProd +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
