package com.bytedance.msdk.f.c;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private String f28308c;
    private String sr;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private String f28309w;
    private String xv;

    public void c(String str) {
        this.f28308c = str;
    }

    public void sr(String str) {
        this.sr = str;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.f28308c + "', adnRit='" + this.f28309w + "', adnName='" + this.xv + "', adAction='" + this.sr + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.ux)) + '}';
    }

    public void w(String str) {
        this.f28309w = str;
    }

    public void xv(String str) {
        this.xv = str;
    }

    public String c() {
        return this.sr;
    }

    public void c(long j4) {
        this.ux = j4;
    }
}
