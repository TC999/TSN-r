package com.qq.e.comm.plugin.n0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.j0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f44729a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f44730b;

    /* renamed from: c  reason: collision with root package name */
    private c f44731c;

    /* renamed from: d  reason: collision with root package name */
    private d f44732d;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(String str) {
        JSONObject a4 = j0.a(str).a();
        this.f44730b = a4;
        this.f44729a = a4.optInt(d());
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.f44732d = dVar;
            a("ext", dVar.a());
        }
    }

    public d b() {
        return this.f44732d;
    }

    public int c() {
        return this.f44729a;
    }

    protected abstract String d();

    public JSONObject e() {
        return this.f44730b;
    }

    public String toString() {
        return this.f44730b.toString();
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.f44731c = cVar;
            a("biz", cVar.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i4) {
        this.f44730b = new JSONObject();
        this.f44729a = i4;
        a(d(), Integer.valueOf(i4));
    }

    public c a() {
        return this.f44731c;
    }

    public void a(String str) {
        a("ep", str);
    }

    void a(int i4) {
        a("seq", Integer.valueOf(i4));
    }

    void a(long j4) {
        a("ts", Long.valueOf(j4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            this.f44730b.put(str, obj);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
