package entity;

/**
 * Created by Lembre on 2018.5.8
 */
public class User {

    private String sessionIdString;
    private String ipString;
    private String firstTimeString;

    public String getSessionIdString() {
        return sessionIdString;
    }

    public void setSessionIdString(String sessionIdString) {
        this.sessionIdString = sessionIdString;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getFirstTimeString() {
        return firstTimeString;
    }

    public void setFirstTimeString(String firstTimeString) {
        this.firstTimeString = firstTimeString;
    }
}
