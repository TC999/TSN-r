package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    private String f3717a;

    /* renamed from: b  reason: collision with root package name */
    private String f3718b;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f3721e;

    /* renamed from: g  reason: collision with root package name */
    private Object f3723g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3724h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3725i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3726j;

    /* renamed from: n  reason: collision with root package name */
    private X509TrustManager f3730n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f3731o;

    /* renamed from: p  reason: collision with root package name */
    private HostnameVerifier f3732p;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3727k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3728l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3729m = false;

    /* renamed from: c  reason: collision with root package name */
    private int f3719c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f3720d = -1;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f3722f = new HashMap();

    public HttpRequest(String str) {
        this.f3717a = str;
    }

    public HttpRequest(String str, Map<String, String> map) {
        this.f3717a = str;
        this.f3721e = map;
    }

    public Object getBody() {
        return this.f3723g;
    }

    public int getConnectTimeout() {
        return this.f3719c;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f3732p;
    }

    public byte[] getParas() {
        Object obj = this.f3723g;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f3723g).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String joinParasWithEncodedValue = HttpUtils.joinParasWithEncodedValue(this.f3721e);
        if (TextUtils.isEmpty(joinParasWithEncodedValue)) {
            return null;
        }
        return joinParasWithEncodedValue.getBytes();
    }

    public Map<String, String> getParasMap() {
        return this.f3721e;
    }

    public int getReadTimeout() {
        return this.f3720d;
    }

    public Map<String, String> getRequestProperties() {
        return this.f3722f;
    }

    public String getRequestProperty(String str) {
        return this.f3722f.get(str);
    }

    public X509TrustManager getSslTrustManager() {
        return this.f3730n;
    }

    public String getType() {
        return this.f3718b;
    }

    public String getUrl() {
        return this.f3717a;
    }

    public boolean isDoInPut() {
        return this.f3725i;
    }

    public boolean isDoOutPut() {
        return this.f3724h;
    }

    public boolean isHaveRspData() {
        return this.f3727k;
    }

    public boolean isNeedErrorInput() {
        return this.f3729m;
    }

    public boolean isNeedRetryIfHttpsFailed() {
        return this.f3731o;
    }

    public boolean isRspDatazip() {
        return this.f3728l;
    }

    public boolean isUseCaches() {
        return this.f3726j;
    }

    public void setBody(Object obj) {
        this.f3723g = obj;
    }

    public void setConnectTimeout(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f3719c = i4;
    }

    public void setDoInPut(boolean z3) {
        this.f3725i = z3;
    }

    public void setDoOutPut(boolean z3) {
        this.f3724h = z3;
    }

    public void setHaveRspData(boolean z3) {
        this.f3727k = z3;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f3732p = hostnameVerifier;
    }

    public void setNeedErrorInput(boolean z3) {
        this.f3729m = z3;
    }

    public void setNeedRetryIfHttpsFailed(boolean z3) {
        this.f3731o = z3;
    }

    public void setParasMap(Map<String, String> map) {
        this.f3721e = map;
    }

    public void setReadTimeout(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f3720d = i4;
    }

    public void setRequestProperties(Map<String, String> map) {
        this.f3722f = map;
    }

    public void setRequestProperty(String str, String str2) {
        this.f3722f.put(str, str2);
    }

    public void setRspDatazip(boolean z3) {
        this.f3728l = z3;
    }

    public void setSslTrustManager(X509TrustManager x509TrustManager) {
        this.f3730n = x509TrustManager;
    }

    public void setType(String str) {
        this.f3718b = str;
    }

    public void setUrl(String str) {
        this.f3717a = str;
    }

    public void setUseCaches(boolean z3) {
        this.f3726j = z3;
    }

    public void setUserAgent(String str) {
        this.f3722f.put("User-Agent", str);
    }
}
