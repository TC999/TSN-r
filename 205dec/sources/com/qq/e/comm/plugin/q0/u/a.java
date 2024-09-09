package com.qq.e.comm.plugin.q0.u;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f45574a = new a();
    }

    public static final a b() {
        return b.f45574a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "adEvent";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        String optString = d4.optString("type", "");
        JSONObject optJSONObject = d4.optJSONObject("paras");
        if (!TextUtils.isEmpty(optString)) {
            com.qq.e.comm.plugin.q0.t.a a4 = com.qq.e.comm.plugin.q0.t.a.a(optString, optJSONObject);
            if (a4 != null) {
                hVar.a(a4);
                return;
            }
            return;
        }
        d1.a("Invoke ADEvent Handler with out evtType in paras");
    }

    private a() {
    }
}
