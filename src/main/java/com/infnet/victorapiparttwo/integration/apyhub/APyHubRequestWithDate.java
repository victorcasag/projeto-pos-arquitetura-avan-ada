package com.infnet.victorapiparttwo.integration.apyhub;

public class APyHubRequestWithDate {
    private String date;
    private String source;
    private String target;

    public APyHubRequestWithDate() {}

    public APyHubRequestWithDate(String source, String target, String date) {
        this.source = source;
        this.target = target;
        this.date = date;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getTarget() { return target; }
    public void setTarget(String target) { this.target = target; }
}
