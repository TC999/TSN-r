package com.qq.e.comm.plugin.gdtnativead.p.b;

import android.view.View;
import com.qq.e.comm.plugin.gdtnativead.p.b.h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j extends com.qq.e.comm.plugin.q0.u.b {

    /* renamed from: c  reason: collision with root package name */
    private final h.a f43990c;

    public j(com.qq.e.comm.plugin.g0.e eVar, h.a aVar) {
        super(eVar);
        this.f43990c = aVar;
    }

    @Override // com.qq.e.comm.plugin.q0.u.b
    protected void a(View view, String str, long j4) {
        this.f43990c.a(view, str);
    }

    @Override // com.qq.e.comm.plugin.q0.u.b
    protected JSONObject c(View view) throws JSONException {
        return new JSONObject(this.f45576a.m());
    }

    @Override // com.qq.e.comm.plugin.q0.u.b
    protected com.qq.e.comm.plugin.q0.s.f<String> a() {
        this.f43990c.a();
        return new com.qq.e.comm.plugin.q0.s.f<>(null);
    }
}
