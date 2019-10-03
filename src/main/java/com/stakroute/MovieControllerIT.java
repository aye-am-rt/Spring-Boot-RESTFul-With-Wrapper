package com.stakroute;

public class MovieControllerIT {

    private int v;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public MovieControllerIT() {
        setMsg("Hii this is constructor of Movie ControllerIT setting the msg field");
    }
}
