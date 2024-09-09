package com.bytedance.sdk.component.w.c.c;

import android.util.Log;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.c.w.xv;
import com.bytedance.sdk.component.xv.w.j;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f30377c;

    /* renamed from: w  reason: collision with root package name */
    private static AtomicBoolean f30378w = new AtomicBoolean(true);

    private c() {
    }

    public static c c() {
        if (f30377c == null) {
            synchronized (c.class) {
                if (f30377c == null) {
                    f30377c = new c();
                }
            }
        }
        return f30377c;
    }

    public boolean w() {
        AtomicBoolean atomicBoolean = f30378w;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public void c(boolean z3) {
        Log.i("NetClientAdapter", "set useOkHttp:" + z3);
        f30378w.set(z3);
    }

    public static a c(a.c cVar) {
        return new xv(cVar);
    }

    public static a c(j.c cVar) {
        return new com.bytedance.sdk.component.w.c.c.c.xv(cVar);
    }
}
