package com.qq.e.comm.plugin.q0.u;

import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final c f45577a = new c();
    }

    public static c b() {
        return b.f45577a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "loadURL";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 != null && d4.has("url")) {
            a(hVar, d4.optString("url"), d4.optString("browsertype"));
            return;
        }
        d1.a("InvokeBrowserHandler with illegal paras,request:" + dVar);
    }

    private c() {
    }

    public void a(com.qq.e.comm.plugin.q0.h hVar, String str, String str2) {
        if ("innerbrowser".equals(str2)) {
            com.qq.e.comm.plugin.i.d.b(str, null);
        } else if ("website".equals(str2)) {
            com.qq.e.comm.plugin.i.d.b(str);
        } else if ("loadurl".equals(str2)) {
            hVar.loadUrl(str);
        } else {
            com.qq.e.comm.plugin.i.d.b(str);
        }
    }
}
