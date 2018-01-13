package main.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CustomerBalancesRequest {

    @Valid
    @NotNull
    private String RequestUUID;
    @Valid
    @NotNull
    private String cust_id;

    public CustomerBalancesRequest() {
    }

    @Override
    public String toString() {
        return "CustomerBalancesRequest{" +
                "RequestUUID='" + RequestUUID + '\'' +
                ", cust_id='" + cust_id + '\'' +
                '}';
    }

    public String getRequestUUID() {
        return RequestUUID;
    }

    public void setRequestUUID(String requestUUID) {
        RequestUUID = requestUUID;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }
}
