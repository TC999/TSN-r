package com.qq.e.comm.plugin.i;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b0 implements o {

    /* renamed from: a  reason: collision with root package name */
    private String f44055a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f44056b;

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        com.qq.e.comm.plugin.g0.e eVar = hVar.C;
        this.f44056b = eVar;
        com.qq.e.comm.plugin.g0.b q3 = eVar.q();
        if (hVar.f44135h && q3 != null) {
            String e4 = q3.e();
            this.f44055a = e4;
            if (!TextUtils.isEmpty(e4)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        int b4 = com.qq.e.comm.plugin.apkmanager.k.e().b(this.f44055a);
        boolean z3 = i.a(hVar.D) || hVar.F;
        this.f44056b.a(z3);
        hVar.G = i.a(this.f44056b, z3, b4);
        return false;
    }
}
