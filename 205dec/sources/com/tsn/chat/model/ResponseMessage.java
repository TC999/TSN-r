package com.tsn.chat.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ResponseMessage {
    private byte controlType;
    private String datas;

    public ResponseMessage(byte b4, String str) {
        this.controlType = b4;
        this.datas = str;
    }

    public byte getControlType() {
        return this.controlType;
    }

    public String getDatas() {
        return this.datas;
    }

    public void setControlType(byte b4) {
        this.controlType = b4;
    }

    public void setDatas(String str) {
        this.datas = str;
    }

    public String toString() {
        return "ResponseMessage [controlType=" + ((int) this.controlType) + ", datas=" + this.datas + "]";
    }
}
