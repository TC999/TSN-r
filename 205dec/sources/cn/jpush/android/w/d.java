package cn.jpush.android.w;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f4496a;

    /* renamed from: b  reason: collision with root package name */
    private String f4497b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f4498c;

    /* renamed from: d  reason: collision with root package name */
    private int f4499d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4500e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4501f;

    /* renamed from: g  reason: collision with root package name */
    private int f4502g;

    /* renamed from: h  reason: collision with root package name */
    private int f4503h;

    public d() {
        this.f4502g = -1;
        this.f4503h = -1;
        this.f4498c = new HashMap();
    }

    public d(String str) {
        this.f4502g = -1;
        this.f4503h = -1;
        this.f4496a = str;
        this.f4499d = 0;
        this.f4500e = false;
        this.f4501f = false;
        this.f4498c = new HashMap();
    }

    public String a() {
        return this.f4497b;
    }

    public void a(int i4) {
        this.f4502g = i4;
    }

    public void a(String str) {
        this.f4497b = str;
    }

    public void a(String str, String str2) {
        Map<String, Object> map = this.f4498c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public int b() {
        return this.f4502g;
    }

    public void b(int i4) {
        this.f4503h = i4;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f4497b + "', responseCode=" + this.f4502g + '}';
    }
}
