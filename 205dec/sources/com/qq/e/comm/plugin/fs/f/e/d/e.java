package com.qq.e.comm.plugin.fs.f.e.d;

import android.view.View;
import com.qq.e.comm.plugin.b.k;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.rewardvideo.q;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends com.qq.e.comm.plugin.q0.u.b {

    /* renamed from: c  reason: collision with root package name */
    private final a f43441c;

    public e(com.qq.e.comm.plugin.g0.e eVar, a aVar) {
        super(eVar);
        this.f43441c = aVar;
    }

    @Override // com.qq.e.comm.plugin.q0.u.b
    protected void a(View view, String str, long j4) {
        com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(this.f45576a);
        fVar.f44105b = str;
        fVar.f44107d = j4 > 0;
        this.f43441c.a(fVar, false);
        v.a(9120027, com.qq.e.comm.plugin.n0.c.a(this.f45576a), Integer.valueOf(k.a(k.c.END_CARD, this.f45576a).f42017b));
    }

    @Override // com.qq.e.comm.plugin.q0.u.b
    public JSONObject c(View view) throws JSONException {
        return q.a(view.getContext(), this.f45576a);
    }

    @Override // com.qq.e.comm.plugin.q0.u.b
    public com.qq.e.comm.plugin.q0.s.f<String> a() {
        return new com.qq.e.comm.plugin.q0.s.f<>(1000, "Unsupported action");
    }
}
