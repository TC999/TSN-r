package com.amap.api.col.p0463l;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.fk */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AMapCoreException extends Exception {

    /* renamed from: a */
    private String f4173a;

    /* renamed from: b */
    private String f4174b;

    /* renamed from: c */
    private String f4175c;

    /* renamed from: d */
    private String f4176d;

    /* renamed from: e */
    private String f4177e;

    /* renamed from: f */
    private int f4178f;

    /* renamed from: g */
    private int f4179g;

    /* renamed from: h */
    private volatile boolean f4180h;

    /* renamed from: i */
    private String f4181i;

    /* renamed from: j */
    private Map<String, List<String>> f4182j;

    public AMapCoreException(String str) {
        super(str);
        this.f4173a = AMapException.ERROR_UNKNOWN;
        this.f4174b = "";
        this.f4175c = "";
        this.f4176d = "1900";
        this.f4177e = "UnknownError";
        this.f4178f = -1;
        this.f4179g = -1;
        this.f4180h = false;
        this.f4173a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f4178f = 21;
            this.f4176d = "1902";
            this.f4177e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f4178f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f4178f = 23;
            this.f4176d = "1802";
            this.f4177e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f4178f = 24;
            this.f4176d = "1901";
            this.f4177e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f4178f = 25;
            this.f4176d = "1903";
            this.f4177e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f4178f = 26;
            this.f4176d = "1803";
            this.f4177e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f4178f = 27;
            this.f4176d = "1804";
            this.f4177e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f4178f = 28;
            this.f4176d = "1805";
            this.f4177e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f4178f = 29;
            this.f4176d = "1801";
            this.f4177e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f4178f = 30;
            this.f4176d = "1806";
            this.f4177e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f4178f = 30;
            this.f4176d = "2001";
            this.f4177e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f4178f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f4178f = 32;
        } else if ("限制访问的接口".equals(str)) {
            this.f4178f = 33;
        } else if ("requeust is null".equals(str)) {
            this.f4178f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f4178f = 2;
        } else if ("response is null".equals(str)) {
            this.f4178f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f4178f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f4178f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f4178f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f4178f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f4178f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f4178f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f4178f = 3;
        } else {
            this.f4178f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f4179g = 7;
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f4179g = 6;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f4179g = 2;
        } else {
            if (!"未知主机 - UnKnowHostException".equals(str)) {
                if (AMapException.ERROR_CONNECTION.equals(str)) {
                    this.f4179g = 6;
                    return;
                } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                    this.f4179g = 3;
                    return;
                }
            }
            this.f4179g = 9;
        }
    }

    /* renamed from: a */
    public final String m55008a() {
        return this.f4173a;
    }

    /* renamed from: b */
    public final String m55004b() {
        return this.f4176d;
    }

    /* renamed from: c */
    public final String m55003c() {
        return this.f4177e;
    }

    /* renamed from: d */
    public final String m55002d() {
        return this.f4174b;
    }

    /* renamed from: e */
    public final String m55001e() {
        return this.f4175c;
    }

    /* renamed from: f */
    public final int m55000f() {
        return this.f4178f;
    }

    /* renamed from: g */
    public final int m54999g() {
        return this.f4179g;
    }

    /* renamed from: h */
    public final int m54998h() {
        this.f4179g = 10;
        return 10;
    }

    /* renamed from: i */
    public final boolean m54997i() {
        return this.f4180h;
    }

    /* renamed from: j */
    public final void m54996j() {
        this.f4180h = true;
    }

    /* renamed from: a */
    public final void m55007a(int i) {
        this.f4178f = i;
    }

    /* renamed from: a */
    public final void m55006a(String str) {
        this.f4181i = str;
    }

    /* renamed from: a */
    public final void m55005a(Map<String, List<String>> map) {
        this.f4182j = map;
    }

    public AMapCoreException(String str, String str2, String str3) {
        this(str);
        this.f4174b = str2;
        this.f4175c = str3;
    }
}
