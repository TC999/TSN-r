package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    int f43738a;

    /* renamed from: b  reason: collision with root package name */
    String f43739b;

    /* renamed from: c  reason: collision with root package name */
    String f43740c;

    /* renamed from: d  reason: collision with root package name */
    int f43741d;

    /* renamed from: e  reason: collision with root package name */
    n f43742e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f43743f;

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f43744g;

    /* renamed from: h  reason: collision with root package name */
    private String f43745h;

    /* renamed from: i  reason: collision with root package name */
    private int f43746i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f43747j;

    public y(JSONObject jSONObject) {
        this.f43747j = -1;
        this.f43744g = jSONObject;
        z.a(this, jSONObject);
        this.f43746i = TextUtils.isEmpty(this.f43740c) ? 4 : 1;
    }

    private void a() {
        this.f43743f = null;
        this.f43740c = null;
    }

    public JSONArray b() {
        return this.f43742e.f43722c.f43606m;
    }

    public float c() {
        return (float) this.f43742e.f43722c.f43600g;
    }

    public int d() {
        return this.f43742e.f43722c.f43594a;
    }

    public int e() {
        return this.f43742e.f43722c.f43598e;
    }

    public int f() {
        return this.f43742e.f43722c.f43595b;
    }

    public int g() {
        return this.f43742e.f43722c.f43603j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f43742e.f43722c.f43601h;
    }

    public String i() {
        return this.f43742e.f43722c.f43608o;
    }

    public final String j() {
        return this.f43739b;
    }

    public final int k() {
        return this.f43746i;
    }

    public int l() {
        return this.f43742e.f43722c.f43597d;
    }

    public int m() {
        return this.f43741d;
    }

    public String n() {
        if (TextUtils.isEmpty(this.f43745h)) {
            if (this.f43744g == null) {
                com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
                j0Var.a("id", this.f43739b);
                if (!TextUtils.isEmpty(this.f43740c)) {
                    j0Var.a("data", this.f43740c);
                }
                this.f43744g = j0Var.a();
            }
            this.f43745h = this.f43744g.toString();
        }
        return this.f43745h;
    }

    public int o() {
        return this.f43742e.f43722c.f43605l;
    }

    public int p() {
        return this.f43742e.f43722c.f43610q;
    }

    public String q() {
        return this.f43742e.f43722c.f43607n;
    }

    public final String r() {
        if (this.f43743f == null && !TextUtils.isEmpty(this.f43740c)) {
            synchronized (this) {
                if (this.f43743f == null && !TextUtils.isEmpty(this.f43740c)) {
                    try {
                        this.f43743f = o1.b(this.f43740c);
                        if (TextUtils.isEmpty(this.f43743f)) {
                            this.f43747j = 7;
                            a();
                        } else {
                            this.f43743f = new JSONObject(this.f43743f).optString("origin_data");
                            d1.a("tpl_info_native", this.f43743f);
                        }
                    } catch (Exception e4) {
                        this.f43747j = e4 instanceof JSONException ? 9 : 8;
                        a();
                    }
                }
            }
        }
        return this.f43743f;
    }

    public final int s() {
        return this.f43738a;
    }

    public boolean t() {
        return this.f43742e.f43721b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return this.f43742e.f43722c.f43599f;
    }

    public boolean v() {
        return this.f43741d == 2;
    }

    public boolean w() {
        return this.f43742e.f43720a;
    }

    public boolean x() {
        return this.f43742e.f43722c.f43609p;
    }

    public boolean y() {
        return this.f43742e.f43722c.f43602i;
    }

    public boolean z() {
        return TextUtils.isEmpty(this.f43743f) && TextUtils.isEmpty(this.f43740c);
    }

    public y(String str) {
        this.f43747j = -1;
        this.f43739b = str;
        this.f43746i = 2;
    }

    public y(JSONObject jSONObject, int i4) {
        this(jSONObject);
        this.f43746i = i4;
    }

    public y(String str, int i4) {
        this.f43747j = -1;
        this.f43739b = str;
        this.f43738a = i4;
        this.f43746i = 4;
    }
}
