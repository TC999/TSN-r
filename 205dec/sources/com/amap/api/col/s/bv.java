package com.amap.api.col.s;

import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapCoreException.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class bv extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f9649a;

    /* renamed from: b  reason: collision with root package name */
    private String f9650b;

    /* renamed from: c  reason: collision with root package name */
    private String f9651c;

    /* renamed from: d  reason: collision with root package name */
    private String f9652d;

    /* renamed from: e  reason: collision with root package name */
    private String f9653e;

    /* renamed from: f  reason: collision with root package name */
    private int f9654f;

    /* renamed from: g  reason: collision with root package name */
    private int f9655g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f9656h;

    /* renamed from: i  reason: collision with root package name */
    private String f9657i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, List<String>> f9658j;

    public bv(String str) {
        super(str);
        this.f9649a = "\u672a\u77e5\u7684\u9519\u8bef";
        this.f9650b = "";
        this.f9651c = "";
        this.f9652d = "1900";
        this.f9653e = "UnknownError";
        this.f9654f = -1;
        this.f9655g = -1;
        this.f9656h = false;
        this.f9649a = str;
        if ("IO \u64cd\u4f5c\u5f02\u5e38 - IOException".equals(str)) {
            this.f9654f = 21;
            this.f9652d = "1902";
            this.f9653e = "IOException";
        } else if ("socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(str)) {
            this.f9654f = 22;
        } else if ("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException".equals(str)) {
            this.f9654f = 23;
            this.f9652d = "1802";
            this.f9653e = "SocketTimeoutException";
        } else if ("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException".equals(str)) {
            this.f9654f = 24;
            this.f9652d = "1901";
            this.f9653e = "IllegalArgumentException";
        } else if ("\u7a7a\u6307\u9488\u5f02\u5e38 - NullPointException".equals(str)) {
            this.f9654f = 25;
            this.f9652d = "1903";
            this.f9653e = "NullPointException";
        } else if ("url\u5f02\u5e38 - MalformedURLException".equals(str)) {
            this.f9654f = 26;
            this.f9652d = "1803";
            this.f9653e = "MalformedURLException";
        } else if ("\u672a\u77e5\u4e3b\u673a - UnKnowHostException".equals(str)) {
            this.f9654f = 27;
            this.f9652d = "1804";
            this.f9653e = "UnknownHostException";
        } else if ("\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException".equals(str)) {
            this.f9654f = 28;
            this.f9652d = "1805";
            this.f9653e = "CannotConnectToHostException";
        } else if ("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException".equals(str)) {
            this.f9654f = 29;
            this.f9652d = "1801";
            this.f9653e = "ProtocolException";
        } else if ("http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(str)) {
            this.f9654f = 30;
            this.f9652d = "1806";
            this.f9653e = "ConnectionException";
        } else if ("\u670d\u52a1QPS\u8d85\u9650".equalsIgnoreCase(str)) {
            this.f9654f = 30;
            this.f9652d = "2001";
            this.f9653e = "ConnectionException";
        } else if ("\u672a\u77e5\u7684\u9519\u8bef".equals(str)) {
            this.f9654f = 31;
        } else if ("key\u9274\u6743\u5931\u8d25".equals(str)) {
            this.f9654f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f9654f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f9654f = 2;
        } else if ("response is null".equals(str)) {
            this.f9654f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f9654f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f9654f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f9654f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f9654f = 7;
        } else if ("\u7ebf\u7a0b\u6c60\u4e3a\u7a7a".equals(str)) {
            this.f9654f = 8;
        } else if ("\u83b7\u53d6\u5bf9\u8c61\u9519\u8bef".equals(str)) {
            this.f9654f = 101;
        } else if ("DNS\u89e3\u6790\u5931\u8d25".equals(str)) {
            this.f9654f = 3;
        } else {
            this.f9654f = -1;
        }
        if ("IO \u64cd\u4f5c\u5f02\u5e38 - IOException".equals(str)) {
            this.f9655g = 7;
        } else if ("socket \u8fde\u63a5\u5f02\u5e38 - SocketException".equals(str)) {
            this.f9655g = 6;
        } else if ("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException".equals(str)) {
            this.f9655g = 2;
        } else {
            if (!"\u672a\u77e5\u4e3b\u673a - UnKnowHostException".equals(str)) {
                if ("http\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(str)) {
                    this.f9655g = 6;
                    return;
                } else if (!"\u672a\u77e5\u7684\u9519\u8bef".equals(str) && "DNS\u89e3\u6790\u5931\u8d25".equals(str)) {
                    this.f9655g = 3;
                    return;
                }
            }
            this.f9655g = 9;
        }
    }

    public final String a() {
        return this.f9649a;
    }

    public final String b() {
        return this.f9652d;
    }

    public final String c() {
        return this.f9653e;
    }

    public final String d() {
        return this.f9650b;
    }

    public final String e() {
        return this.f9651c;
    }

    public final int f() {
        return this.f9654f;
    }

    public final int g() {
        return this.f9655g;
    }

    public final int h() {
        this.f9655g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f9656h;
    }

    public final void j() {
        this.f9656h = true;
    }

    public final void a(String str) {
        this.f9657i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.f9658j = map;
    }

    public bv(String str, String str2, String str3) {
        this(str);
        this.f9650b = str2;
        this.f9651c = str3;
    }
}
