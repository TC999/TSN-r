package com.qq.e.comm.plugin.apkmanager.t.b;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.u.i;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends i {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final e f41898a = new e();
    }

    public static final e b() {
        return a.f41898a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "sdkServerReport";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        int optInt = d4.optInt("code", 0);
        JSONObject optJSONObject = d4.optJSONObject("paras");
        if (optJSONObject != null) {
            v.a(90002, null, Integer.valueOf(optInt), new com.qq.e.comm.plugin.n0.d(optJSONObject));
        }
    }
}
