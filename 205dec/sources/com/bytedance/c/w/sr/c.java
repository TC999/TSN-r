package com.bytedance.c.w.sr;

import android.content.Context;
import com.bytedance.c.w.b;
import com.bytedance.c.w.ux.c.e;
import com.bytedance.c.w.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f26570a;

    public c(Context context) {
        this.f26570a = context;
    }

    @Override // com.bytedance.c.w.sr.b
    public void a(long j4, Thread thread, Throwable th) {
        com.bytedance.c.w.xv.a c4 = com.bytedance.c.w.xv.a.c(j4, this.f26570a, thread, th);
        Context context = this.f26570a;
        xv xvVar = xv.JAVA;
        b.m.d(context, xvVar.c(), Thread.currentThread().getName());
        com.bytedance.c.w.r.a.a().b(e.a().c(xvVar, c4).j());
    }

    @Override // com.bytedance.c.w.sr.b
    public boolean c(Throwable th) {
        return true;
    }
}
