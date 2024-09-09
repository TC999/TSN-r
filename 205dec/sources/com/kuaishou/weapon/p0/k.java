package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class k<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f38355a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f38356b;

    /* renamed from: c  reason: collision with root package name */
    private j f38357c;

    /* renamed from: d  reason: collision with root package name */
    private Context f38358d;

    /* renamed from: e  reason: collision with root package name */
    private String f38359e;

    /* renamed from: f  reason: collision with root package name */
    private String f38360f;

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.f38358d = context;
        this.f38355a = str3;
        this.f38356b = jSONObject;
        this.f38357c = jVar;
        this.f38359e = str;
        this.f38360f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l a4 = l.a(this.f38358d);
            m mVar = new m(this.f38355a, this.f38356b);
            mVar.a(this.f38359e);
            mVar.b(this.f38360f);
            a4.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f38357c != null) {
                        k.this.f38357c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f38357c != null) {
                        k.this.f38357c.b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
