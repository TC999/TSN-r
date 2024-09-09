package com.qq.e.comm.plugin.n0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.y;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final JSONObject f44733a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    private String f44734b;

    /* renamed from: c  reason: collision with root package name */
    private String f44735c;

    /* renamed from: d  reason: collision with root package name */
    private String f44736d;

    /* renamed from: e  reason: collision with root package name */
    private int f44737e;

    /* renamed from: f  reason: collision with root package name */
    private int f44738f;

    /* renamed from: g  reason: collision with root package name */
    private int f44739g;

    /* renamed from: h  reason: collision with root package name */
    private String f44740h;

    /* renamed from: i  reason: collision with root package name */
    private int f44741i;

    /* renamed from: j  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f44742j;

    public c() {
    }

    public static c a(com.qq.e.comm.plugin.g0.e eVar) {
        return a(eVar, (y) null);
    }

    public c b(com.qq.e.comm.plugin.g0.e eVar) {
        if (!TextUtils.isEmpty(eVar.k0())) {
            e(eVar.k0());
        } else {
            e(eVar.K0());
        }
        return this;
    }

    public c c(String str) {
        this.f44734b = str;
        a("pid", str);
        return this;
    }

    public int d() {
        return this.f44739g;
    }

    public String e() {
        return this.f44734b;
    }

    public int f() {
        return this.f44737e;
    }

    public int g() {
        return this.f44741i;
    }

    public String h() {
        return this.f44740h;
    }

    public String i() {
        return this.f44736d;
    }

    public JSONObject j() {
        if (this.f44733a.length() > 0) {
            return this.f44733a;
        }
        return null;
    }

    public String toString() {
        return this.f44733a.toString();
    }

    public static c a(com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        c cVar = new c();
        if (eVar != null) {
            cVar.f44742j = eVar;
            cVar.c(eVar.q0());
            cVar.a(eVar.k());
            cVar.b(eVar);
            cVar.a(eVar.g());
            cVar.a(eVar.o());
            cVar.a(eVar.l1() || eVar.M0() > 0);
            if (yVar != null) {
                cVar.d(yVar.j());
                cVar.b(3);
            } else {
                String G0 = eVar.G0();
                if (!TextUtils.isEmpty(G0)) {
                    cVar.d(G0);
                } else if (eVar.i0() != null) {
                    cVar.d(eVar.i0().j());
                }
                if (eVar.u0() != Integer.MIN_VALUE) {
                    cVar.b(eVar.u0());
                }
            }
            if (!TextUtils.isEmpty(eVar.a0())) {
                cVar.b(eVar.a0());
            }
        }
        return cVar;
    }

    public c d(String str) {
        if (str != null && str.length() <= 0) {
            str = null;
        }
        this.f44740h = str;
        a("tid", str);
        return this;
    }

    public c e(String str) {
        this.f44736d = str;
        a("traceid", str);
        return this;
    }

    public c(c cVar) {
        if (cVar == null) {
            return;
        }
        JSONObject j4 = cVar.j();
        if (j4 != null) {
            Iterator<String> keys = j4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a(next, j4.opt(next));
            }
        }
        this.f44734b = cVar.f44734b;
        this.f44735c = cVar.f44735c;
        this.f44736d = cVar.f44736d;
        this.f44737e = cVar.f44737e;
        this.f44738f = cVar.f44738f;
        this.f44739g = cVar.f44739g;
        this.f44740h = cVar.f44740h;
        this.f44741i = cVar.f44741i;
        this.f44742j = cVar.f44742j;
    }

    public String c() {
        return this.f44735c;
    }

    public int b() {
        return this.f44738f;
    }

    public c b(int i4) {
        this.f44741i = i4;
        a("rt", Integer.valueOf(i4));
        return this;
    }

    public c b(String str) {
        a("inex", str);
        return this;
    }

    public c a(String str) {
        this.f44735c = str;
        a("aid", str);
        return this;
    }

    public c a(JSONObject jSONObject) {
        String optString = jSONObject.optString("netlog_traceid");
        if (!TextUtils.isEmpty(optString)) {
            e(optString);
        } else {
            e(jSONObject.optString("traceid"));
        }
        return this;
    }

    public c a(int i4) {
        this.f44737e = i4;
        a("pt", Integer.valueOf(i4));
        return this;
    }

    public c a(com.qq.e.comm.plugin.b.g gVar) {
        if (gVar != null) {
            int i4 = gVar.f42000e;
            this.f44738f = i4;
            a("adt", Integer.valueOf(i4));
        }
        return this;
    }

    public c a(boolean z3) {
        int i4 = z3 ? 2 : 1;
        this.f44739g = i4;
        a("vdo", Integer.valueOf(i4));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        try {
            this.f44733a.put(str, obj);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public com.qq.e.comm.plugin.g0.e a() {
        return this.f44742j;
    }
}
