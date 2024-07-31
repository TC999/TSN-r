package com.tsn.chat.model;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RequestMessage {
    private byte controlType;
    private String datas;
    private byte header;
    private int length;

    public RequestMessage() {
    }

    public byte getControlType() {
        return this.controlType;
    }

    public String getDatas() {
        return this.datas;
    }

    public byte getHeader() {
        return this.header;
    }

    public int getLength() {
        return this.length;
    }

    public void setControlType(byte b) {
        this.controlType = b;
    }

    public void setDatas(String str) {
        this.datas = str;
    }

    public void setHeader(byte b) {
        this.header = b;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public String toString() {
        return "RequestMessage [header=" + ((int) this.header) + ", length=" + this.length + ", controlType=" + ((int) this.controlType) + ", datas=" + this.datas + "]";
    }

    public RequestMessage(int i, byte b, String str) {
        this.header = (byte) -2;
        this.length = i;
        this.controlType = b;
        this.datas = str;
    }
}
