package com.tsn.chat.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    public void setControlType(byte b4) {
        this.controlType = b4;
    }

    public void setDatas(String str) {
        this.datas = str;
    }

    public void setHeader(byte b4) {
        this.header = b4;
    }

    public void setLength(int i4) {
        this.length = i4;
    }

    public String toString() {
        return "RequestMessage [header=" + ((int) this.header) + ", length=" + this.length + ", controlType=" + ((int) this.controlType) + ", datas=" + this.datas + "]";
    }

    public RequestMessage(int i4, byte b4, String str) {
        this.header = (byte) -2;
        this.length = i4;
        this.controlType = b4;
        this.datas = str;
    }
}
