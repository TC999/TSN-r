package com.amap.api.col.p047s;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* compiled from: AMapCoreException.java */
/* renamed from: com.amap.api.col.s.bv */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2022bv extends Exception {

    /* renamed from: a */
    private String f5899a;

    /* renamed from: b */
    private String f5900b;

    /* renamed from: c */
    private String f5901c;

    /* renamed from: d */
    private String f5902d;

    /* renamed from: e */
    private String f5903e;

    /* renamed from: f */
    private int f5904f;

    /* renamed from: g */
    private int f5905g;

    /* renamed from: h */
    private volatile boolean f5906h;

    /* renamed from: i */
    private String f5907i;

    /* renamed from: j */
    private Map<String, List<String>> f5908j;

    public C2022bv(String str) {
        super(str);
        this.f5899a = AMapException.ERROR_UNKNOWN;
        this.f5900b = "";
        this.f5901c = "";
        this.f5902d = "1900";
        this.f5903e = "UnknownError";
        this.f5904f = -1;
        this.f5905g = -1;
        this.f5906h = false;
        this.f5899a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f5904f = 21;
            this.f5902d = "1902";
            this.f5903e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f5904f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f5904f = 23;
            this.f5902d = "1802";
            this.f5903e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f5904f = 24;
            this.f5902d = "1901";
            this.f5903e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f5904f = 25;
            this.f5902d = "1903";
            this.f5903e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f5904f = 26;
            this.f5902d = "1803";
            this.f5903e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f5904f = 27;
            this.f5902d = "1804";
            this.f5903e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f5904f = 28;
            this.f5902d = "1805";
            this.f5903e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f5904f = 29;
            this.f5902d = "1801";
            this.f5903e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f5904f = 30;
            this.f5902d = "1806";
            this.f5903e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f5904f = 30;
            this.f5902d = "2001";
            this.f5903e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f5904f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f5904f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f5904f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f5904f = 2;
        } else if ("response is null".equals(str)) {
            this.f5904f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f5904f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f5904f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f5904f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f5904f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f5904f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f5904f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f5904f = 3;
        } else {
            this.f5904f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f5905g = 7;
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f5905g = 6;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f5905g = 2;
        } else {
            if (!"未知主机 - UnKnowHostException".equals(str)) {
                if (AMapException.ERROR_CONNECTION.equals(str)) {
                    this.f5905g = 6;
                    return;
                } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                    this.f5905g = 3;
                    return;
                }
            }
            this.f5905g = 9;
        }
    }

    /* renamed from: a */
    public final String m53217a() {
        return this.f5899a;
    }

    /* renamed from: b */
    public final String m53214b() {
        return this.f5902d;
    }

    /* renamed from: c */
    public final String m53213c() {
        return this.f5903e;
    }

    /* renamed from: d */
    public final String m53212d() {
        return this.f5900b;
    }

    /* renamed from: e */
    public final String m53211e() {
        return this.f5901c;
    }

    /* renamed from: f */
    public final int m53210f() {
        return this.f5904f;
    }

    /* renamed from: g */
    public final int m53209g() {
        return this.f5905g;
    }

    /* renamed from: h */
    public final int m53208h() {
        this.f5905g = 10;
        return 10;
    }

    /* renamed from: i */
    public final boolean m53207i() {
        return this.f5906h;
    }

    /* renamed from: j */
    public final void m53206j() {
        this.f5906h = true;
    }

    /* renamed from: a */
    public final void m53216a(String str) {
        this.f5907i = str;
    }

    /* renamed from: a */
    public final void m53215a(Map<String, List<String>> map) {
        this.f5908j = map;
    }

    public C2022bv(String str, String str2, String str3) {
        this(str);
        this.f5900b = str2;
        this.f5901c = str3;
    }
}
