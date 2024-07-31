package com.tsn.chat.model;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ResponseMessage {
    private byte controlType;
    private String datas;

    public ResponseMessage(byte b, String str) {
        this.controlType = b;
        this.datas = str;
    }

    public byte getControlType() {
        return this.controlType;
    }

    public String getDatas() {
        return this.datas;
    }

    public void setControlType(byte b) {
        this.controlType = b;
    }

    public void setDatas(String str) {
        this.datas = str;
    }

    public String toString() {
        return "ResponseMessage [controlType=" + ((int) this.controlType) + ", datas=" + this.datas + "]";
    }
}
