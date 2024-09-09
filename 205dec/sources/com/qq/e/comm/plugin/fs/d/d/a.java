package com.qq.e.comm.plugin.fs.d.d;

import android.content.Context;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected com.qq.e.comm.plugin.g0.e f43240a;

    public a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f43240a = eVar;
    }

    public abstract void a(Context context);

    public abstract boolean a();

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract int e();

    public abstract long f();

    public String g() {
        return this.f43240a.l0();
    }

    public abstract int h();

    public boolean i() {
        return com.qq.e.comm.plugin.d0.a.d().c().x();
    }

    public abstract boolean j();

    public abstract boolean k();

    public boolean l() {
        try {
            return true ^ com.qq.e.comm.plugin.gdtnativead.d.a(this.f43240a.q0()).optBoolean("autoPlayMuted", true);
        } catch (Exception e4) {
            d1.a("Get video options error: " + e4.getMessage());
            return true;
        }
    }

    public abstract boolean m();

    public abstract boolean n();

    public abstract boolean o();

    public abstract boolean p();

    public abstract void q();

    public abstract void r();

    public abstract boolean s();
}
