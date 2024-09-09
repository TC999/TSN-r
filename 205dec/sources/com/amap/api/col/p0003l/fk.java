package com.amap.api.col.p0003l;

import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AMapCoreException.java */
/* renamed from: com.amap.api.col.3l.fk  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class fk extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f7738a;

    /* renamed from: b  reason: collision with root package name */
    private String f7739b;

    /* renamed from: c  reason: collision with root package name */
    private String f7740c;

    /* renamed from: d  reason: collision with root package name */
    private String f7741d;

    /* renamed from: e  reason: collision with root package name */
    private String f7742e;

    /* renamed from: f  reason: collision with root package name */
    private int f7743f;

    /* renamed from: g  reason: collision with root package name */
    private int f7744g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f7745h;

    /* renamed from: i  reason: collision with root package name */
    private String f7746i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, List<String>> f7747j;

    public fk(String str) {
        super(str);
        this.f7738a = "\u672a\u77e5\u7684\u9519\u8bef";
        this.f7739b = "";
        this.f7740c = "";
        this.f7741d = "1900";
        this.f7742e = "UnknownError";
        this.f7743f = -1;
        this.f7744g = -1;
        this.f7745h = false;
        this.f7738a = str;
        if ("IO \u64cd\u4f5c\u5f02\u5e38 - IOException".equals(str)) {
            this.f7743f = 21;
            this.f7741d = "1902";
            this.f7742e = "IOException";
        } else if ("socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(str)) {
            this.f7743f = 22;
        } else if ("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException".equals(str)) {
            this.f7743f = 23;
            this.f7741d = "1802";
            this.f7742e = "SocketTimeoutException";
        } else if ("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException".equals(str)) {
            this.f7743f = 24;
            this.f7741d = "1901";
            this.f7742e = "IllegalArgumentException";
        } else if ("\u7a7a\u6307\u9488\u5f02\u5e38 - NullPointException".equals(str)) {
            this.f7743f = 25;
            this.f7741d = "1903";
            this.f7742e = "NullPointException";
        } else if ("url\u5f02\u5e38 - MalformedURLException".equals(str)) {
            this.f7743f = 26;
            this.f7741d = "1803";
            this.f7742e = "MalformedURLException";
        } else if ("\u672a\u77e5\u4e3b\u673a - UnKnowHostException".equals(str)) {
            this.f7743f = 27;
            this.f7741d = "1804";
            this.f7742e = "UnknownHostException";
        } else if ("\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException".equals(str)) {
            this.f7743f = 28;
            this.f7741d = "1805";
            this.f7742e = "CannotConnectToHostException";
        } else if ("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException".equals(str)) {
            this.f7743f = 29;
            this.f7741d = "1801";
            this.f7742e = "ProtocolException";
        } else if ("http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(str)) {
            this.f7743f = 30;
            this.f7741d = "1806";
            this.f7742e = "ConnectionException";
        } else if ("\u670d\u52a1QPS\u8d85\u9650".equalsIgnoreCase(str)) {
            this.f7743f = 30;
            this.f7741d = "2001";
            this.f7742e = "ConnectionException";
        } else if ("\u672a\u77e5\u7684\u9519\u8bef".equals(str)) {
            this.f7743f = 31;
        } else if ("key\u9274\u6743\u5931\u8d25".equals(str)) {
            this.f7743f = 32;
        } else if ("\u9650\u5236\u8bbf\u95ee\u7684\u63a5\u53e3".equals(str)) {
            this.f7743f = 33;
        } else if ("requeust is null".equals(str)) {
            this.f7743f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f7743f = 2;
        } else if ("response is null".equals(str)) {
            this.f7743f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f7743f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f7743f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f7743f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f7743f = 7;
        } else if ("\u7ebf\u7a0b\u6c60\u4e3a\u7a7a".equals(str)) {
            this.f7743f = 8;
        } else if ("\u83b7\u53d6\u5bf9\u8c61\u9519\u8bef".equals(str)) {
            this.f7743f = 101;
        } else if ("DNS\u89e3\u6790\u5931\u8d25".equals(str)) {
            this.f7743f = 3;
        } else {
            this.f7743f = -1;
        }
        if ("IO \u64cd\u4f5c\u5f02\u5e38 - IOException".equals(str)) {
            this.f7744g = 7;
        } else if ("socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(str)) {
            this.f7744g = 6;
        } else if ("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException".equals(str)) {
            this.f7744g = 2;
        } else {
            if (!"\u672a\u77e5\u4e3b\u673a - UnKnowHostException".equals(str)) {
                if ("http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(str)) {
                    this.f7744g = 6;
                    return;
                } else if (!"\u672a\u77e5\u7684\u9519\u8bef".equals(str) && "DNS\u89e3\u6790\u5931\u8d25".equals(str)) {
                    this.f7744g = 3;
                    return;
                }
            }
            this.f7744g = 9;
        }
    }

    public final String a() {
        return this.f7738a;
    }

    public final String b() {
        return this.f7741d;
    }

    public final String c() {
        return this.f7742e;
    }

    public final String d() {
        return this.f7739b;
    }

    public final String e() {
        return this.f7740c;
    }

    public final int f() {
        return this.f7743f;
    }

    public final int g() {
        return this.f7744g;
    }

    public final int h() {
        this.f7744g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f7745h;
    }

    public final void j() {
        this.f7745h = true;
    }

    public final void a(int i4) {
        this.f7743f = i4;
    }

    public final void a(String str) {
        this.f7746i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.f7747j = map;
    }

    public fk(String str, String str2, String str3) {
        this(str);
        this.f7739b = str2;
        this.f7740c = str3;
    }
}
