package main.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Longbridge PC on 1/10/2018.
 */
public class ActiveAccountRequest {

    @Valid
    @NotNull
    private String RequestUUID;

    @Valid
    @NotNull
    private String foracid;

    public String getRequestUUID() {
        return RequestUUID;
    }

    public void setRequestUUID(String requestUUID) {
        RequestUUID = requestUUID;
    }

    public String getForacid() {
        return foracid;
    }

    public void setForacid(String foracid) {
        this.foracid = foracid;
    }

    @Override
    public String toString() {
        return "ActiveAccountRequest{" +
                "RequestUUID='" + RequestUUID + '\'' +
                ", foracid='" + foracid + '\'' +
                '}';
    }
}
