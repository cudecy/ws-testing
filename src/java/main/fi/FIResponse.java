//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package main.fi;

public class FIResponse {
    private boolean isSuccessful;
    private String response = " ";

    public FIResponse() {
    }

    public FIResponse(boolean isSuccessful, String response) {
        this.isSuccessful = isSuccessful;
        this.response = response;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String toString() {
        return "FIResponse{isSuccessful=" + this.isSuccessful + ", response=\'" + this.response + '\'' + '}';
    }
}
