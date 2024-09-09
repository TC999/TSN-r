package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdCacheCannotUseInfo.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f393a;

    /* renamed from: b  reason: collision with root package name */
    private int f394b;

    /* renamed from: c  reason: collision with root package name */
    private String f395c;

    /* renamed from: d  reason: collision with root package name */
    private String f396d;

    /* renamed from: e  reason: collision with root package name */
    private int f397e;

    /* renamed from: f  reason: collision with root package name */
    private int f398f;

    /* renamed from: g  reason: collision with root package name */
    private int f399g;

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason", this.f393a);
            jSONObject.put("fill_error_code", this.f394b);
            jSONObject.put("fill_error_msg", this.f395c);
            jSONObject.put("mediation_rit", this.f396d);
            jSONObject.put("load_sort", this.f397e);
            jSONObject.put("show_sort", this.f398f);
            jSONObject.put("has_shown", this.f399g);
            return jSONObject.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return "{\"name\": \"json err\"}";
        }
    }

    public void b(int i4) {
        this.f399g = i4;
    }

    public void c(int i4) {
        this.f397e = i4;
    }

    public void d(int i4) {
        this.f393a = i4;
    }

    public void e(int i4) {
        this.f398f = i4;
    }

    public void b(String str) {
        this.f396d = str;
    }

    public void a(int i4) {
        this.f394b = i4;
    }

    public void a(String str) {
        this.f395c = str;
    }
}
