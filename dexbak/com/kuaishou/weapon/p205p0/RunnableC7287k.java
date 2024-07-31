package com.kuaishou.weapon.p205p0;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RunnableC7287k<T> implements Runnable {

    /* renamed from: a */
    private String f24959a;

    /* renamed from: b */
    private JSONObject f24960b;

    /* renamed from: c */
    private InterfaceC7285j f24961c;

    /* renamed from: d */
    private Context f24962d;

    /* renamed from: e */
    private String f24963e;

    /* renamed from: f */
    private String f24964f;

    public RunnableC7287k(Context context, String str, String str2, String str3, JSONObject jSONObject, InterfaceC7285j interfaceC7285j) {
        this.f24962d = context;
        this.f24959a = str3;
        this.f24960b = jSONObject;
        this.f24961c = interfaceC7285j;
        this.f24963e = str;
        this.f24964f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C7289l m33849a = C7289l.m33849a(this.f24962d);
            C7291m c7291m = new C7291m(this.f24959a, this.f24960b);
            c7291m.m33834a(this.f24963e);
            c7291m.m33832b(this.f24964f);
            m33849a.m33837b(c7291m, new InterfaceC7285j() { // from class: com.kuaishou.weapon.p0.k.1
                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: a */
                public void mo33851a(String str) {
                    C7280e.m33902c("WeaponHttpTask sendLog response: --- " + str);
                    if (RunnableC7287k.this.f24961c != null) {
                        RunnableC7287k.this.f24961c.mo33851a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: b */
                public void mo33850b(String str) {
                    C7280e.m33902c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (RunnableC7287k.this.f24961c != null) {
                        RunnableC7287k.this.f24961c.mo33850b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
