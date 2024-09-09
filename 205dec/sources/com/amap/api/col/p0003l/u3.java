package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ApsServiceCore.java */
/* renamed from: com.amap.api.col.3l.u3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u3 {

    /* renamed from: a  reason: collision with root package name */
    d3 f9140a;

    /* renamed from: b  reason: collision with root package name */
    Context f9141b;

    /* renamed from: c  reason: collision with root package name */
    Messenger f9142c = null;

    public u3(Context context) {
        this.f9140a = null;
        this.f9141b = null;
        this.f9141b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f9140a = new d3(this.f9141b);
    }

    public final IBinder a(Intent intent) {
        this.f9140a.w(intent);
        this.f9140a.d(intent);
        Messenger messenger = new Messenger(this.f9140a.s());
        this.f9142c = messenger;
        return messenger.getBinder();
    }

    public final void b() {
        try {
            d3.E();
            this.f9140a.f7410q = j.b();
            this.f9140a.f7411r = j.a();
            this.f9140a.c();
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final int c() {
        d3 d3Var = this.f9140a;
        return (d3Var == null || d3Var.f7419z.isSelfStartServiceEnable()) ? 3 : 2;
    }

    public final void d() {
        try {
            d3 d3Var = this.f9140a;
            if (d3Var != null) {
                d3Var.s().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
