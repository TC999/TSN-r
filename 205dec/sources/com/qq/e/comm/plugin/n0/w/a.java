package com.qq.e.comm.plugin.n0.w;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends com.qq.e.comm.plugin.n0.c {
    public a(com.qq.e.comm.plugin.n0.c cVar) {
        super(cVar);
    }

    public a a(long j4) {
        a("cost_time", Long.valueOf(j4));
        return this;
    }

    public a b(boolean z3) {
        a("autodownload", Integer.valueOf(z3 ? 1 : 2));
        return this;
    }

    public a c(int i4) {
        a("actor", Integer.valueOf(i4));
        return this;
    }

    public a d(int i4) {
        a("actor_code", Integer.valueOf(i4));
        return this;
    }

    public a e(int i4) {
        a("dialog_type", Integer.valueOf(i4));
        return this;
    }

    public a f(int i4) {
        a("download_scene", Integer.valueOf(i4));
        return this;
    }
}
