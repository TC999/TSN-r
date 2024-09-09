package com.qq.e.dl.l;

import android.text.TextUtils;
import com.qq.e.dl.l.h;
import com.qq.e.dl.l.k.e.b;
import com.qq.e.dl.l.k.f.c;
import com.qq.e.dl.l.k.g.c;
import com.qq.e.dl.l.m.a.b;
import com.qq.e.dl.l.m.b.b;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, h.e> f47064a = new HashMap<>();

    public g() {
        a("GDTDLTextView", new b.a());
        a("GDTDLImageView", new b.a());
        a("GDTDLLinearLayout", new c.a());
        a("GDTDLFrameLayout", new b.a());
        a("1", new b.a());
        a("2", new c.a());
        a("3", new b.a());
        a("4", new b.a());
        a("5", new c.b());
    }

    public com.qq.e.dl.l.l.b a(com.qq.e.dl.a aVar, com.qq.e.dl.i.b bVar, JSONObject jSONObject) {
        if (bVar != null && bVar.f46933b != null && !TextUtils.isEmpty(bVar.f46932a)) {
            com.qq.e.dl.l.l.d dVar = new com.qq.e.dl.l.l.d(aVar);
            dVar.b(bVar.f46933b.f46983k);
            h a4 = a(aVar, dVar, bVar.f46933b, jSONObject);
            if (a4 != null) {
                dVar.a(a4);
                return dVar;
            }
            com.qq.e.dl.j.e.a("ViewFactory", "inflate: fail to inflate, vb is null");
        }
        return null;
    }

    public h a(com.qq.e.dl.a aVar, com.qq.e.dl.l.l.d dVar, com.qq.e.dl.i.g gVar, JSONObject jSONObject) {
        h.e eVar = this.f47064a.get(gVar.f46973a);
        h a4 = eVar == null ? null : eVar.a(aVar);
        if (a4 == null) {
            return null;
        }
        a4.a(dVar);
        a4.a(gVar, this, jSONObject);
        if (gVar.f46974b != null && (a4 instanceof com.qq.e.dl.l.k.d)) {
            com.qq.e.dl.l.k.d dVar2 = (com.qq.e.dl.l.k.d) a4;
            if (!dVar2.v()) {
                for (com.qq.e.dl.i.g gVar2 : gVar.f46974b) {
                    h a5 = a(aVar, dVar, gVar2, jSONObject);
                    if (a5 != null) {
                        dVar2.b(a5);
                    }
                }
            }
        }
        return a4;
    }

    public void a(String str, h.e eVar) {
        this.f47064a.put(str, eVar);
    }
}
