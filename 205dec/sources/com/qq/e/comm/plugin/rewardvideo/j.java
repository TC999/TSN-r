package com.qq.e.comm.plugin.rewardvideo;

import android.view.View;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o2;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j extends com.qq.e.comm.plugin.q0.u.j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f45970a = h.V;

    @Override // com.qq.e.comm.plugin.q0.u.j
    public com.qq.e.comm.plugin.q0.s.f<String> a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        String str = f45970a;
        d1.a(str, "RewardPageViewableJsHandler handleAction ,action : " + dVar.a());
        if ("isViewable".equals(dVar.a())) {
            return a(hVar.a());
        }
        return new com.qq.e.comm.plugin.q0.s.f<>(1000, "Unsupported action");
    }

    protected com.qq.e.comm.plugin.q0.s.f<String> a(View view) {
        if (view == null) {
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
        return a(o2.a(view.getContext(), view, 100));
    }

    public com.qq.e.comm.plugin.q0.s.f<String> a(boolean z3) {
        String str = f45970a;
        d1.a(str, "RewardPageViewableJsHandler isViewable : " + z3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", z3);
            return new com.qq.e.comm.plugin.q0.s.f<>(jSONObject.toString());
        } catch (Exception e4) {
            String str2 = f45970a;
            d1.a(str2, "RewardPageViewableJsHandler isViewable JSONException : " + e4.getMessage());
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
    }
}
