package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.C2640by;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.cg */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2653cg extends AbstractRunnableC2710i {

    /* renamed from: b */
    final /* synthetic */ C2640by.InterfaceC2643c f8806b;

    /* renamed from: c */
    final /* synthetic */ Handler f8807c;

    /* renamed from: d */
    final /* synthetic */ C2640by f8808d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2653cg(C2640by c2640by, C2640by.InterfaceC2643c interfaceC2643c, Handler handler) {
        this.f8808d = c2640by;
        this.f8806b = interfaceC2643c;
        this.f8807c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractRunnableC2710i
    /* renamed from: i */
    protected Object mo50376i() {
        C2634bs c2634bs;
        SharedPreferences m50660m;
        try {
            synchronized (C2640by.class) {
                this.f8808d.m50687b(this.f8806b, this.f8807c);
            }
            m50660m = this.f8808d.m50660m();
            SharedPreferences.Editor edit = m50660m.edit();
            edit.putString(C2640by.f8766d, this.f8808d.m50706a());
            edit.apply();
            return null;
        } catch (Throwable th) {
            c2634bs = this.f8808d.f8791z;
            c2634bs.m50739a(C2640by.f8763a, th);
            return null;
        }
    }
}
