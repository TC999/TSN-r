package com.qq.e.comm.plugin.gdtnativead;

import android.graphics.Rect;
import android.view.View;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private j f43894a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.b f43895b;

    public l(j jVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        this.f43894a = jVar;
        this.f43895b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.b.h a4 = a();
        String optString = jSONObject.optString("action");
        com.qq.e.comm.plugin.g0.e eVar = this.f43894a.f43840k;
        if (a(optString)) {
            String G = this.f43894a.G();
            com.qq.e.comm.plugin.i.g.b(new h.b(eVar).a(a4).a(G).a(), this.f43895b);
            l1.a(this.f43894a.f43821L, eVar, G);
        } else {
            j jVar = this.f43894a;
            if (jVar.f43858y == 1) {
                String G2 = jVar.G();
                com.qq.e.comm.plugin.i.g.a(new h.b(eVar).a(a4).a(G2).a(this.f43894a.s()).a(), this.f43895b);
                l1.a(this.f43894a.f43821L, eVar, G2);
            }
        }
        j jVar2 = this.f43894a;
        jVar2.a(105, new Object[]{jVar2.f43834h});
    }

    private boolean a(String str) {
        return str.equals(String.valueOf(1)) || str.equals(String.valueOf(2)) || str.equals(String.valueOf(3));
    }

    private com.qq.e.comm.plugin.b.h a() {
        com.qq.e.comm.plugin.q0.h hVar = this.f43894a.f43828e;
        if (hVar == null) {
            GDTLogger.e("\u70b9\u51fb\u51fa\u73b0\u5f02\u5e38\uff0c\u5e7f\u544aView\u4e3a\u7a7a");
            v.a(100332, this.f43894a.f43822a0);
            return null;
        }
        View a4 = hVar.a();
        if (a4 == null) {
            return null;
        }
        Rect rect = new Rect();
        if (a4.getGlobalVisibleRect(rect)) {
            return new com.qq.e.comm.plugin.b.h(true, a4.getWidth(), a4.getHeight(), rect.width(), rect.height(), a4.toString());
        }
        d1.a("Ad is not visible.", new Object[0]);
        return null;
    }
}
