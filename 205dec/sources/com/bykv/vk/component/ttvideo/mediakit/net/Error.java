package com.bykv.vk.component.ttvideo.mediakit.net;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class Error {
    int code;
    public String errStr;
    public String host;
    public String id;

    public Error(int i4, String str, String str2) {
        this.code = i4;
        this.host = str;
        this.id = str2;
        this.errStr = null;
    }

    public Error(int i4, String str, String str2, String str3) {
        this.code = i4;
        this.host = str;
        this.id = str2;
        this.errStr = str3;
    }
}
