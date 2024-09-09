package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private String f3733a;

    /* renamed from: b  reason: collision with root package name */
    private String f3734b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f3735c;

    /* renamed from: d  reason: collision with root package name */
    private int f3736d;

    /* renamed from: e  reason: collision with root package name */
    private long f3737e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3738f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3739g;

    /* renamed from: h  reason: collision with root package name */
    private int f3740h;

    /* renamed from: i  reason: collision with root package name */
    private int f3741i;

    public HttpResponse() {
        this.f3740h = -1;
        this.f3741i = -1;
        this.f3735c = new HashMap();
    }

    public HttpResponse(String str) {
        this.f3740h = -1;
        this.f3741i = -1;
        this.f3733a = str;
        this.f3736d = 0;
        this.f3738f = false;
        this.f3739g = false;
        this.f3735c = new HashMap();
    }

    private int a() {
        int indexOf;
        try {
            String str = (String) this.f3735c.get("cache-control");
            if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("max-age=")) == -1) {
                return -1;
            }
            int indexOf2 = str.indexOf(",", indexOf);
            int i4 = indexOf + 8;
            return Integer.parseInt(indexOf2 != -1 ? str.substring(i4, indexOf2) : str.substring(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    private long b() {
        int a4 = a();
        if (a4 != -1) {
            return System.currentTimeMillis() + (a4 * 1000);
        }
        if (TextUtils.isEmpty(getExpiresHeader())) {
            return -1L;
        }
        return HttpUtils.parseGmtTime(getExpiresHeader());
    }

    public long getExpiredTime() {
        if (this.f3739g) {
            return this.f3737e;
        }
        this.f3739g = true;
        long b4 = b();
        this.f3737e = b4;
        return b4;
    }

    public String getExpiresHeader() {
        try {
            Map<String, Object> map = this.f3735c;
            if (map == null) {
                return null;
            }
            return (String) map.get("expires");
        } catch (Exception unused) {
            return null;
        }
    }

    public String getResponseBody() {
        return this.f3734b;
    }

    public int getResponseCode() {
        return this.f3740h;
    }

    public Map<String, Object> getResponseHeaders() {
        return this.f3735c;
    }

    public int getStatusCode() {
        return this.f3741i;
    }

    public int getType() {
        return this.f3736d;
    }

    public String getUrl() {
        return this.f3733a;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f3737e;
    }

    public boolean isInCache() {
        return this.f3738f;
    }

    public void setExpiredTime(long j4) {
        this.f3739g = true;
        this.f3737e = j4;
    }

    public HttpResponse setInCache(boolean z3) {
        this.f3738f = z3;
        return this;
    }

    public void setResponseBody(String str) {
        this.f3734b = str;
    }

    public void setResponseCode(int i4) {
        this.f3740h = i4;
    }

    public void setResponseHeader(String str, String str2) {
        Map<String, Object> map = this.f3735c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void setResponseHeaders(Map<String, Object> map) {
        this.f3735c = map;
    }

    public void setStatusCode(int i4) {
        this.f3741i = i4;
    }

    public void setType(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("The type of HttpResponse cannot be smaller than 0.");
        }
        this.f3736d = i4;
    }

    public void setUrl(String str) {
        this.f3733a = str;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f3734b + "', responseCode=" + this.f3740h + '}';
    }
}
